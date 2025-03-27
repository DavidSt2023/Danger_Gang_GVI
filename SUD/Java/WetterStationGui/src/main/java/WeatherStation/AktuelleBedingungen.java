package WeatherStation;

public class AktuelleBedingungen implements Observer<WetterDaten.WetterDatenPayload> {
    private double temperatur;
    private double feuchtigkeit;
    private double luftdruck;

    @Override
    public void update(Subject<WetterDaten.WetterDatenPayload> subject, WetterDaten.WetterDatenPayload data) {
        this.temperatur = data.getTemperatur();
        this.feuchtigkeit = data.getFeuchtigkeit();
        this.luftdruck = data.getLuftdruck();
        anzeigen();
    }

    public void anzeigen() {
        System.out.println("Aktuelle Bedingungen: " + temperatur + "°C, " + feuchtigkeit + "% Feuchtigkeit, " + luftdruck + " hPa Luftdruck");
    }
}