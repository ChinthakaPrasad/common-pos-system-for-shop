package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class SupplierFormController {

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
    void goBackBtnOnaction(ActionEvent event) {

    }

    @FXML
    void searchSupplierOnaction(ActionEvent event) {

    }

}
