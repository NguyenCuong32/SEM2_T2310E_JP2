module org.example.demofianal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.demofianal to javafx.fxml;
    exports org.example.demofianal;
}