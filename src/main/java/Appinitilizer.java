import dao.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Objects;

public class Appinitilizer extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/dashboard.fxml"))));
//        primaryStage.centerOnScreen();
//        primaryStage.setResizable(false);
//        primaryStage.show();

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/userLoginForm.fxml"))));
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Login Form");
        primaryStage.show();


        Image image = new javafx.scene.image.Image("images/favicon.png");
        primaryStage.getIcons().add(image);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.close();
    }
}
