package de.figuren.figuren3D;

import de.figuren.figuren2D.Dreieck;

public class Dreiecksprisma extends Figur3D<Dreieck> {

  private Dreieck grundflaeche;
  private double hoehe;

  public Dreiecksprisma(Dreieck grundflaeche, double hoehe) {
    this.grundflaeche = grundflaeche;
    this.hoehe = hoehe;
  }

  @Override
  public double oberflaeche() {
    return 2 * grundflaeche.flaeche() + grundflaeche.umfang() * hoehe;
  }

  @Override
  public String name() {
    return "Dreiecksprisma mit Hoehe " + hoehe + " und " + grundflaeche.name();
  }

  @Override
  public double volumen() {
    return grundflaeche.flaeche() * hoehe;
  }

  @Override
    public String toString() {
        return "Dreiecksprisma{" +
                "grundflaeche=" + grundflaeche +
                ", hoehe=" + hoehe +
                '}';
    }
}