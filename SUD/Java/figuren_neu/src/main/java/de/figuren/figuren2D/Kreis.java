package de.figuren.figuren2D;

import de.figuren.figuren.INamed;
import lombok.Getter;

@Getter
public class Kreis extends Figur2D implements INamed {

  private double radius;

  public Kreis(double r) throws IllegalArgumentException {
    this.setRadius(r);
  }

  public Kreis(Kreis k) {
    this.radius = k.radius;
  }

  public void setRadius(double radius) throws IllegalArgumentException {
    if (radius <= 0) {
      throw new IllegalArgumentException("Der Radius muss positiv sein.");
    }
    this.radius = radius;
  }

  @Override
  public String name() {
    return "Kreis mit Radius " + this.radius;
  }

  @Override
  public double flaeche() {
    return this.radius * this.radius * Math.PI;
  }

  @Override
  public String toString() {
    return "\"Kreis\":{" +
            "\"radius\":" + radius +
            "}";
  }

  @Override
  public double umfang() {
    return Math.PI * 2 * radius;
  }

}
