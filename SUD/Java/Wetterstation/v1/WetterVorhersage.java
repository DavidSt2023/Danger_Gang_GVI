package v1;

import java.util.Observable;
import java.util.Observer;

public class WetterVorhersage implements Observer {
  private double lastLuftdruck;
  private String vorhersage;

  @Override
  public void update(Observable o, Object arg) {
    if (o instanceof WetterDaten) {
      WetterDaten wetterDaten = (WetterDaten) o;
      double currentLuftdruck = wetterDaten.getLuftdruck();
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
  }

  public void anzeigen() {
    System.out.println("Wettervorhersage: " + vorhersage);
  }
}