module main.starfieldcharactercreatorfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;


    opens view to javafx.fxml;
    exports view;
    exports model;
}