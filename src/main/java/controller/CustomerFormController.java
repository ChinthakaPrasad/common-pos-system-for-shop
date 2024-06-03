package controller;

import BO.CustomerBo;
import dao.CustomerDao;
import dto.CustomerDto;
import dto.tm.CustomerTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {
    public TextField custName;
    public TextField custRemarks;
    public TextField custPhoneNumber;
    public TextField custIdentity;
    public Button addCustomerBtn;
    public TextField searchCustomerField;
    public Button goBackBtn;
    public Button clearAllBtn;
    public AnchorPane pane;
    public Button refreshBtn;
    public Button updateCustomerBtn;

    public CustomerBo customerBo = new CustomerBo();
    public TableColumn colCustame;
    public TableColumn colCustNo;
    public TableColumn colCustic;
    public TableColumn colRemarks;
    public TableColumn colAction;
    public TableView tblCustomer;

    public void addCustomerBtnOnaction(ActionEvent actionEvent) {
        CustomerDto dto = new CustomerDto(0,custName.getText(), custPhoneNumber.getText(), custIdentity.getText(), custRemarks.getText());
        boolean b = customerBo.save(dto);
        if(b){
            new Alert(Alert.AlertType.INFORMATION,"Customer Added!").show();
            loadCustomerTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Customer Added Unsuccesfull").show();
        }
    }

    public void searchCustomerOnaction(ActionEvent actionEvent) {
    }

    public void goBackBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void clearAllBtnOnaction(ActionEvent actionEvent) {
    }

    public void refreshBtnBtnOnaction(ActionEvent actionEvent) {
        loadCustomerTable();
        tblCustomer.refresh();
        clearFields();

    }
    private void clearFields() {
        tblCustomer.refresh();
        custName.clear();
        custPhoneNumber.clear();
        custIdentity.clear();
        custRemarks.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustame.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        colCustNo.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        colCustic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colRemarks.setCellValueFactory(new PropertyValueFactory<>("remarks"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadCustomerTable();

        tblCustomer.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((CustomerTm) newValue);
        });

    }

    public void updateCustomerBtnOnaction(ActionEvent actionEvent) {
        CustomerDto dto = new CustomerDto(0,custName.getText(), custPhoneNumber.getText(), custIdentity.getText(), custRemarks.getText());
        boolean b = customerBo.update(dto);
        if(b){
            new Alert(Alert.AlertType.INFORMATION,"Update Successful").show();
        }
    }
    private void setData(CustomerTm newValue) {
        if (newValue != null) {
            custName.setText(newValue.getCustomerName());
            custPhoneNumber.setText(newValue.getPhoneNumber());
            custIdentity.setText(newValue.getNic());
            custRemarks.setText(newValue.getRemarks());
        }
    }

    private void loadCustomerTable() {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

        List<CustomerDto> dtoList  = customerBo.all();
        for (CustomerDto dto:dtoList) {
            Button btn = new Button("Delete");
            CustomerTm c = new CustomerTm(
                    dto.getCustomerId(),
                    dto.getCustomerName(),
                    dto.getPhoneNumber(),
                    dto.getNic(),
                    dto.getRemarks(),
                    btn
            );

            btn.setOnAction(actionEvent -> {
                deleteCustomer(dto);
            });

            tmList.add(c);
        }
        tblCustomer.setItems(tmList);

    }

    private void deleteCustomer(CustomerDto dto) {

        boolean isDeleted = customerBo.delete(dto);
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!").show();
            loadCustomerTable();
        }else{
            new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
        }

    }

    public void onMouseClickAction(MouseEvent mouseEvent) {
        clearFields();
    }
}
