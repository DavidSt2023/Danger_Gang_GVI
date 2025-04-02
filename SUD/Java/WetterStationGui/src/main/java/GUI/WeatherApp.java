package GUI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;
import WeatherStation.WetterDaten;

public class WeatherApp extends Application {
    private static final Random zM = new Random();
    private static WetterDaten wetterDaten = new WetterDaten(26, 50, 1000);
    private Label weatherLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Wetterstation");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #333; -fx-padding: 10px;");

        weatherLabel = new Label();
        updateWeatherData();

        VBox root = new VBox(10, titleLabel, weatherLabel);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Wetterstation");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(this::simulateWeatherData).start();
    }

    private void simulateWeatherData() {
        for (int i = 0; i < 50; i++) {
            try {
                int welcher = zM.nextInt(3);
                double wert;
                switch (welcher) {
                    case 0:
                        wetterDaten.setTemperatur(wetterDaten.getTemperatur() + zM.nextInt(8) - 4);
                        break;
                    case 1:
                        wert = wetterDaten.getFeuchtigkeit() + zM.nextInt(40) - 20;
                        if (wert >= 0) wetterDaten.setFeuchtigkeit(wert);
                        break;
                    case 2:
                        wert = wetterDaten.getLuftdruck() + zM.nextInt(30) - 15;
                        if (wert >= 650) wetterDaten.setLuftdruck(wert);
                        break;
                }

                updateWeatherData();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateWeatherData() {
        String newText = "Temperatur: " + wetterDaten.getTemperatur() + "°C\n" +
                "Feuchtigkeit: " + wetterDaten.getFeuchtigkeit() + "%\n" +
                "Luftdruck: " + wetterDaten.getLuftdruck() + " hPa";
        javafx.application.Platform.runLater(() -> weatherLabel.setText(newText));
    }
}
