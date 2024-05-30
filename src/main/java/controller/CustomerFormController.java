package controller;

import BO.CustomerBo;
import dao.CustomerDao;
import dto.CustomerDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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

    public void addCustomerBtnOnaction(ActionEvent actionEvent) {
        CustomerDto dto = new CustomerDto(custName.getText(), custPhoneNumber.getText(), custIdentity.getText(), custRemarks.getText());
        boolean b = customerBo.save(dto);
        if(b){
            new Alert(Alert.AlertType.INFORMATION,"Customer Added!").show();
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

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void updateCustomerBtnOnaction(ActionEvent actionEvent) {
    }
}
