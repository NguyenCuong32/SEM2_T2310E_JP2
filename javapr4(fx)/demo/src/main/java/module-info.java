module com.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example to javafx.fxml;

    exports com.example;
    exports com.example.Controller;

    opens com.example.Controller to javafx.fxml;

    opens com.example.Entity to javafx.base;

    exports com.example.Entity;
}
