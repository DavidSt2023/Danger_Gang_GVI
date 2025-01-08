package verwaltungen;

import fahrzeuge.Kfz;
import java.util.ArrayList;
import lombok.Getter;
import utils.ToStringUtil;

@Getter
public class Mitarbeiterverwaltung {

  private final ArrayList<Abteilung> abteilungen = new ArrayList<>();
  private final ArrayList<Kfz> fuhrpark = new ArrayList<>();

  public void addAbteilung(Abteilung abteilung) {
    abteilungen.add(abteilung);
  }

  public void removeAbteilung(Abteilung abteilung) {
    abteilungen.remove(abteilung);
  }

  public void addFahrzeug(Kfz fahrzeug) {
    fuhrpark.add(fahrzeug);
  }

  public void removeFahrzeug(Kfz fahrzeug) {
    fuhrpark.remove(fahrzeug);
  }

  public void printFahrzeuge() {
    System.out.println("Fahrzeuge:");
    for (Kfz f : fuhrpark) {
      System.out.println(f.toString());
    }
  }

  public void printAbteilungen() {
    System.out.println("Abteilungen:");
    for (Abteilung a : abteilungen) {
      System.out.println(a.toString());
    }
  }

  public String toString() {
    return ToStringUtil.toString(this);
  }

}