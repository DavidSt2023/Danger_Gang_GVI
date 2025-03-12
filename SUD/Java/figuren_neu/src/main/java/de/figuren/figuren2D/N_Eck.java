package de.figuren.figuren2D;

import de.figuren.figuren.INamed;
import lombok.Getter;
import org.json.JSONObject;

@Getter
public class N_Eck extends Figur2D implements INamed {

  private double seitenLaenge;
  private int n;

  public N_Eck(double seitenLaenge, int anzahl) throws IllegalArgumentException {
    if (anzahl < 3) {
      throw new IllegalArgumentException("Ein N-Eck brauch mindestens 3 Seiten.");
    }
    setSeitenLaenge(seitenLaenge);
    this.n = anzahl;
  }

  @Override
  public String name() {
    return "N-Eck mit " + this.n + " Seiten der Laenge " + this.seitenLaenge;
  }

  @Override
  public double umfang() {
    return n * seitenLaenge;
  }

  public void setSeitenLaenge(double seitenLaenge) throws IllegalArgumentException {
    if (seitenLaenge <= 0) {
      throw new IllegalArgumentException("Die Seitenlaenge eines NEcks muss positiv sein.");
    }
    this.seitenLaenge = seitenLaenge;
  }

  public double innenKreisRadius() {
    return (this.seitenLaenge / 2) * (1 / Math.tan(Math.PI / this.n));
  }

  public double aussenKreisRadius() {
    return (this.seitenLaenge / 2) * (1 / (Math.sin(Math.PI / this.n)));
  }

  @Override
  public double flaeche() {
    double seite = this.aussenKreisRadius();
    Dreieck d = new Dreieck(seite, seite, seitenLaenge);
    return d.flaeche() * n;
  }
  @Override
  public String toString() {
    return "{\"N_Eck\":{" +
            "\"seitenLaenge\":" + seitenLaenge +
            ", \"anzahlSeiten\":" + n +
            "}}";
  }
  public static N_Eck fromString(JSONObject ob) {
    double seitenlaenge = ob.getDouble("seitenLaenge");
    int anzahlSeiten = ob.getInt("anzahlSeiten");
    return new N_Eck(seitenlaenge, anzahlSeiten);
  }
}
