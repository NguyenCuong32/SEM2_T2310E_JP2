module org.fai.example.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens org.fai.example.demojavafx to javafx.fxml;
    exports org.fai.example.demojavafx;
    exports org.fai.example.demojavafx.controller;
    opens org.fai.example.demojavafx.controller to javafx.fxml;

    opens org.fai.example.demojavafx.entity to javafx.base;
    exports org.fai.example.demojavafx.entity;
}