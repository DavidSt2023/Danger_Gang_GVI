package verwaltungen;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import personen.Bueroarbeiter;
import personen.Manager;
import personen.Mitarbeiter;
import personen.Schichtarbeiter;
import utils.ToStringUtil;

@Getter
public class Abteilung {

  private String name;
  private final ArrayList<Mitarbeiter> mitarbeiterListe;
  private Manager leiter;

  public Abteilung(String name) {
    setName(name);
    mitarbeiterListe = new ArrayList<>();
  }

  public void setName(String name) {
    if (name != null && !name.isBlank()) {
      this.name = name;
    } else {
      throw new IllegalArgumentException("Der Name darf nicht leer sein.");
    }
  }

  public void setLeiter(Manager leiter) {
    this.leiter = leiter;
    addMitarbeiter(leiter);
  }

  public void removeLeiter(Manager leiter) {
    removeMitarbeiter(leiter);
    leiter = null;
  }

  public void addMitarbeiter(Mitarbeiter m) {
    mitarbeiterListe.add(m);
  }

  public void removeMitarbeiter(Mitarbeiter m) {
    mitarbeiterListe.remove(m);
  }

  public List<Mitarbeiter> getMitarbeiterListe() {
    return mitarbeiterListe;
  }

  public void printMitarbeiter() {
    for (Mitarbeiter m : mitarbeiterListe) {
      System.out.println(m.toString());
    }
  }

  public double getEinkommen() {
    double einkommen = 0;
    for (Mitarbeiter m : mitarbeiterListe) {

      if (m instanceof Schichtarbeiter s) {
        einkommen += s.einkommen();
      } else if (m instanceof Manager ma) {
        einkommen += ma.getFestgehalt() + ma.getBonus();
      } else if (m instanceof Bueroarbeiter b) {
        einkommen += b.getFestgehalt();
      } else {
        throw new IllegalArgumentException("Mitarbeiterklasse nicht bekannt.");
      }
    }
    return einkommen;
  }

  public String toString() {
    return ToStringUtil.toString(this);
  }

}
