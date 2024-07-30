module com.hello.baithijavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.hello.baithijavafx to javafx.fxml;
    exports com.hello.baithijavafx;

    exports com.hello.baithijavafx.Controller; // Xuất gói chứa lớp StudentController
    opens com.hello.baithijavafx.Controller to javafx.fxml;
}