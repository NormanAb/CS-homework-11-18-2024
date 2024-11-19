module com.example.compscijavafx20241119 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.compscijavafx20241119 to javafx.fxml;
    exports com.example.compscijavafx20241119;
}