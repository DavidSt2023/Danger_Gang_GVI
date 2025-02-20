package de.figuren;

import de.figuren.figuren2D.Dreieck;
import de.figuren.figuren2D.Figur2D;
import de.figuren.figuren2D.Kreis;
import de.figuren.figuren2D.N_Eck;
import de.figuren.figuren2D.Rechteck;
import de.figuren.figuren3D.*;
import utils.saveClassToCSV;

import java.util.ArrayList;
import java.util.Random;

public class Main {

  static Random rnd = new Random();
  ArrayList<Figur2D> formen2D = new ArrayList<>();
  ArrayList<Figur3D> formen3D = new ArrayList<>();
  ArrayList<Prisma> geradePrismen = new ArrayList<>();

  RegelmaessigePyramide drei = new RegelmaessigePyramide(new N_Eck(5, 3), 6);
  RegelmaessigePyramide vier = new RegelmaessigePyramide(new N_Eck(5, 4), 6);
  RegelmaessigePyramide sieben = new RegelmaessigePyramide(new N_Eck(5, 7), 6);
  Zylinder kk = new Zylinder(2.5, 6);
  Tetraeder tetra = new Tetraeder(5);
  Kugel k = new Kugel(2.5);

  public static void main(String[] args) {
    Main ft = new Main();
    ft.init();
    ft.testFigur2D();
    ft.testFigur3D();
  }

  private void testFigur2D() {
    for (Figur2D fig : formen2D) {
      System.out.println("Figur von Typ " + fig.name());
      System.out.println("    Flaeche: " + " " + fig.flaeche());
      System.out.println("    Umfang: " + " " + fig.umfang());
      if ("N_Eck".equals(fig.toString().substring(fig.toString().indexOf(".") + 1))) {
        System.out.println("    Aussenradius:" + ((N_Eck) fig).aussenKreisRadius());
        System.out.println("    Innenradius:" + ((N_Eck) fig).innenKreisRadius());

      }
    }

  }

  private void testFigur3D() {
    for (Figur3D fig : formen3D) {
      System.out.println("Figur von Typ " + fig.name());
      System.out.println("    Oberflaeche: " + " " + Math.round(fig.oberflaeche() * 1000) / 1000.0);
      System.out.println("    Volumen: " + Math.round(fig.volumen() * 1000) / 1000.0);
    }

  }

  public void init() {
    formen2D.add(new N_Eck(5, 3));
    formen2D.add(new N_Eck(3.5, 5));
    formen2D.add(new Kreis(3));
    formen2D.add(new Dreieck(6, 7, 9));
    formen2D.add(new Rechteck(4, 7.7));
    formen2D.add(new N_Eck(3, 9)); // Nonagon

//Figur3D
    for (Figur2D fig : formen2D) {
      geradePrismen.add(new Prisma(fig, rnd.nextInt(10)));
    }
    formen3D.addAll(geradePrismen);

    formen3D.add(kk);
    formen3D.add(drei);
    formen3D.add(vier);
    formen3D.add(sieben);
    formen3D.add(k);
    //NewFactory
    ArrayList<Figur3D> Figuren3D = new ArrayList<>();

    Figuren3D.add(Factory3D.createFigur3D("Prisma", new ArrayList<Object>() {{add(new N_Eck(5, 3)); add(6.0);}}));


    saveClassToCSV.writeAll(Figuren3D, java.nio.file.Paths.get("Figuren3D.csv"));
  }
}
