module com.example.worldc {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mariadb.jdbc;


    opens com.example.worldc to javafx.fxml;
    exports com.example.worldc;
}