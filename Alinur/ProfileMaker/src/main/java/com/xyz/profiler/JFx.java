package com.xyz.profiler;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class JFx extends Application {
    Scene scene1,scene2;
    Database database;

    public JFx() throws Exception {
        database = new Database();
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL resource = getClass().getResource("/Logo.png");
        Image image;
        BackgroundImage backgroundImageClass;

        if(resource == null){
            throw  new IOException("File not found");
        }

        try(InputStream stream =  resource.openStream()){
             image = new Image(stream);

        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        scene1 = defineScene1(stage);
        scene2 = defineCreateAccountScene(stage);
        stage.setTitle("ProfileMaker.xyz");
        stage.setScene(scene1);
        stage.getIcons().add(image);
        stage.setMaxWidth(500);
        stage.setMaxHeight(800);
        stage.show();
    }
    private Scene defineScene1(Stage stage) throws Exception {
        URL resource = getClass().getResource("/CoverpageCloudBlue.png");
        URL resource2 = getClass().getResource("/navyblue.jpg");
        ImageView imageView;
        BackgroundImage backgroundImageClass;

        if(resource == null && resource2 == null){
            throw  new IOException("File not found");
        }

        try(InputStream stream =  resource.openStream()){

            Image topImage = new Image(stream);
            imageView = new ImageView(topImage);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        try(InputStream stream = resource2.openStream()){

            Image backgroundImage = new Image(stream);
            backgroundImageClass = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }


        imageView.setFitHeight(250);
        imageView.setFitWidth(500);
        Label logInLabel = new Label("Welcome To Xyz!");
        logInLabel.setTextFill(Color.WHITE);
        logInLabel.setFont(Font.font("Arial",26));
        Label userNameLabel = new Label("UserName");
        userNameLabel.setTextFill(Color.WHITE);
        TextField userNameField = new TextField();
        userNameField.setMaxWidth(300);
        Label  passwordLabel = new Label("Password");
        passwordLabel.setTextFill(Color.WHITE);
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(300);
        passwordField.setPrefHeight(50);
        passwordField.setPrefHeight(50);
        Button logInButton = new Button("Login");
        Label createAccountLabel = new Label(" Don't have an account? create one today!");
        createAccountLabel.setTextFill(Color.WHITE);
        Button createAccountButton = new Button("Create");
        Alert accountDoesNotExistAlert = new Alert(Alert.AlertType.ERROR,"Account Does not Exist!");
        accountDoesNotExistAlert.setTitle("Try Again");
        Alert wrongPasswordAlert = new Alert(Alert.AlertType.ERROR,"You Have Entered A Wrong Password!");
        wrongPasswordAlert.setTitle("Try Again");
        Alert loginSuccessAlert = new Alert(Alert.AlertType.CONFIRMATION,"Successfully Logged In!");
        loginSuccessAlert.setTitle("success");

        //event handling
        EventHandler<MouseEvent> loginButtonHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String userNameString = userNameField.getText();
                String passwordString = passwordField.getText();
                try {
                //    Database database = new Database();
                    if (!database.accountExists(userNameString))
                        accountDoesNotExistAlert.show();
                    else {
                        if (!database.passwordCorrect(userNameString,passwordString))
                            wrongPasswordAlert.show();
                        else {
                            if (!database.profileExists(userNameString))
                                stage.setScene(defineLoginWithoutProfileScene(stage));
                            else
                                stage.setScene(profileScene(stage));
                            //**work To be done
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        };
        logInButton.addEventFilter(MouseEvent.MOUSE_CLICKED,loginButtonHandler);
        EventHandler<MouseEvent> createAccountButtonHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setMaxWidth(500);
                stage.setMaxHeight(800);
                stage.setScene(scene2);
            }
        };
        createAccountButton.addEventFilter(MouseEvent.MOUSE_CLICKED,createAccountButtonHandler);

        Label nullLabel1 = new Label("");
        Label nullLabel2 = new Label("");
        Label nullLabel3 = new Label("");

        VBox vBox = new VBox(imageView,logInLabel,nullLabel3,userNameLabel,userNameField,passwordLabel,passwordField,logInButton,
                nullLabel1,nullLabel2,createAccountLabel,createAccountButton);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setSpacing(10);
//        Image backGroundImage  = new Image(new FileInputStream("src\\main\\resources\\navyblue.jpg"));
//
//        BackgroundImage backgroundImageClass = new BackgroundImage(backGroundImage,BackgroundRepeat.NO_REPEAT,
//                BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);

        Background background = new Background(backgroundImageClass);
        vBox.setBackground(background);
        Scene scene = new Scene(vBox,500,800);
        return scene;
    }
    private Scene defineCreateAccountScene(Stage stage) throws Exception {
        URL resource = getClass().getResource("/CoverpageCloudBlue.png");
        URL resource2 = getClass().getResource("/navyblue.jpg");
        ImageView imageView;
        BackgroundImage backgroundImageClass;

        if(resource == null && resource2 == null){
            throw  new IOException("File not found");
        }

        try(InputStream stream =  resource.openStream()){

            Image topImage = new Image(stream);
            imageView = new ImageView(topImage);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        try(InputStream stream = resource2.openStream()){

            Image backgroundImage = new Image(stream);
            backgroundImageClass = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

        imageView.setFitHeight(250);
        imageView.setFitWidth(500);
        Label createLabel = new Label("Create An Account");
        createLabel.setTextFill(Color.WHITE);
        createLabel.setFont(Font.font("Arial",26));
        Label emailLabel = new Label("Enter a valid Email Address");
        emailLabel.setTextFill(Color.WHITE);
        TextField emailField = new TextField();
        emailField.setMaxWidth(300);
        Label userNameLabel = new Label(" Enter your UserName");
        userNameLabel.setTextFill(Color.WHITE);
        TextField userNameField = new TextField();
        userNameField.setMaxWidth(300);
        Label  passwordLabel = new Label("Set a Password");
        passwordLabel.setTextFill(Color.WHITE);
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(300);
        Button createAccountButton = new Button("Create");
        Label backToScene1Label = new Label("Already have an account?");
        backToScene1Label.setTextFill(Color.WHITE);
        Button logInButton = new Button("Login");
        Alert accountCreatedAlert = new Alert(Alert.AlertType.CONFIRMATION,"Account created Successfully");
        accountCreatedAlert.setTitle("Success!");
        Alert userNameExistsAlert = new Alert(Alert.AlertType.ERROR,"User Name  or Email Already Exists.. ");
        userNameExistsAlert.setTitle("Try Again!");
  //      Scene scene1 = defineScene1(stage);
        //event handling
        EventHandler<MouseEvent> backToScene1Handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setMaxWidth(500);
                stage.setMaxHeight(800);
                stage.setScene(scene1);

            }
        };
        logInButton.addEventFilter(MouseEvent.MOUSE_CLICKED,backToScene1Handler);
        Alert nullAlert = new Alert(Alert.AlertType.ERROR,"please provide the required data");
        nullAlert.setTitle("Try again!");

        EventHandler<MouseEvent> createAccountHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setMaxWidth(500);
                stage.setMaxHeight(800);
                String userNameString = userNameField.getText();
                String emailString = emailField.getText();
                String passwordString = passwordField.getText();
                if (userNameString.equals("") || emailString.equals("") || passwordString.equals(""))
                    nullAlert.show();
                else {
                    try {
                        //       Database database = new Database();
                        if (database.userNameExists(userNameString, emailString)) {
                            userNameExistsAlert.show();
                        } else {
                            database.addAccount(userNameString, emailString, passwordString);
                            accountCreatedAlert.show();
                            stage.setScene(scene1);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        createAccountButton.addEventFilter(MouseEvent.MOUSE_CLICKED,createAccountHandler);

        Label nullLabel1 = new Label("");
        Label nullLabel2 = new Label("");
        Label nullLabel3 = new Label("");
        VBox vBox = new VBox(imageView,createLabel,nullLabel3,emailLabel,emailField,userNameLabel,userNameField,passwordLabel,
                passwordField,createAccountButton,nullLabel1,nullLabel2,backToScene1Label,logInButton);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setSpacing(10);

        Background background = new Background(backgroundImageClass);
        vBox.setBackground(background);
        Scene scene = new Scene(vBox,500,800);

        return scene;
    }
    private Scene defineLoginWithoutProfileScene(Stage stage)throws Exception{
        URL resource = getClass().getResource("/navyblue top2.jpg");
        URL resource2 = getClass().getResource("/navyblue.jpg");
        ImageView imageView;
        BackgroundImage backgroundImageClass;

        if(resource == null && resource2 == null){
            throw  new IOException("File not found");
        }

        try(InputStream stream =  resource.openStream()){

            Image topImage = new Image(stream);
            imageView = new ImageView(topImage);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        try(InputStream stream = resource2.openStream()){

            Image backgroundImage = new Image(stream);
            backgroundImageClass = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }



        stage.setMaxWidth(794);
        stage.setMaxHeight(800);
        imageView.setFitHeight(180);
        imageView.setFitWidth(794);
        Label noProfileLabel = new Label("You Don't have a Profile yet");
        noProfileLabel.setTextFill(Color.WHITE);
   //     noProfileLabel.setFont(Font.font("Arial",26));
        Label createProfileLabel = new Label("Create Your XYZ Profile!");
        createProfileLabel.setTextFill(Color.WHITE);
        createProfileLabel.setFont(Font.font("Arial",26));
        Button createProfileButton = new Button("Create");
        //event handling
        EventHandler<MouseEvent> createProfileButtonHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                   stage.setScene(defineCreateProfileScene(stage));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        createProfileButton.addEventFilter(MouseEvent.MOUSE_CLICKED,createProfileButtonHandler);

        VBox vBox = new VBox(imageView,noProfileLabel,createProfileLabel,createProfileButton);
        vBox.setSpacing(20);

        Background background = new Background(backgroundImageClass);
        vBox.setBackground(background);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        Scene scene = new Scene(vBox,794,800);

        return scene;
    }
    private Scene defineCreateProfileScene(Stage stage)throws Exception{
        URL resource = getClass().getResource("/navyblue create1.png");
        URL resource2 = getClass().getResource("/navyblue.jpg");
        ImageView imageView;
        BackgroundImage backgroundImageClass;

        if(resource == null && resource2 == null){
            throw  new IOException("File not found");
        }

        try(InputStream stream =  resource.openStream()){

            Image topImage = new Image(stream);
            imageView = new ImageView(topImage);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        try(InputStream stream = resource2.openStream()){

            Image backgroundImage = new Image(stream);
            backgroundImageClass = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }


        stage.setMaxWidth(794);
        stage.setMaxHeight(800);;
        imageView.setFitHeight(100);
        imageView.setFitWidth(794);
        Label createProfileLabel = new Label("Create your XYZ profile");
        createProfileLabel.setTextFill(Color.ANTIQUEWHITE);
        createProfileLabel.setFont(Font.font("Arial",FontWeight.BOLD,30));
        Label firstName = labelMaker("First Name");
        TextField firstNameField = new TextField();
        firstNameField.setMaxWidth(300);
        Label lastName = labelMaker("Last Name");
        TextField lastNameField = new TextField();
        lastNameField.setMaxWidth(300);
        Label occupation = labelMaker("What is your Occupation");
        TextField occupationField = new TextField();
        occupationField.setMaxWidth(300);
        Label company = labelMaker("Where do you work?");
        TextField companyField = new TextField();
        companyField.setMaxWidth(300);
        Label age = labelMaker("Age");
        TextField ageField = new TextField();
        ageField.setMaxWidth(300);
        Label relationship = labelMaker("Relationship status");
        TextField relationshipField = new TextField();
        relationshipField.setMaxWidth(300);
        Label gender = labelMaker("Gender");
        TextField genderField = new TextField();
        genderField.setMaxWidth(300);
        Button createProfileButton = new Button("Create");
        //event Handling
        EventHandler<MouseEvent> createProfileButtonHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String occupation = occupationField.getText();
                String gender = genderField.getText();
                String company = companyField.getText();
                String relation = relationshipField.getText();
                String age = ageField.getText();
                try {
                    database.addProfile(firstName,lastName,occupation,company,age,gender,relation);
                    stage.setScene(profileScene(stage));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        createProfileButton.addEventFilter(MouseEvent.MOUSE_CLICKED,createProfileButtonHandler);
        VBox vBox = new VBox(imageView,firstName,firstNameField,lastName,lastNameField,occupation,occupationField,
                company,companyField,age,ageField,relationship,relationshipField,gender,genderField,createProfileButton);
        vBox.setSpacing(10);

        Background background = new Background(backgroundImageClass);
        vBox.setBackground(background);
        vBox.setAlignment(Pos.BASELINE_CENTER);
   //     vBox.setAlignment(Pos.BASELINE_CENTER);
        Scene scene = new Scene(vBox,794,800);
        return scene;
    }
    private Scene profileScene(Stage stage)throws Exception{
        URL resource = getClass().getResource("/navyblue top2.jpg");
        URL resource2 = getClass().getResource("/navyblue1.jpg");
        ImageView imageView;
        BackgroundImage backgroundImageClass;

        if(resource == null && resource2 == null){
            throw  new IOException("File not found");
        }

        try(InputStream stream =  resource.openStream()){

            Image topImage = new Image(stream);
            imageView = new ImageView(topImage);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        try(InputStream stream = resource2.openStream()){

            Image backgroundImage = new Image(stream);
            backgroundImageClass = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }


        stage.setMaxWidth(794);
        stage.setMaxHeight(850);
        imageView.setFitHeight(180);
        imageView.setFitWidth(794);
        String userName = database.getCurrentUserName();
        String firstName = database.getFirstName();
        String lastName = database.getLastName();
        String email = database.getCurrentUserEmail();
        String occupation = database.getOccupation();
        String gender = database.getGender();
        String company = database.getCompany();
        String relation = database.getRelation();
        String age = database.getAge();
        Label userNameLabel = new Label("                         "+userName);
        userNameLabel.setTextFill(Color.DARKCYAN);
        userNameLabel.setFont(Font.font("verdana", FontPosture.ITALIC,39));
        Line line = new Line(0,10,794,10);
        line.setFill(Color.ANTIQUEWHITE);
        Label introLabel = new Label("  Intro");
        introLabel.setTextFill(Color.ANTIQUEWHITE);
        introLabel.setFont(Font.font("Arial",30));
        Label firstNameLabel = labelMaker("     "+firstName);
        Label lastNameLabel = labelMaker("     "+lastName);
        Label emailLabel = labelMaker("     "+email);
        boolean picture = false;
        Image image = null;
        if (database.pictureExists(userName)!= null) {
             image = SwingFXUtils.toFXImage(database.pictureExists(userName), null);
            picture = true;
        }

        Label occupationLabel = labelMaker("     "+occupation);
        Label genderLabel =labelMaker("     "+gender);
        Label companyLabel =labelMaker("     "+company);
        Label relationLabel =labelMaker("     "+relation);
        Label ageLabel = labelMaker("     "+age);
        Button logoutButton = new Button("  Log  \n  out  ");
  //      logoutButton.setAlignment(Pos.BOTTOM_CENTER);
        //event handling
        EventHandler<MouseEvent> logoutButtonhandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    stage.setScene(defineScene1(stage));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        logoutButton.addEventFilter(MouseEvent.MOUSE_CLICKED,logoutButtonhandler);
        Label logoutLabel = labelMaker2("\n    Log Out",15);
        Label editProfileLabel = labelMaker2("\nEdit Profile",15);
        Button editProfileButton = new Button("Edit\nprofile");
        //event handling
        EventHandler<MouseEvent> editProfileButtonHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    stage.setScene(editProfileScene(stage));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        editProfileButton.addEventFilter(MouseEvent.MOUSE_CLICKED,editProfileButtonHandler);
        Label addImageLabel = labelMaker2("\n Add photo",15);
        Button addImageButton = new Button("  Add  \n photo ");
        Alert uploadedImageAlert = new Alert(Alert.AlertType.CONFIRMATION,"Photo uploaded successfully!");
        uploadedImageAlert.setTitle("Success!");
        //event handling

            EventHandler<MouseEvent> addImageButtonHandler = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    FileChooser chooser = new FileChooser();
                    chooser.setTitle("Select photo");
                    String initialPath;
                    initialPath = chooser.showOpenDialog(stage).getAbsolutePath();
                    try {

                        database.addImage(initialPath);
                        stage.setScene(profileScene(stage));
                        uploadedImageAlert.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            addImageButton.addEventFilter(MouseEvent.MOUSE_CLICKED,addImageButtonHandler);

        Label linkLabel = labelMaker2("\n\n          xyzcloudbd.com",18);
        HBox hBox1 = new HBox(logoutLabel,logoutButton,editProfileLabel,editProfileButton,addImageLabel,addImageButton,linkLabel);
        hBox1.setSpacing(20);
        VBox vBox;
        HBox hBox;

        if (picture){
           ImageView imageView1 = new ImageView(image);
           imageView1.setFitWidth(170);
           imageView1.setFitHeight(170);
           imageView1.setPreserveRatio(true);
           imageView1.setPreserveRatio(false);
           Label masterLabel = labelMaker("     "+firstName+"\n\n     "+lastName+"\n\n     "+email+"\n\n     "+occupation);
           hBox = new HBox(masterLabel,imageView1);
           hBox.setSpacing(85);
           vBox = new VBox(imageView,userNameLabel,line,introLabel,hBox,companyLabel,genderLabel,relationLabel,ageLabel,hBox1);
        }else {
            vBox = new VBox(imageView, userNameLabel, line, introLabel, firstNameLabel, lastNameLabel, emailLabel, occupationLabel,
                    companyLabel, genderLabel, relationLabel, ageLabel, hBox1);
        }
        vBox.setSpacing(20);

        Background background = new Background(backgroundImageClass);
        vBox.setBackground(background);
        Scene scene = new Scene(vBox,794,850);
        return scene;
    }
    private Label labelMaker(String labelText){
        Label createLabel = new Label(labelText);
        createLabel.setTextFill(Color.WHITE);
        createLabel.setFont(Font.font("Arial",FontWeight.BOLD,17));
        return createLabel;
    }
    private Label labelMaker2(String labelText,int size){
        Label createLabel = new Label(labelText);
        createLabel.setTextFill(Color.ANTIQUEWHITE);
        createLabel.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,size));
        return createLabel;
    }
    private Scene editProfileScene(Stage stage)throws Exception{
        URL resource = getClass().getResource("/navyblue edit.jpg");
        URL resource2 = getClass().getResource("/navyblue.jpg");
        ImageView imageView;
        BackgroundImage backgroundImageClass;

        if(resource == null && resource2 == null){
            throw  new IOException("File not found");
        }

        try(InputStream stream =  resource.openStream()){

            Image topImage = new Image(stream);
            imageView = new ImageView(topImage);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        try(InputStream stream = resource2.openStream()){

            Image backgroundImage = new Image(stream);
            backgroundImageClass = new BackgroundImage(backgroundImage,BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }


        stage.setMaxWidth(794);
        stage.setMaxHeight(800);
        imageView.setFitHeight(100);
        imageView.setFitWidth(794);
        String userNames = database.getCurrentUserName();
        String firstNames = database.getFirstName();
        String lastNames = database.getLastName();
        String emails = database.getCurrentUserEmail();
        String occupations = database.getOccupation();
        String genders = database.getGender();
        String companies = database.getCompany();
        String relations = database.getRelation();
        String ages = database.getAge();
        Label createProfileLabel = new Label("Edit your XYZ profile");
        createProfileLabel.setTextFill(Color.ANTIQUEWHITE);
        createProfileLabel.setFont(Font.font("Arial",FontWeight.BOLD,30));
        Label firstName = labelMaker("First Name");
        TextField firstNameField = new TextField(firstNames);
        firstNameField.setMaxWidth(300);
        Label lastName = labelMaker("Last Name");
        TextField lastNameField = new TextField(lastNames);
        lastNameField.setMaxWidth(300);
        Label occupation = labelMaker("What is your Occupation");
        TextField occupationField = new TextField(occupations);
        occupationField.setMaxWidth(300);
        Label company = labelMaker("Where do you work?");
        TextField companyField = new TextField(companies);
        companyField.setMaxWidth(300);
        Label age = labelMaker("Age");
        TextField ageField = new TextField(ages);
        ageField.setMaxWidth(300);
        Label relationship = labelMaker("Relationship status");
        TextField relationshipField = new TextField(relations);
        relationshipField.setMaxWidth(300);
        Label gender = labelMaker("Gender");
        TextField genderField = new TextField(genders);
        genderField.setMaxWidth(300);
        Button createProfileButton = new Button("Edit");
        Alert profileUpdatedAlert = new Alert(Alert.AlertType.CONFIRMATION,"Account updated!");
        profileUpdatedAlert.setTitle("success!");
        //event Handling
        EventHandler<MouseEvent> createProfileButtonHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String occupation = occupationField.getText();
                String gender = genderField.getText();
                String company = companyField.getText();
                String relation = relationshipField.getText();
                String age = ageField.getText();
                try {
                    database.updateProfile(firstName,lastName,occupation,company,age,gender,relation);
                    profileUpdatedAlert.show();
                    stage.setScene(profileScene(stage));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        createProfileButton.addEventFilter(MouseEvent.MOUSE_CLICKED,createProfileButtonHandler);
        VBox vBox = new VBox(imageView,firstName,firstNameField,lastName,lastNameField,occupation,occupationField,
                company,companyField,age,ageField,relationship,relationshipField,gender,genderField,createProfileButton);
        vBox.setSpacing(10);

        Background background = new Background(backgroundImageClass);
        vBox.setBackground(background);
        vBox.setAlignment(Pos.BASELINE_CENTER);
        //     vBox.setAlignment(Pos.BASELINE_CENTER);
        Scene scene = new Scene(vBox,794,800);
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}
