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

public class PlaceOrderFormController {

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
    void addtocartBtnOnaction(ActionEvent event) {

    }

    @FXML
    void clearAllBtnOnaction(ActionEvent event) {

    }

    @FXML
    void customerNameSugestOnaction(ActionEvent event) {

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
    void placeOrderBtnOnaction(ActionEvent event) {

    }

    @FXML
    void productNameOnaction(ActionEvent event) {

    }

    public void placeOrderBtnOnaction(javafx.event.ActionEvent actionEvent) {
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

    public void addtocartBtnOnaction(javafx.event.ActionEvent actionEvent) {
    }

    public void customerNameSugestOnaction(javafx.event.ActionEvent actionEvent) {
    }

    public void productNameOnaction(javafx.event.ActionEvent actionEvent) {
    }
}
