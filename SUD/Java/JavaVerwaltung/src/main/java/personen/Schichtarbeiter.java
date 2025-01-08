package personen;

import lombok.Getter;

@Getter
public class Schichtarbeiter extends Mitarbeiter {

  private double stundenLohn;
  private int anzahlStunden;

  public Schichtarbeiter(int id, String name, double stundenLohn, int anzahlStunden) {
    super(id, name);
    setStundenLohn(stundenLohn);
    setAnzahlStunden(anzahlStunden);
  }

  public Schichtarbeiter(Mitarbeiter m, double stundenLohn, int anzahlStunden) {
    super(m);
    setStundenLohn(stundenLohn);
    setAnzahlStunden(anzahlStunden);
  }

  public Schichtarbeiter(Schichtarbeiter s) {
    super(s);
    setStundenLohn(s.stundenLohn);
    setAnzahlStunden(s.anzahlStunden);
  }

  @Override
  protected void setId(int id) {
    if (id < 3000 || id > 3999) {
      throw new IllegalArgumentException("Die Id muss positiv 4 stellig sein und mit der Ziffer 3 beginnen.");
    }
    super.setId(id);
  }

  public void setStundenLohn(double stundenLohn) {
    if (stundenLohn < 0) {
      throw new IllegalArgumentException("Der Stundenlohn darf nicht negativ sein.");
    }
    this.stundenLohn = stundenLohn;
  }

  public void setAnzahlStunden(int anzahlStunden) {
    if (anzahlStunden < 0) {
      throw new IllegalArgumentException("Die Anzahl der Stunden darf nicht negativ sein.");
    }
    this.anzahlStunden += anzahlStunden;
  }

  public double einkommen() {
    return this.stundenLohn * this.anzahlStunden;
  }

  public void arbeite() {
    this.anzahlStunden += 8;
  }

  public void arbeite(int stunden) {
    this.anzahlStunden += stunden;
  }

}
