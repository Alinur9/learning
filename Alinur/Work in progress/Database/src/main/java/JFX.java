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

public class JFX extends Application {
    Scene scene1,scene2,scene3;

    DataBase dataBase = new DataBase();
    @Override
    public void start(Stage primaryStage) throws Exception {
        //for the first scene;
        final String[] databaseNameClass = new String[1];
        final String[] tableNameClass = new String[1];
        Label databaseLabel = new Label("Name of your Database");
        TextField databaseName = new TextField();
        Button scene2Button = new Button("create Table");
        Label insertLabel1 = new Label("insert into existing table");
        Label s1tableLabel = new Label("Name of your Table");
        TextField tableNameField = new TextField();
        Button scene3Button = new Button("insert");
        VBox scene1Vbox = new VBox(databaseLabel,databaseName,scene2Button,insertLabel1,s1tableLabel
                ,tableNameField,scene3Button);
        primaryStage.setTitle("Database.xyz");
        scene1 = new Scene(scene1Vbox,500,600);
        //scene1 button 1
        EventHandler<MouseEvent> scene1Button1Handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                databaseNameClass[0] = databaseName.getText();
             primaryStage.setScene(scene2);

            }
        };
        scene2Button.addEventFilter(MouseEvent.MOUSE_CLICKED,scene1Button1Handler);
        //scene 1 button 2
        EventHandler<MouseEvent> scene1Button2Handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                databaseNameClass[0] = databaseName.getText();
                tableNameClass[0] = tableNameField.getText();
                primaryStage.setScene(scene3);
            }
        };
        scene3Button.addEventFilter(MouseEvent.MOUSE_CLICKED,scene1Button2Handler);

        //for the second scene;
        Label tableNameLabel = new Label("Name of your Table");
        TextField tableNameText = new TextField();
        Label defineTableLabel = new Label("Define Your Table \n* i.e: Name varchar(40), salary int *");
        TextField defineTableText = new TextField();
        Button createTableButton = new Button("create Table");
        VBox scene2Vbox = new VBox(tableNameLabel,tableNameText,defineTableLabel,defineTableText,createTableButton);
        scene2 = new Scene(scene2Vbox,400,500);
        Alert successAlerts1 = new Alert(Alert.AlertType.CONFIRMATION);
        EventHandler<MouseEvent> scene2Handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String tableNameString = tableNameText.getText();
                String defineTableString = defineTableText.getText();
                try {

                    dataBase.createTable(tableNameString,defineTableString);
                    successAlerts1.setTitle("success!");
                    successAlerts1.setContentText("Table created successfully");
                    successAlerts1.show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                primaryStage.setScene(scene3);

            }
        };
        createTableButton.addEventFilter(MouseEvent.MOUSE_CLICKED,scene2Handler);


        //for the third scene;
        Label insertLabel2 = new Label("insert into table \n * i.e: 'Alinur', 1500");
    ;
    //    String table = dataBase.showTable(databaseNameClass,tableNameClass);
        Label yourTableLabel = new Label("Your Table Currently");
        Label showTableText = new Label(dataBase.showTable(tableNameClass[0]));
        TextField insertText = new TextField();
        Button insertButton = new Button("insert");
        Alert successAlerts3 = new Alert(Alert.AlertType.CONFIRMATION);
        VBox scene3Vbox = new VBox(yourTableLabel,showTableText,insertLabel2,insertText,insertButton);
        scene3 = new Scene(scene3Vbox,400,500);
        //for scene 3 insert button
        EventHandler<MouseEvent> s3InsertButtonHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String insertString = insertText.getText();
                DataBase dataBase1 = new DataBase();
                try {
                    dataBase1.insertIntoTable(tableNameClass[0],insertString);
                    successAlerts3.setTitle("Success!");
                    successAlerts3.setContentText("1 Row inserted in table " + tableNameClass[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        //for the fourth scene;
        Label s4tableLabel = new Label("Name of your Table");
        TextField s4TableText = new TextField();
        Button s4insertTableButton = new Button("insert");

        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
