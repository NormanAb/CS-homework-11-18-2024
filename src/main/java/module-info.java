module com.example.books {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    exports com.example.books;
    exports com.example.books.controllers to javafx.fxml;
    opens com.example.books.controllers to javafx.fxml;

}