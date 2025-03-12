package de.figuren.figuren3D;

import de.figuren.figuren2D.Dreieck;
import de.figuren.figuren2D.Figur2D;
import de.figuren.figuren2D.N_Eck;
import org.json.JSONObject;

public class RegelmaessigePyramide extends Pyramide<N_Eck> {

  public RegelmaessigePyramide(N_Eck figur, double hoehe) {
    super(figur, hoehe);
  }

  public RegelmaessigePyramide(double kante, int anzahlSeiten, double hoehe) throws IllegalArgumentException {
    this(new N_Eck(kante, anzahlSeiten), hoehe);
  }

  public double getGrundKantenLaenge() {
    return ((N_Eck) this.getGrund()).getSeitenLaenge();
  }

  public int getAnzahlSeiten() {
    return ((N_Eck) this.getGrund()).getN();
  }

  public double getSeitenKantenLaenge() {
    return Math.hypot(((N_Eck) this.getGrund()).aussenKreisRadius(), this.getHoehe());
  }

  public Dreieck getSeitenDreieck() {
    return new Dreieck(this.getSeitenKantenLaenge(), this.getSeitenKantenLaenge(), this.getGrundKantenLaenge());
  }

  public double getSeitenDreieckHoehe() {
    return Math.hypot(((N_Eck) this.getGrund()).innenKreisRadius(), this.getHoehe());
  }

  @Override
  public double mantel() {
    return this.getSeitenDreieck().flaeche() * this.getAnzahlSeiten();
  }

  @Override
  public String name() {
    return "Regelmaessige gerade Pyramide mit Hoehe " + this.getHoehe() + " und " + this.getAnzahlSeiten() + " Seiten.";
  }
  @Override
    public String toString() {
        return "{\"RegelmaessigePyramide\":{" +
                "\"grund\":" + getGrund() +
                ", \"hoehe\":" + getHoehe() +
                '}';
    }

  public static RegelmaessigePyramide fromString(String s) {
    JSONObject obj = new JSONObject(s);
    N_Eck grund = N_Eck.fromString(obj.getJSONObject("N_Eck"));
    double hoehe = obj.getDouble("hoehe");
    return new RegelmaessigePyramide(grund, hoehe);
  }
}
