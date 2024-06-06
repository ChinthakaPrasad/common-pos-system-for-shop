package controller;

import BO.CustomerBo;
import BO.OrderBo;
import dto.CustomerDto;
import dto.OrderDto;
import dto.tm.CustomerTm;
import dto.tm.OrderTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReportFormController implements Initializable {
    public Button goBackBtn;
    public TableColumn colOrderId;
    public TableColumn colCustomerName;
    public TableColumn colTotalPrice;
    public TableColumn colBroughtDate;
    public TableColumn colAction;
    public TableView tblOrders;
    public ComboBox cmbCustomerName;
    public Button refreshBtn;
    public DatePicker datePicker;
    public Button viewStatisticBtn;

    private OrderBo orderBo = new OrderBo();

    public void goBackBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<OrderTm> tmList;
    public void loadOrderTable(){
        tmList = FXCollections.observableArrayList();
        List<OrderDto> orderDtoList = orderBo.all();


        for(OrderDto orderDto : orderDtoList){
            Button btn = new Button("View");
            OrderTm orderTm = new OrderTm(
                    orderDto.getOrderId(),
                    orderDto.getCustomerName(),
                    orderDto.getTotalPrice(),
                    orderDto.getDate(),
                    btn,
                    orderDto.getOrderItemDetails()
            );

            btn.setOnAction(actionEvent -> {
                Stage newWindow = new Stage();
                newWindow.setTitle("View Items");
                newWindow.setResizable(false);
                newWindow.centerOnScreen();

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/viewOrderItemForm.fxml"));
                    Parent root = loader.load();
                    newWindow.setScene(new Scene(root));
                    ViewOrderItemFormController controller = loader.getController();
                    controller.loadItemTable(orderTm);
                    newWindow.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            tmList.add(orderTm);

        }
        tblOrders.setItems(tmList);
        for(OrderTm tm : tmList){
            System.out.println(tm.getView());
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colTotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        colBroughtDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("view"));
        loadOrderTable();
        //loadCustomers();
    }

    private CustomerBo customerBo = new CustomerBo();
    private void loadCustomers(){
        ObservableList list = FXCollections.observableArrayList();

        List<CustomerDto> customerDtoList = customerBo.all();
        for(CustomerDto customerDto: customerDtoList){
            list.add(customerDto.getCustomerName());
        }
        
        cmbCustomerName.setItems(list);

    }

    public void cmbCustomerNameOnaction(ActionEvent actionEvent) {
        if(cmbCustomerName.getValue()!=null){
            String selectCustomer = cmbCustomerName.getValue().toString();
            ObservableList<OrderTm> list = FXCollections.observableArrayList();
            for (OrderTm orderTm:tmList){
                if(orderTm.getCustomerName().equalsIgnoreCase(selectCustomer.toLowerCase())){
                    list.add(orderTm);
                }
            }
            tblOrders.setItems(list);
        }

    }

    public void refreshBtnOnaction(ActionEvent actionEvent) {
        loadOrderTable();
        cmbCustomerName.setValue(null);

    }

    public void datePickerOnaction(ActionEvent actionEvent) {
        ObservableList<OrderTm> list = FXCollections.observableArrayList();
        String date = datePicker.getValue().toString();
        for(OrderTm orderTm:list){
            if(date.equalsIgnoreCase(orderTm.getDate().toLowerCase())){
                list.add(orderTm);
            }
        }
        tblOrders.setItems(list);
    }

    public void viewStatisticBtnOnaction(ActionEvent actionEvent) {
        Stage newWindow = new Stage();
        newWindow.setTitle("View Statistics");
        newWindow.setResizable(false);
        newWindow.centerOnScreen();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/viewStatisticForm.fxml"));
            Parent root = loader.load();
            newWindow.setScene(new Scene(root));
            newWindow.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
