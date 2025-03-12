package de.figuren.figuren3D;

import de.figuren.figuren2D.Kreis;
import org.json.JSONObject;

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

  @Override
    public String toString() {
        return "{\"Zylinder\":{" +
                "\"grund\":{" + getGrund() +
                "}, \"hoehe\":" + getHoehe() +
                "}}";
    }

  public static Zylinder fromString(String s) {
    JSONObject obj = new JSONObject(s);
    JSONObject grundobj = obj.getJSONObject("grund").getJSONObject("Kreis");
    double radius = grundobj.getDouble("radius");
    double hoehe = obj.getDouble("hoehe");
    return new Zylinder(radius, hoehe);
  }
}