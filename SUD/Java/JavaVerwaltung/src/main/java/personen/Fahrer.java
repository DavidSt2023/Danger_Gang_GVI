package personen;

import lombok.Getter;

@Getter
public class Fahrer extends Schichtarbeiter {

  char fuehrerscheinKlasse;

  public Fahrer(int id, String name, double stundenSatz, int anzahlStunden, char fuehrerscheinKlasse) {
    super(id, name, stundenSatz, anzahlStunden);
    setFuehrerscheinKlasse(fuehrerscheinKlasse);
  }

  public Fahrer(Schichtarbeiter s, char fuehrerscheinKlasse) {
    super(s);
    setFuehrerscheinKlasse(fuehrerscheinKlasse);
  }

  public void setFuehrerscheinKlasse(char fuehrerscheinKlasse) {
    if (fuehrerscheinKlasse < 'B' || fuehrerscheinKlasse > 'D') {
      throw new IllegalArgumentException("Die Führerscheinklasse muss zwischen B, C oder D sein.");
    }
    this.fuehrerscheinKlasse = fuehrerscheinKlasse;
  }

}
