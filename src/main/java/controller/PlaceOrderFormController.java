package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

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
    void goBackBtnOnaction(ActionEvent event) {

    }

    @FXML
    void placeOrderBtnOnaction(ActionEvent event) {

    }

    @FXML
    void productNameOnaction(ActionEvent event) {

    }

}
