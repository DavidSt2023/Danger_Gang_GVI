package v2;

import java.util.Observable;
import java.util.Observer;

public class AktuelleBedingungen implements Observer {
    private double temperatur;
    private double feuchtigkeit;
    private double luftdruck;

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof WetterDaten.WetterDatenPayload) {
            WetterDaten.WetterDatenPayload payload = (WetterDaten.WetterDatenPayload) arg;
            this.temperatur = payload.getTemperatur();
            this.feuchtigkeit = payload.getFeuchtigkeit();
            this.luftdruck = payload.getLuftdruck();
            anzeigen();
        }
    }

    public void anzeigen() {
        System.out.println("Aktuelle Bedingungen: " + temperatur + "°C, " + feuchtigkeit + "% Feuchtigkeit, " + luftdruck + " hPa Luftdruck");
    }
}