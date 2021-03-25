package app.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/app/gui/views/main.fxml"));
        primaryStage.setTitle("IT PONUKY DASHBOARD");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/app/gui/views/Icon.png")));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
