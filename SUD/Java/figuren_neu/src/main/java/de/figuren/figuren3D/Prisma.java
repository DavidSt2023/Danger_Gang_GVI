package de.figuren.figuren3D;

import de.figuren.figuren2D.Figur2D;

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
        return "Prisma{" +
                "grund=" + getGrund() +
                ", hoehe=" + getHoehe() +
                '}';
    }

}