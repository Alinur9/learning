package com.example.worldc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

public class HelloApplication extends Application {
        private static Stage childStage;
    public void start(Stage stage) throws IOException {
        childStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("log-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String css = Objects.requireNonNull(this.getClass().getResource("style.css")).toExternalForm();
        scene.getStylesheets().add(css);
        stage.setResizable(true);
        stage.setTitle("Login");
        stage.getIcons().add(new Image("D:\\projects\\worldC\\src\\main\\resources\\com\\example\\worldc\\kisspng-cricket-balls-vector-graphics-dribbble-illustratio-drayton-manor-sports-club-darin-day-music-ltd-5be537343e8b73.9568886715417485322562.png"));
        stage.setScene(scene);
        stage.show();
    }
    public static void setScene(String user, String resourceName,String title) throws IOException {
        Parent root;
        if (user != null){
            try{
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(resourceName));
                root = loader.load();
                if (resourceName == "board-table.fxml"){
                   BoardTableController boardTableController = loader.getController();
                   boardTableController.userInformation(user);
                }
                if (resourceName == "board-custom-table.fxml"){
                    BoardCusTblController boardCusTblController = loader.getController();
                    boardCusTblController.userInformation(user);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else
            root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(resourceName)));
            childStage.setTitle(title);
            childStage.setScene(new Scene(root));
            childStage.show();
        }

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        launch();
    }
}