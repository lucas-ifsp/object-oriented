module org.example.application {
    requires javafx.controls;
    requires javafx.fxml;

    exports class09.withcode;
    opens class09.withcode to javafx.fxml;

    exports class09.withfxml;
    opens class09.withfxml to javafx.fxml;

    exports class09.tableview;
    opens class09.tableview to javafx.fxml;
}