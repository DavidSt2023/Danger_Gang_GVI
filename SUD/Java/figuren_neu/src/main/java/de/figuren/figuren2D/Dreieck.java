package de.figuren.figuren2D;

import lombok.Getter;

@Getter
public class Dreieck extends Figur2D {

  private double seiteA;
  private double seiteB;
  private double seiteC;

  public Dreieck(double a, double b, double c) throws IllegalArgumentException {
    if (!istGueltig(a, b, c)) {
      throw new IllegalArgumentException("Dreieck ist nicht valide. Es wurde nicht erstellt.");
    }
    this.seiteA = a;
    this.seiteB = b;
    this.seiteC = c;
  }

  public Dreieck(Dreieck d) {
    this(d.getSeiteA(), d.getSeiteB(), d.getSeiteC());
  }

  public void setSeiteA(double seiteA) throws IllegalArgumentException {
    if (!istGueltig(seiteA, this.seiteB, this.seiteC)) {
      throw new IllegalArgumentException("Dreieck ist nicht gueltig. Aenderung nicht moeglich.");
    }
    this.seiteA = seiteA;
  }

  public void setSeiteB(double seiteB) throws IllegalArgumentException {
    if (!istGueltig(this.seiteA, seiteB, this.seiteC)) {
      throw new IllegalArgumentException("Dreieck ist nicht gueltig. Aenderung nicht moeglich.");
    }
    this.seiteB = seiteB;
  }

  public void setSeiteC(double seiteC) throws IllegalArgumentException {
    if (!istGueltig(this.seiteA, this.seiteB, seiteC)) {
      throw new IllegalArgumentException("Dreieck ist nicht gueltig. Aenderung nicht moeglich.");
    }
    this.seiteC = seiteC;
  }

  public double hoehe() {
    return (this.flaeche() * 2) / this.seiteC;
  }

  public double hoehe(char seiteBasis) {
    double s = 0;

    if (seiteBasis == 'a' || seiteBasis == 'A') {
      s = this.seiteA;
    } else if (seiteBasis == 'b' || seiteBasis == 'B') {
      s = this.seiteB;
    } else if (seiteBasis == 'c' || seiteBasis == 'C') {
      s = this.seiteC;
    }

    return this.flaeche() * 2 / s;
  }

  public static boolean istGueltig(double a, double b, double c) {
    return c + b > a && b + a > c && c + a > b;
  }

  @Override
  public double flaeche() {
    double s = (seiteA + seiteB + seiteC) / 2;
    return Math.sqrt(s * (s - seiteA) * (s - seiteB) * (s - seiteC));
  }

  @Override
  public double umfang() {
    return this.seiteA + this.seiteB + this.seiteC;
  }

  @Override
  public String name() {
    return "Dreieck mit den Seiten A: " + this.seiteA + " B: " + this.seiteB + " C: " + this.seiteC;
  }

  public String toString() {
    return "Seite A: " + seiteA + ", Seite B: " + seiteB + ", Seite C: " + seiteC + ", Flaeche: " + flaeche()
        + ", Umfang: " + umfang();
  }

  @Override
  public boolean equals(Object ob) {
    if (ob != null && ob.getClass() == Dreieck.class) {
      Dreieck o = (Dreieck) (ob);
      return this.seiteA == o.seiteA && this.seiteB == o.seiteB && this.seiteC == o.seiteC;
    }
    return false;
  }
}