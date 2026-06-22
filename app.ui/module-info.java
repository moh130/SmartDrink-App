module app.ui {
    requires app.service;
    requires javafx.controls;
    requires javafx.fxml;

    opens app.ui to javafx.fxml;

    exports app.ui;
}