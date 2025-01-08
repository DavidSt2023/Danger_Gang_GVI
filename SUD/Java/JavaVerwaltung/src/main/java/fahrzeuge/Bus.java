package fahrzeuge;

import personen.Fahrer;
import utils.GpsLocation;

public class Bus extends Personentransportfahrzeug {
  private Fahrer fahrer;

  public Bus(double maxGeschwindigkeit, double maxTankInhalt, GpsLocation gpsLocation, int anzahlSitze, Fahrer fahrer) {
    super(maxGeschwindigkeit, maxTankInhalt, gpsLocation, anzahlSitze);
    this.fahrer = fahrer;
  }

  public void einsteigen(Fahrer fahrer) {
    if (this.fahrer != null) {
      throw new IllegalStateException("Der Bus hat bereits einen Fahrer.");
    }
    this.fahrer = fahrer;
  }

  public void aussteigen(Fahrer fahrer) {
    if (this.fahrer == null) {
      throw new IllegalStateException("Der Bus hat keinen Fahrer.");
    }
    this.fahrer = null;
  }

  public boolean hatPassendenFuehrerschein(Fahrer fahrer) {
    return fahrer.getFuehrerscheinKlasse() == 'D';
  }
}
