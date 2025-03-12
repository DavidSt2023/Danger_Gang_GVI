package de.figuren.figuren3D;

import de.figuren.figuren2D.N_Eck;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tetraeder extends RegelmaessigePyramide {

  public Tetraeder(double kante) {
    super(new N_Eck(kante, 3), calcHoehe(kante));
  }

  private static double calcHoehe(double kante) {

    //Strecke zum Mittelpunkt
    double sm = new N_Eck(kante, 3).aussenKreisRadius() / 3;
    //Pythagoras
    return Math.sqrt(kante * kante - sm * sm);
  }

  public double getKante() {
    return this.getGrundKantenLaenge();
  }

  @Override
  public String name() {
    return "Tetraeder mit Kante " + this.getGrundKantenLaenge() + ".";
  }

  @Override
    public String toString() {
        return "{\"Tetraeder\":{" +
                "\"grund\" :" + getGrund() +
                ", \"hoehe\":" + getHoehe() +
                ",\"kante\":"+ getKante()+
                "}}";
    }

  public static Tetraeder fromString(String s) {
    JSONObject obj = new JSONObject(s);
    double kantenlaenge = obj.getDouble("kante");
    return (Tetraeder) Factory3D.createFigur3D("Tetraeder", new ArrayList<Object>() {{add(kantenlaenge);}});
  }
}
