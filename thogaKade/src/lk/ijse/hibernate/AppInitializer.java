package lk.ijse.hibernate;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/hibernate/view/MainForm.fxml"));
            Scene mainScene = new Scene(root);
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Java FX POS");
            primaryStage.centerOnScreen();
            primaryStage.show();
      }

}

