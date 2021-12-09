package com.xyz.jfx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class FileGenerator extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TextField setFileCount = new TextField();
        TextField setMbSize = new TextField();
        TextField setPath = new TextField();
        Label fileCountLbl = new Label("How Many Files?");
        Label sizeMbLbl = new Label("Size of each files in MB");
        Label pathLbl = new Label("Where do you want to Generate Files.. ");
        Button button = new Button("Generate");
        Alert successAlert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert failureAlert = new Alert(Alert.AlertType.ERROR);
        EventHandler<MouseEvent> eventHandler = mouseEvent -> {
            handler(setFileCount,setMbSize,setPath,successAlert,failureAlert);
        };
        button.addEventFilter(MouseEvent.MOUSE_CLICKED,eventHandler);
        VBox  vBox = new VBox(fileCountLbl,setFileCount,sizeMbLbl,setMbSize,pathLbl,setPath,button);
        stage.setTitle("File Generator");
        Scene scene = new Scene(vBox,500,400);
        stage.setScene(scene);
        stage.show();
    }
    private void handler(TextField setFileCount,TextField setMbSize,TextField setPath,
                         Alert successAlert,Alert failureAlert){
        int fileCount = Integer.parseInt(String.valueOf(setFileCount.getText()));
        int sizeMb = Integer.parseInt(String.valueOf(setMbSize.getText()));
        String path = setPath.getText();
        try {
            FileMaker.makeTree(path,sizeMb,fileCount);
            int filesGenerated = FileMaker.leafCount(new File(path));
            if (filesGenerated == fileCount){
                successAlert.setTitle("Success!");
                successAlert.setContentText(fileCount + " Files Generated Successfully!");
                successAlert.show();
            }else {
                int remainingFiles = fileCount - filesGenerated;
                failureAlert.setContentText(remainingFiles + " Files couldn't be Created! :(");
                failureAlert.setTitle("Failure!");
                failureAlert.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
