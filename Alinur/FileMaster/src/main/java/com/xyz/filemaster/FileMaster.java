package com.xyz.filemaster;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileMaster extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(new FileInputStream("C:\\Users\\Adnan\\IdeaProjects\\FileMaster\\src\\main\\" +
                "resources\\com\\xyz\\filemaster\\xyz driveer.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(155);
        imageView.setFitWidth(350);
        imageView.setPreserveRatio(true);
        Label startLbl = new Label(" Generate Files! ");
        Label fileCountLbl = new Label("How Many Files?");
        Label sizeMbLbl = new Label("Size of each files in MB");
        Label nameLbl = new Label("Name of your File");
        TextField setName = new TextField();
        TextField setFileCount = new TextField();
        TextField setMbSize = new TextField();
        Label pathLbl = new Label("Where do you want to Generate Files.. ");
        Button gPathButton = new Button("Select");
        Label generateLbl = new Label("Generate Files.. ");
        Button generateButton = new Button("Generate");
        Line line = new Line(0,100,350,100);
        Label pathLbl1 = new Label("Path of your file1..");
        Label pathLbl2 = new Label("Path of your file2..");
        Label dividerLbl = new Label("  Compare Files! ");
        Line line1 = new Line(0,100,350,100);
        Line line2 = new Line(0,100,350,100);
        Line line3 = new Line(0,100,350,100);
        Button cPathButton1 = new Button("Select");
        Button cPathButton2 = new Button("Select");
        Label confirmationLbl = new Label("Compare Files!");
        Button compareButton = new Button("Compare");
        Alert gSuccessAlert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert gFailureAlert = new Alert(Alert.AlertType.ERROR);
        Alert cSuccessAlert = new Alert(Alert.AlertType.CONFIRMATION);
        Alert cFailureAlert = new Alert(Alert.AlertType.ERROR);
        final String[] finalPath = new String[1];
        final String[] cPath1arr = new String[1];
        final String[] cPath2arr = new String[1];

        EventHandler<MouseEvent> gPathHandler = MouseEvent -> {
            finalPath[0] = gPathHandle(setName,stage);
        };
        gPathButton.addEventFilter(MouseEvent.MOUSE_CLICKED,gPathHandler);
        EventHandler<MouseEvent> generateHandler = MouseEvent -> {
            generateHandle(setFileCount,setMbSize,finalPath[0],gSuccessAlert,gFailureAlert);
        };
        generateButton.addEventFilter(MouseEvent.MOUSE_CLICKED,generateHandler);
        EventHandler<MouseEvent> cPathHandler1 = MouseEvent -> {
            cPath1arr[0] = cPathHandle(stage);
        };
        cPathButton1.addEventFilter(MouseEvent.MOUSE_CLICKED,cPathHandler1);
        EventHandler<MouseEvent> cPathHandler2 = MouseEvent -> {
            cPath2arr[0] = cPathHandle(stage);
        };
        cPathButton2.addEventFilter(MouseEvent.MOUSE_CLICKED,cPathHandler2);
        EventHandler<MouseEvent> compareHandler = mouseEvent -> {
            compareHandle(cPath1arr[0],cPath2arr[0],cSuccessAlert,cFailureAlert);
        };
        compareButton.addEventFilter(MouseEvent.MOUSE_CLICKED,compareHandler);
        VBox vBox = new VBox(imageView,line2,startLbl,line3,fileCountLbl,setFileCount,sizeMbLbl,setMbSize,nameLbl,setName,pathLbl,gPathButton
                ,generateLbl,generateButton,line,dividerLbl,line1,pathLbl1,cPathButton1,pathLbl2,cPathButton2,confirmationLbl
        ,compareButton);
        vBox.setSpacing(5);
        stage.setTitle("FileMaster.xyz");
        Scene scene = new Scene(vBox,350,650);
        stage.setScene(scene);
        stage.setMaxHeight(650);
        stage.setMaxWidth(350);
        stage.setMinHeight(650);
        stage.setMinWidth(350);
        stage.show();

    }
    private void generateHandle(TextField setFileCount, TextField setMbSize, String path,
                                Alert gSuccessAlert, Alert gFailureAlert){
        int fileCount = Integer.parseInt(String.valueOf(setFileCount.getText()));
        int sizeMb = Integer.parseInt(String.valueOf(setMbSize.getText()));
        try {
            FileMaker.makeTree(path,sizeMb,fileCount);
            int filesGenerated = FileMaker.leafCount(new File(path));
            if (filesGenerated == fileCount){
                gSuccessAlert.setTitle("Success!");
                gSuccessAlert.setContentText(fileCount + " Files Generated Successfully!");
                gSuccessAlert.show();
            }else {
                int remainingFiles = fileCount - filesGenerated;
                gFailureAlert.setContentText(remainingFiles + " Files couldn't be Created! :(");
                gFailureAlert.setTitle("Failure!");
                gFailureAlert.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private String gPathHandle(TextField setName,Stage stage){
        DirectoryChooser cPathChooser = new DirectoryChooser();
        cPathChooser.setTitle("Where Do you Want to Generate Files");
        String initialPath = cPathChooser.showDialog(stage).getAbsolutePath();
        String name = setName.getText();
        String finalPath = initialPath + "/" + name;
        return finalPath;
    }
    private String cPathHandle(Stage stage){
        DirectoryChooser cPathChooser = new DirectoryChooser();
        cPathChooser.setTitle("Select Files To Compare");
        String initialPath = cPathChooser.showDialog(stage).getAbsolutePath();
        return initialPath;
    }
    private void compareHandle(String cPath1,String cPath2,Alert cSuccessAlert,Alert cFailureAlert){
        try{
            int x  = Directories.compare(cPath1,cPath2);
            if (x == 0){
                cFailureAlert.setTitle("Not Same!");
                cFailureAlert.setContentText("The Files Are Not Same!");
                cFailureAlert.show();
            }else {
                cSuccessAlert.setTitle("Same");
                cSuccessAlert.setContentText("The Files Are Same!");
                cSuccessAlert.show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
