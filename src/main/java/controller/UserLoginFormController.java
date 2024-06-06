package controller;

import BO.UserBo;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class UserLoginFormController {
    public TextField txtUsername;
    public TextField txtPassword;
    public Button loginBtn;
    public Button signupBtn;
    public Label waitLabel;

    private UserBo userBo = new UserBo();

    public void loginBtnOnaction(ActionEvent actionEvent) throws IOException, NoSuchAlgorithmException {
        waitLabel.setVisible(true);
        String userName = txtUsername.getText();
        String password = txtPassword.getText();


        if(userBo.checkUser(userName, password)){
            Stage stage = (Stage) signupBtn.getScene().getWindow();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard.fxml")));
            stage.setTitle("Dashboard");
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setScene(scene);
            stage.show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Invalid User!").show();
        }
    }

    public void signupBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) signupBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/userRegistrationForm.fxml")));
        stage.setTitle("Registration Form");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
}
