package controller;

import BO.UserBo;
import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UserRegistrationFormController {
    public TextField txtUsername;
    public TextField txtPassword;
    public Button loginBtn;
    public Button signupBtn;
    public TextField txtPhoneNumber;
    public TextField txtEmail;
    public TextField txtNic;
    public TextField txtPasswordAgain;
    private UserBo userBo = new UserBo();

    public void loginBtnOnaction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) signupBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/userLoginForm.fxml")));
        stage.setTitle("Log In");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void loginBtnOnaction() throws IOException {
        Stage stage = (Stage) signupBtn.getScene().getWindow();
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/userLoginForm.fxml")));
        stage.setTitle("Log In");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    public void signupBtnOnaction(ActionEvent actionEvent) throws IOException {
        if(!txtUsername.getText().isEmpty() && !txtPhoneNumber.getText().isEmpty() && !txtNic.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            if(txtPassword.getText().equals(txtPasswordAgain.getText())){
                UserDto newUser = new UserDto(txtUsername.getText(),
                        txtEmail.getText(),
                        txtPhoneNumber.getText(),
                        txtNic.getText(),
                        txtPassword.getText(),
                        txtPasswordAgain.getText());

                if(userBo.save(newUser)){
                    new Alert(Alert.AlertType.INFORMATION,"Sign Up completed").show();
                    System.out.println("userName"+txtUsername.getText().getClass());
                    loginBtnOnaction();
                }

            }else {
                new Alert(Alert.AlertType.ERROR,"Password Doen't Match!").show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"Please complete missing fields").show();
        }




    }
}
