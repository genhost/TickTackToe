package TickTackToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent menuParent = FXMLLoader.load(getClass().getResource("menuUI.fxml"));
        Scene menuScene = new Scene(menuParent);

        primaryStage.setTitle("TickTackToe");
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
