package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class SupplierFormController {

    public Button refreshBtn;
    public Button updateSupplierBtn;
    @FXML
    private TextField supplierName;

    @FXML
    private TextField supplierRemarks;

    @FXML
    private TextField supplierPhoneNumber;

    @FXML
    private TextField supplierAddress;

    @FXML
    private Button addSupplierBtn;

    @FXML
    private TextField searchSupplier;

    @FXML
    private TableColumn<?, ?> tblSupplierName;

    @FXML
    private TableColumn<?, ?> tblPhoneNumber;

    @FXML
    private TableColumn<?, ?> tblAddress;

    @FXML
    private TableColumn<?, ?> tblEmail;

    @FXML
    private TableColumn<?, ?> tblRemarks;

    @FXML
    private TableColumn<?, ?> tblAction;

    @FXML
    private Button goBackBtn;

    @FXML
    private Button clearAllBtn;

    @FXML
    private TextField supplierEmail;

    @FXML
    void addSupplierBtnOnaction(ActionEvent event) {

    }

    @FXML
    void clearAllBtnOnaction(ActionEvent event) {

    }

    @FXML
    void goBackBtnOnaction(ActionEvent event) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void searchSupplierOnaction(ActionEvent event) {

    }

    public void addSupplierBtnOnaction(javafx.event.ActionEvent actionEvent) {
    }

    public void searchSupplierOnaction(javafx.event.ActionEvent actionEvent) {
    }

    public void goBackBtnOnaction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void clearAllBtnOnaction(javafx.event.ActionEvent actionEvent) {
    }

    public void refreshBtnOnaction(javafx.event.ActionEvent actionEvent) {
    }

    public void updateSupplierBtnOnaction(javafx.event.ActionEvent actionEvent) {
    }
}
