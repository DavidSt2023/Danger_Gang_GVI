package v2;

public class WetterVorhersage implements Observer<WetterDaten.WetterDatenPayload> {
    private double lastLuftdruck;
    private String vorhersage;

    @Override
    public void update(Subject<WetterDaten.WetterDatenPayload> subject, WetterDaten.WetterDatenPayload data) {
        double currentLuftdruck = data.getLuftdruck();
        if (currentLuftdruck > lastLuftdruck) {
            vorhersage = "Wetter verbessert sich";
        } else if (currentLuftdruck < lastLuftdruck) {
            vorhersage = "Wetter verschlechtert sich";
        } else {
            vorhersage = "Wetter bleibt gleich";
        }
        lastLuftdruck = currentLuftdruck;
        anzeigen();
    }

    public void anzeigen() {
        System.out.println("Wettervorhersage: " + vorhersage);
    }
}