package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Button customerBtn;
    public Button supplierBtn;
    public Button placeOrderBtn;
    public Button reportsBtn;
    public Button productBtn;
    public AnchorPane pane;

    public void cutomerBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/customerForm.fxml")));
        stage.setTitle("Our Customers");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void placeOrderBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/placeOrderForm.fxml")));
        stage.setTitle("Place Your Order Here");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void supplierBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/supplierForm.fxml")));
        stage.setTitle("Our Suppliers");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void reportBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/reportForm.fxml")));
        stage.setTitle("Our Sales Reports");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void productBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/productForm.fxml")));
        stage.setTitle("Our Products");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void companyNameOnaction(MouseEvent mouseEvent) throws IOException, URISyntaxException {
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI("mailto:chinthakaprasad30@gmail.com"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
