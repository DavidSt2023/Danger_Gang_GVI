package v1;

import java.util.Observable;
import java.util.Observer;

public class AktuelleBedingungen implements Observer {
    private double temperatur;
    private double feuchtigkeit;
    private double luftdruck;

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WetterDaten) {
            WetterDaten wetterDaten = (WetterDaten) o;
            this.temperatur = wetterDaten.getTemperatur();
            this.feuchtigkeit = wetterDaten.getFeuchtigkeit();
            this.luftdruck = wetterDaten.getLuftdruck();
            anzeigen();
        }
    }

    public void anzeigen() {
        System.out.println("Aktuelle Bedingungen: " + temperatur + "°C, " + feuchtigkeit + "% Feuchtigkeit, " + luftdruck + " hPa Luftdruck");
    }
}