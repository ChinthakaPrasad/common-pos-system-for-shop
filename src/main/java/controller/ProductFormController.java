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
    void goBackBtnOnaction(ActionEvent event) throws IOException {
        Stage stage = (Stage) goBackBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void searchProductFieldOnaction(ActionEvent event) {

    }

    public void addProductBtnOnaction(javafx.event.ActionEvent actionEvent) {
    }

    public void searchProductFieldOnaction(javafx.event.ActionEvent actionEvent) {
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
}
