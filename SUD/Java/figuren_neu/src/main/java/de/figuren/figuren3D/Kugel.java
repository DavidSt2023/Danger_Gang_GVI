package de.figuren.figuren3D;

import lombok.Getter;

@Getter
public class Kugel extends Figur3D<Double> {

  private double radius;

  public Kugel(double radius) {
    this.setRadius(radius);
  }

  public void setRadius(double radius) {
    if (radius <= 0) {
      throw new IllegalArgumentException("Radius muss positiv sein.");
    }
    this.radius = radius;
  }

  public double volumen() {
    return 4 / 3.0 * Math.PI * Math.pow(radius, 3);
  }

  @Override
  public double oberflaeche() {
    return 4 * Math.PI * Math.pow(radius, 2);
  }

  @Override
  public String name() {
    return "Kugel mit Radius " + this.getRadius() + " Radius.";
  }
}