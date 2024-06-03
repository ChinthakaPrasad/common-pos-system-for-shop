package controller;

import BO.CustomerBo;
import BO.OrderBo;
import BO.OrderDetailBo;
import BO.ProductBo;
import dto.CustomerDto;
import dto.OrderItemDetailDto;
import dto.OrderDto;
import dto.ProductDto;
import dto.tm.CustomerTm;
import dto.tm.OrderProductTm;
import dto.tm.ProductTm;
import entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

    public ComboBox cmbCustomer;
    public ComboBox cmbProduct;
    public TextField unitType;
    public TextField productRemark;
    public TableColumn tblRemarks;
    public TableView tblProduct;
    public Label lblTotalAmount;
    public TextField unitPrice;
    @FXML
    private TextField productName;

    @FXML
    private TextField productQty;

    @FXML
    private TextField customerName;

    @FXML
    private TextField productDiscount;

    @FXML
    private Button addtocartBtn;

    @FXML
    private TableColumn<?, ?> tblCustomerName;

    @FXML
    private TableColumn<?, ?> tblProductName;

    @FXML
    private TableColumn<?, ?> tblProductQty;

    @FXML
    private TableColumn<?, ?> tblDiscount;

    @FXML
    private TableColumn<?, ?> tblPrice;

    @FXML
    private TableColumn<?, ?> tblActions;

    @FXML
    private Button placeOrderBtn;

    @FXML
    private Button clearAllBtn;

    @FXML
    private Button goBackBtn;


    @FXML
    void goBackBtnOnaction(ActionEvent event) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

    }

    private OrderBo orderBo = new OrderBo();
    private OrderDetailBo orderDetailBo = new OrderDetailBo();


    public void placeOrderBtnOnaction(javafx.event.ActionEvent actionEvent) {
        List<OrderItemDetailDto> orderItemDetailDtoList = new ArrayList<>();

        for (OrderProductTm tm:tmList){
            OrderItemDetailDto dto = new OrderItemDetailDto(
                orderBo.getOrderId()+1,
                tm.getProductId(),
                tm.getAmount(),
                tm.getQty()
            );

            orderItemDetailDtoList.add(dto);

        }
        OrderDto orderDto = new OrderDto(
                orderBo.getOrderId(),
                cmbCustomer.getValue().toString(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")),
                orderItemDetailDtoList
        );

        if(orderBo.save(orderDto)){
            new Alert(Alert.AlertType.INFORMATION,"Order Completed!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Order Unsuccessfull").show();
        }

        

}

    public void clearAllBtnOnaction(javafx.event.ActionEvent actionEvent) {
    }

    public void goBackBtnOnaction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    private List<OrderProductTm> itemList = new ArrayList<>();
    private CustomerBo customerBo = new CustomerBo();
    private ProductBo productBo = new ProductBo();
    private List<CustomerDto> customers;
    private List<ProductDto> products;

    ObservableList<OrderProductTm> tmList = FXCollections.observableArrayList();
    Double totalAmount =0d ;


    public void addtocartBtnOnaction(javafx.event.ActionEvent actionEvent) {
        Button btn = new Button("Delete");
        ProductDto newDto = null;

        for (ProductDto dto:products){
            if(cmbProduct.getValue().toString() == dto.getProductName()){
                newDto = dto;
                break;
            }
        }

        OrderProductTm item = new OrderProductTm(
                newDto.getProductId(),
                newDto.getProductName(),
                Double.parseDouble(productQty.getText()),
                Double.parseDouble(productDiscount.getText()),
                Double.parseDouble(productQty.getText())*Double.parseDouble(unitPrice.getText())-Double.parseDouble(productDiscount.getText()),
                productRemark.getText(),
                btn
        );

        btn.setOnAction(actionEvent1 -> {
            tmList.remove(item);
            totalAmount -= item.getAmount();
            lblTotalAmount.setText(String.format("%.2f",totalAmount));
            tblProduct.refresh();
        });

        Boolean isAdded = false;
        for(OrderProductTm tm:tmList){
            if(tm.getProductId() == item.getProductId()){
                totalAmount += item.getAmount();
                tm.setQty(tm.getQty()+ item.getQty());
                tm.setAmount(tm.getAmount()+ item.getAmount());
                tm.setDiscount(tm.getDiscount()+ item.getDiscount());
                tm.setRemarks(tm.getRemarks()+"/"+item.getRemarks());
                isAdded = true;
            }
        }

        if(!isAdded){
            tmList.add(item);
            totalAmount += item.getAmount()- item.getDiscount();
        }
        lblTotalAmount.setText(String.format("%.2f",totalAmount));

        tblProduct.setItems(tmList);
        tblProduct.refresh();


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tblProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblProductQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblDiscount.setCellValueFactory(new PropertyValueFactory<>("discount"));
        tblPrice.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tblRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        tblActions.setCellValueFactory(new PropertyValueFactory<>("btn"));

        customers = customerBo.all();
        products = productBo.all();

        loadCustomers();
        loadProducts();

        cmbProduct.getSelectionModel().selectedItemProperty().addListener((observableValue, o, newValue) -> {
            for (ProductDto dto:products) {
                if (String.valueOf(dto.getProductName()).equals(newValue.toString())){
                    unitType.setText(dto.getUnitType());
                    unitPrice.setText(String.valueOf(dto.getUnitPrice()));
                }
            }
        });
    }
    private void loadProducts() {
        ObservableList list = FXCollections.observableArrayList();

        for (ProductDto dto:products) {
            list.add(dto.getProductName());
        }

        cmbProduct.setItems(list);
    }

    private void loadCustomers(){
        ObservableList list = FXCollections.observableArrayList();

        for(CustomerDto dto:customers){
            list.add(dto.getCustomerName());
        }

        cmbCustomer.setItems(list);
    }

}
