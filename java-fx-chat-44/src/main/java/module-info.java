module com.example.javafxchat44 {
    requires javafx.controls;
    requires javafx.fxml;



    exports com.example.javafxchat44.client;
    opens com.example.javafxchat44.client to javafx.fxml;
}