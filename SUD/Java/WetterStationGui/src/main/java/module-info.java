module GUI {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.bootstrapfx.core;

    exports GUI;
    exports WeatherStation;
    opens GUI to javafx.fxml;
}