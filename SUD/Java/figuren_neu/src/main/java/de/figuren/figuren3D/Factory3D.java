package de.figuren.figuren3D;

import de.figuren.figuren2D.Figur2D;
import de.figuren.figuren2D.N_Eck;

import java.util.ArrayList;

public class Factory3D {

    public static Figur3D createFigur3D(String figur, ArrayList<Object> args) {
        try {
            switch (figur) {
                case "Kugel":
                    return new Kugel((Double) args.get(0));
                case "Prisma":
                    return new Prisma((Figur2D) args.get(0), (Double) args.get(1));
                case "RegelmaessigePyramide":
                    if(args.get(0) instanceof N_Eck)
                        return new RegelmaessigePyramide((N_Eck) args.get(0), (Double) args.get(1));
                    else
                        return new RegelmaessigePyramide((Double) args.get(0), (int) args.get(1),(Double) args.get(3));
                case "Tetraeder":
                    return new Tetraeder((Double) args.get(0));
                case "Zylinder":
                    return new Zylinder((Double) args.get(0), (Double) args.get(1));
                default:
                    throw new IllegalArgumentException("Figur nicht bekannt.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}