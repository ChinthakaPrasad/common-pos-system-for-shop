package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class ProductFormController {

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

    @FXML
    void addProductBtnOnaction(ActionEvent event) {

    }

    @FXML
    void clearAllBtnOnaction(ActionEvent event) {

    }

    @FXML
    void goBackBtnOnaction(ActionEvent event) {

    }

    @FXML
    void searchProductFieldOnaction(ActionEvent event) {

    }

}
