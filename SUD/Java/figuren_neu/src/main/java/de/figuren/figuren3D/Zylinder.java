package de.figuren.figuren3D;

import de.figuren.figuren2D.Kreis;

public class Zylinder extends Pyramide<Kreis> {

  public Zylinder(Kreis k, double hoehe) {
    super(k, hoehe);
  }

  public Zylinder(double radius, double hoehe) {
    super(new Kreis(radius), hoehe);
  }

  @Override
  public double mantel() {
    Kreis grundKreis = (Kreis) getGrund();

    double seitenLaenge = Math.sqrt(Math.pow(getHoehe(), 2) + Math.pow(grundKreis.getRadius(), 2));
    Kreis mantelKreis = new Kreis(seitenLaenge);
    double kreisVerhaeltnis = grundKreis.umfang() / mantelKreis.umfang();

    return kreisVerhaeltnis * mantelKreis.flaeche();
  }

  @Override
  public String name() {
    return "Kreiskegel mit Hoehe " + this.getHoehe() + " und " + ((Kreis) this.getGrund()).getRadius() + " Radius.";
  }
}