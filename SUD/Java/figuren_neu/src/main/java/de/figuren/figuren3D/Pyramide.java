package de.figuren.figuren3D;

import de.figuren.figuren2D.Figur2D;

public abstract class Pyramide<T extends Figur2D> extends Quader<T> {

  protected Pyramide(Figur2D grund, double hoehe) throws IllegalArgumentException {
    super(grund, hoehe);
  }

  public double oberflaeche() {
    return this.getGrund().flaeche() + mantel();
  }

  public double volumen() {
    return (1 / 3.0) * this.getGrund().flaeche() * this.getHoehe();
  }

  public abstract double mantel();
}