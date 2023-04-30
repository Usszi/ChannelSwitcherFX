module com.example.channelswitcherfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.channelswitcherfx to javafx.fxml;
    exports com.example.channelswitcherfx;
}