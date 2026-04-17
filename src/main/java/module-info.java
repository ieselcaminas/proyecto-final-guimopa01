module org.example.proyectofinalguille {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires spring.data.commons;
    requires jakarta.transaction;
    requires spring.beans;


    opens org.example.proyectofinalguille to javafx.fxml;
    exports org.example.proyectofinalguille;
    exports org.example.proyectofinalguille.controller;
    opens org.example.proyectofinalguille.controller to javafx.fxml;
}