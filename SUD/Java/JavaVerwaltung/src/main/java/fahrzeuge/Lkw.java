package fahrzeuge;

import lombok.Getter;
import personen.Fahrer;
import utils.GpsLocation;

@Getter
public class Lkw extends Kfz {

  double ladeflaeche;
  double beladung;

  public Lkw(double maxSpeed, double maxFuelLevel, double ladeflaeche, GpsLocation gpsLocation) {
    super(maxSpeed, maxFuelLevel, gpsLocation);
    setLadeflaeche(ladeflaeche);
  }

  public void setLadeflaeche(double ladeflaeche) {
    if (ladeflaeche < 0) {
      throw new IllegalArgumentException("Die Ladefläche darf nicht negativ sein.");
    }
    this.ladeflaeche = ladeflaeche;
  }

  public void beladen(double menge) {
    if (menge < 0) {
      throw new IllegalArgumentException("Die Beladung darf nicht negativ sein.");
    }
    if (menge > ladeflaeche) {
      throw new IllegalArgumentException("Die Beladung darf nicht größer als die Ladefläche sein.");
    }
    if (beladung + menge > ladeflaeche) {
      throw new IllegalArgumentException("Die Beladung darf nicht größer als die Ladefläche sein.");
    }
    beladung += menge;
    System.out.println("Der Lkw wurde beladen. Die Ladefläche ist jetzt zu " + getAuslastung() + "% belegt.");
  }

  public void entladen(double menge) {
    if (menge < 0) {
      throw new IllegalArgumentException("Die Entladung darf nicht negativ sein.");
    }
    if (menge > beladung) {
      throw new IllegalArgumentException("Die Entladung darf nicht größer als die Beladung sein.");
    }
    if (beladung - menge < 0) {
      throw new IllegalArgumentException("Die Entladung darf nicht negativ sein.");
    }
    beladung -= menge;
    System.out.println("Der Lkw wurde entladen. Die Ladefläche ist jetzt zu " + (beladung / ladeflaeche * 100) + "% belegt.");
  }

  @Override
  public double getAuslastung() {
    return beladung / ladeflaeche * 100;
  }

  public boolean hatPassendenFuehrerschein(Fahrer fahrer) {
    return fahrer.getFuehrerscheinKlasse() == 'C';
  }

}
