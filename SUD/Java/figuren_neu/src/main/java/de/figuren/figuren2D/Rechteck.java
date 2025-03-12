package de.figuren.figuren2D;

import de.figuren.figuren.INamed;
import lombok.Getter;
import org.json.JSONObject;

@Getter
public class Rechteck extends Figur2D implements INamed {

  private double hoehe;
  private double breite;

  public Rechteck(double hoehe, double breite) throws IllegalArgumentException {
    setHoehe(hoehe);
    setBreite(breite);
  }

  public Rechteck(Rechteck r) {
    this(r.getHoehe(), r.getBreite());
  }

  public void setHoehe(double h) throws IllegalArgumentException {
    if (h <= 0) {
      throw new IllegalArgumentException("Rechteck ist mit der Hoehe nicht gueltig.");
    }
    this.hoehe = h;
  }

  public void setBreite(double b) throws IllegalArgumentException {
    if (b <= 0) {
      throw new IllegalArgumentException("Rechteck ist mit der Breite nicht gueltig.");
    }
    this.breite = b;
  }

  @Override
  public String name() {
    return "Rechteck mit Hoehe " + this.getHoehe() + " und Breite " + this.getBreite();
  }

  @Override
  public double flaeche() {
    return breite * hoehe;
  }

  @Override
  public double umfang() {
    return 2 * (breite + hoehe);
  }

  @Override
    public String toString() {
        return "\"Rechteck\":{\"laenge\":" + hoehe + ", \"breite\":" + breite + "}";
    }
  public static Rechteck fromString(String s) {
    JSONObject obj = new JSONObject(s);
    double laenge = obj.getDouble("laenge");
    double breite = obj.getDouble("breite");
    return new Rechteck(laenge, breite);
  }

}
