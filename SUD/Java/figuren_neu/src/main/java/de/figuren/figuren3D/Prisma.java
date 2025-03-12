package de.figuren.figuren3D;

import de.figuren.figuren2D.Dreieck;
import de.figuren.figuren2D.Figur2D;
import de.figuren.figuren2D.N_Eck;
import de.figuren.figuren2D.Rechteck;
import org.json.JSONObject;
import java.util.ArrayList;

public class Prisma<T extends Figur2D> extends Quader<T> {

  public Prisma(Figur2D grund, double hoehe) throws IllegalArgumentException {
    super(grund, hoehe);
  }

  public double oberflaeche() {
    return 2 * getGrund().flaeche() + getGrund().umfang() * this.getHoehe();
  }

  public double volumen() {
    return this.getHoehe() * getGrund().flaeche();
  }

  @Override
  public String name() {
    return "Gerades Prisma mit Hoehe " + this.getHoehe() + " und als Grundflaeche " + this.getGrund() + ".";
  }
  @Override
    public String toString() {
        return "{\"Prisma\":{" +
                "\"grund\" :" + getGrund() +
                ", \"hoehe\" :" + getHoehe() +
                "}}";
    }

  public static Prisma fromString(String s) {
    JSONObject obj = new JSONObject(s);
    JSONObject grundObj = obj.getJSONObject("grund");
    Figur2D grund;
    if (grundObj.has("Rechteck")) {
      grund = Rechteck.fromString(grundObj.getJSONObject("Rechteck").toString());
    } else if (grundObj.has("Dreieck")) {
      grund = Dreieck.fromString(grundObj.getJSONObject("Dreieck").toString());
    } else if (grundObj.has("N_Eck")) {
      grund = N_Eck.fromString(grundObj.getJSONObject("N_Eck"));
    } else {
      throw new IllegalArgumentException("Unknown Grundfläche type: " + obj.toString());
    }

    return (Prisma) Factory3D.createFigur3D("Prisma",new ArrayList<Object>() {{
      add(grund);
      add(obj.getDouble("hoehe"));
    }});
  }
}