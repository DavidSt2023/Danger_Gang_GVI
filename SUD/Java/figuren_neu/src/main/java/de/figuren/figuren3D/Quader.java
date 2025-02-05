package de.figuren.figuren3D;

import de.figuren.figuren2D.Figur2D;
import lombok.Getter;

@Getter
public abstract class Quader<T extends Figur2D> extends Figur3D<T> {
  private Figur2D grund;
  private double hoehe;

  protected Quader(Figur2D grund, double hoehe) {
    this.grund = grund;
    this.setHoehe(hoehe);
  }

  public void setHoehe(double hoehe) throws IllegalArgumentException {
    if (hoehe <= 0)
      throw new IllegalArgumentException("Ein Quader ohne positive Hoehe ist nicht gueltig.");
    this.hoehe = hoehe;
  }

}
