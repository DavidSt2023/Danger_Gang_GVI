package utils;

import lombok.Getter;

@Getter
public class GpsLocation {
  private double laengengrad;
  private double breitengrad;

  public GpsLocation(double laengengrad, double breitengrad) {
    setLaengengrad(laengengrad);
    setBreitengrad(breitengrad);
  }

  public void setLaengengrad(double laengengrad) {
    if (laengengrad < -180 || laengengrad > 180) {
      throw new IllegalArgumentException("Längengrad muss zwischen -180 und 180 liegen.");
    }
    this.laengengrad = laengengrad;
  }

  public void setBreitengrad(double breitengrad) {
    if (breitengrad < -90 || breitengrad > 90) {
      throw new IllegalArgumentException("Breitengrad muss zwischen -90 und 90 liegen.");
    }
    this.breitengrad = breitengrad;
  }

  public double distanceTo(GpsLocation other) {
    //simple
    return Math.sqrt(Math.pow(this.laengengrad - other.laengengrad, 2) + Math.pow(this.breitengrad - other.breitengrad, 2));
  }
}
