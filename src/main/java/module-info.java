module com.example.final_exam {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.final_exam to javafx.fxml;
    exports com.example.final_exam;
    exports com.example.final_exam.controller;
    opens com.example.final_exam.controller to javafx.fxml;

    opens com.example.final_exam.model to javafx.base;
}