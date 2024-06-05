package controller;

import BO.ProductBo;
import dto.CustomerDto;
import dto.ProductDto;
import dto.tm.CustomerTm;
import dto.tm.ProductTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {

    public Button refreshBtn;
    public Button updateProductBtn;
    public TableView tblProduct;
    public Button clearFieldBtn;
    @FXML
    private TextField productName;

    @FXML
    private TextField productRemarks;

    @FXML
    private TextField unitPrice;

    @FXML
    private TextField unitType;

    @FXML
    private Button addProductBtn;

    @FXML
    private TextField searchProductField;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button clearAllBtn;

    @FXML
    private TableColumn<?, ?> tblProductId;

    @FXML
    private TableColumn<?, ?> tblProductName;

    @FXML
    private TableColumn<?, ?> tblUnitPrice;

    @FXML
    private TableColumn<?, ?> tblUnitType;

    @FXML
    private TableColumn<?, ?> tblRemarks;

    @FXML
    private TableColumn<?, ?> tblAction;
    private ProductBo productBo = new ProductBo();



    public void addProductBtnOnaction(javafx.event.ActionEvent actionEvent) {
        ProductDto dto = new ProductDto(0,
                productName.getText(),
                Double.parseDouble(unitPrice.getText()),
                unitType.getText(),
                productRemarks.getText());

        if(productBo.save(dto)){
            new Alert(Alert.AlertType.INFORMATION,"Product Added!").show();
            loadProductTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Product Added Unsuccessful").show();
        }
    }

    public void searchProductFieldOnaction(javafx.event.ActionEvent actionEvent) {
        String searchName = searchProductField.getText();
        ObservableList<ProductTm> filterTmList = FXCollections.observableArrayList();
        for(ProductTm productTm: tmList){
            if(productTm.getProductName().equalsIgnoreCase(searchName.toLowerCase())){
                filterTmList.add(productTm);
            }
        }
        tblProduct.setItems(filterTmList);
    }

    public void goBackBtnOnaction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }



    public void updateProductBtnOnaction(javafx.event.ActionEvent actionEvent) {
        ProductDto dto = new ProductDto(0,
                productName.getText(),
                Double.parseDouble(unitPrice.getText()),
                unitPrice.getText(),
                productRemarks.getText());

        if(productBo.update(dto)){
            new Alert(Alert.AlertType.INFORMATION,"Product Updated!").show();
            loadProductTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Product Updated Unsuccessful").show();
        }
    }

    private ObservableList<ProductTm> tmList = FXCollections.observableArrayList();
    private void loadProductTable() {
        tmList = FXCollections.observableArrayList();

        List<ProductDto> dtoList  = productBo.all();
        for (ProductDto dto:dtoList) {
            Button btn = new Button("Delete");
            ProductTm c = new ProductTm(
                    dto.getProductId(),
                    dto.getProductName(),
                    dto.getUnitPrice(),
                    dto.getUnitType(),
                    dto.getRemarks(),
                    btn
            );

            btn.setOnAction(actionEvent -> {
                deleteCustomer(dto);
            });

            tmList.add(c);
        }
        tblProduct.setItems(tmList);
    }

    private void deleteCustomer(ProductDto dto) {

        boolean isDeleted = productBo.delete(dto);
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!").show();
            loadProductTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblUnitType.setCellValueFactory(new PropertyValueFactory<>("unitType"));
        tblRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        tblAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadProductTable();

        tblProduct.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((CustomerTm) newValue);
        });
    }

    private void setData(CustomerTm newValue) {
        if (newValue != null) {
            productName.setText(newValue.getCustomerName());
            unitPrice.setText(newValue.getPhoneNumber());
            unitType.setText(newValue.getNic());
            productRemarks.setText(newValue.getRemarks());
        }
    }

    public void onMouseClickAction(MouseEvent mouseEvent) {

    }

    private void clearFields() {
        tblProduct.refresh();
        productName.clear();
        unitPrice.clear();
        unitType.clear();
        productRemarks.clear();
    }

    public void clearFieldBtnOnaction(ActionEvent actionEvent) {
        clearFields();
    }

    public void refreshBtnOnaction(ActionEvent actionEvent) {
        loadProductTable();
        searchProductField.clear();
    }
}
