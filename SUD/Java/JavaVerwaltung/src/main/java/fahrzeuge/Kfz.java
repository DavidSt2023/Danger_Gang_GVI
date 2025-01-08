package fahrzeuge;

import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.Getter;
import personen.Fahrer;
import utils.GpsLocation;
import utils.ToStringUtil;

@Getter
public abstract class Kfz {

  private double maxTankInhalt;
  private double aktTankInhalt;

  private double maxGeschwindigkeit;
  private double aktGeschwindigkeit;

  private double aktKilometerstand;

  private boolean istMotorAn;

  private Fahrer fahrer;

  private GpsLocation gpsLocation;

  public Kfz(double maxGeschwindigkeit, double maxTankInhalt, GpsLocation gpsLocation) {
    setMaxTankInhalt(maxTankInhalt);
    setMaxGeschwindigkeit(maxGeschwindigkeit);
    this.gpsLocation = gpsLocation;
  }

  public Kfz(Kfz other) {
    this.aktTankInhalt = other.aktTankInhalt;
    this.maxTankInhalt = other.maxTankInhalt;
    this.maxGeschwindigkeit = other.maxGeschwindigkeit;
    this.aktGeschwindigkeit = other.aktGeschwindigkeit;
    this.aktKilometerstand = other.aktKilometerstand;
    this.istMotorAn = other.istMotorAn;
    this.fahrer = other.fahrer;
    this.gpsLocation = new GpsLocation(other.gpsLocation.getLaengengrad(), other.gpsLocation.getBreitengrad());
  }

  private void setMaxTankInhalt(double maxTankInhalt) {
    if (maxTankInhalt <= 0) {
      throw new IllegalArgumentException("Maximaler Tankinhalt muss größer als 0 sein.");
    }
    this.maxTankInhalt = maxTankInhalt;
  }

  private void setMaxGeschwindigkeit(double maxGeschwindigkeit) {
    if (maxGeschwindigkeit <= 0) {
      throw new IllegalArgumentException("Maximale Geschwindigkeit muss größer als 0 sein.");
    }
    this.maxGeschwindigkeit = maxGeschwindigkeit;
  }

  public void startMotor() {
    if (istMotorAn) {
      System.out.println("Motor ist bereits an.");
      return;
    }
    System.out.println("Motor startet...");
    istMotorAn = true;
  }

  public void stopMotor() {
    if (!istMotorAn) {
      System.out.println("Motor ist bereits aus.");
      return;
    }
    System.out.println("Motor stoppt...");
    istMotorAn = false;
  }

  public void bremsen() {
    if (!istMotorAn) {
      System.out.println("Motor ist aus, kann nicht bremsen");
      return;
    }
    if (aktKilometerstand == 0) {
      System.out.println("Fahrzeug steht, kann nicht bremsen");
      return;
    }
    if (aktKilometerstand <= 10) {
      aktKilometerstand = 0;
      System.out.println("Fahrzeug bremst und kommt zum stehen");
    } else {
      aktKilometerstand -= 10;
      System.out.println("Fahrzeug bremst");
    }
  }

  public void beschleunigen() {
    if (!istMotorAn) {
      System.out.println("Motor ist aus, kann nicht beschleunigen");
      return;
    }
    if (aktKilometerstand == maxGeschwindigkeit) {
      System.out.println("Fahrzeug hat maximale Geschwindigkeit erreicht");
      return;
    }
    if (aktKilometerstand + 10 <= maxGeschwindigkeit) {
      aktKilometerstand += 10;
    } else {
      aktKilometerstand = maxGeschwindigkeit;
    }
    System.out.println("Fahrzeug beschleunigt");
  }

  public void tanken(double menge) {
    if (menge <= 0) {
      throw new IllegalArgumentException("Menge muss größer als 0 sein.");
    }
    if (istMotorAn) {
      System.out.println("Tanken nicht möglich. Motor ist an.");
      return;
    }
    if (aktTankInhalt == maxTankInhalt) {
      System.out.println("Tanken nicht möglich. Tank ist bereits voll.");
      return;
    }
    if (aktTankInhalt + menge > maxTankInhalt) {
      System.out.println("Tanke... Tank ist übergelaufen. Überfüllte Menge: " + (aktTankInhalt + menge - maxTankInhalt));
      aktTankInhalt = maxTankInhalt;
      return;
    }
    aktTankInhalt += menge;
    System.out.println("Tanke... hinzugefügte Menge: " + menge);
  }

  public void einsteigen(Fahrer fahrer) {
    if (fahrer == null) {
      throw new IllegalArgumentException("Fahrer darf nicht null sein.");
    }
    if (this.fahrer != null) {
      System.out.println("Fahrer (" + fahrer.getName() + ") ist bereits eingestiegen.");
      return;
    }
    if (!hatPassendenFuehrerschein(fahrer)) {
      System.out.println("Fahrer (" + fahrer.getName() + ") hat keinen passenden Führerschein.");
      return;
    }
    this.fahrer = fahrer;
    System.out.println("Fahrer (" + fahrer.getName() + ") ist eingestiegen.");
  }

  public void aussteigen(Fahrer fahrer) {
    if (fahrer == null) {
      throw new IllegalArgumentException("Fahrer darf nicht null sein.");
    }
    if (this.fahrer == null) {
      System.out.println("Kein Fahrer ist im Fahrzeug.");
      return;
    }
    if (this.fahrer != fahrer) {
      System.out.println("Fahrer (" + fahrer.getName() + ") ist nicht im Fahrzeug.");
      return;
    }
    System.out.println("Fahrer (" + fahrer.getName() + ") ist ausgestiegen.");
    this.fahrer = null;
  }


  public void fahren(GpsLocation newGpsLocation) {
    if (fahrer == null) {
      System.out.println("Fahren nicht möglich. Kein Fahrer im Fahrzeug.");
      return;
    }
    if (!istMotorAn) {
      System.out.println("Fahren nicht möglich. Motor ist aus.");
      return;
    }
    if (aktTankInhalt <= 0) {
      System.out.println("Fahren nicht möglich. Tank ist leer.");
      return;
    }

    double distance = this.gpsLocation.distanceTo(newGpsLocation);
    double fuelConsumed = new BigDecimal(distance / 100 * 6).setScale(2, RoundingMode.HALF_UP).doubleValue();
    if (aktTankInhalt >= fuelConsumed) {
      aktTankInhalt -= fuelConsumed;
      aktKilometerstand += distance;
      this.gpsLocation = newGpsLocation;
      System.out.println("Fahre... aktueller Kilometerstand: " + aktKilometerstand + ", verbrauchter Tank: " + fuelConsumed);
    } else {
      System.out.println("Fahren nicht möglich. Tank nicht ausreichend.");
    }
  }

  protected abstract double getAuslastung();

  public abstract boolean hatPassendenFuehrerschein(Fahrer fahrer);

  public String toString() {
    return ToStringUtil.toString(this);
  }

}
