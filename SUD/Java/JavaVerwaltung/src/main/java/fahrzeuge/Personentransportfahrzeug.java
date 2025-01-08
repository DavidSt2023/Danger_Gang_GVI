package fahrzeuge;

import java.util.ArrayList;
import lombok.Getter;
import personen.Fahrer;
import personen.Person;
import utils.GpsLocation;

@Getter
public class Personentransportfahrzeug extends Kfz{

  private int anzahlSitze;
  private final ArrayList<Person> passagiere = new ArrayList<>();

  public Personentransportfahrzeug(double maxGeschwindigkeit, double maxTankInhalt, GpsLocation gpsLocation, int anzahlSitze) {
    super(maxGeschwindigkeit, maxTankInhalt, gpsLocation);
    setAnzahlSitze(anzahlSitze);
  }

  public void setAnzahlSitze(int anzahlSitze) {
    if (anzahlSitze < 0) {
      throw new IllegalArgumentException("Die Anzahl der Sitze darf nicht negativ sein.");
    }
    this.anzahlSitze = anzahlSitze;
  }

  public void getAnzahlPassagiere() {
    System.out.println("Anzahl der Passagiere: " + passagiere.size());
  }

  public void einsteigen(Person passagier) {
    if (passagiere.size() >= anzahlSitze) {
      throw new IllegalStateException("Das Fahrzeug ist voll.");
    }
    passagiere.add(passagier);
  }

  public void aussteigen(Person passagier) {
    if (passagiere.isEmpty()) {
      throw new IllegalStateException("Das Fahrzeug ist leer.");
    }
    passagiere.remove(passagier);
  }

  @Override
  public double getAuslastung() {
    return (double) passagiere.size() / anzahlSitze;
  }

  public boolean hatPassendenFuehrerschein(Fahrer fahrer) {
    return fahrer.getFuehrerscheinKlasse() == 'B';
  }
}
