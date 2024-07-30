module com.example.javafx30072024 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.javafx30072024.controller to javafx.fxml;

    opens com.example.javafx30072024 to javafx.fxml;
    exports com.example.javafx30072024;

    exports com.example.javafx30072024.entity;

}