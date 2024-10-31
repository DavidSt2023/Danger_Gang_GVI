package de.lks1802;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader user_input = new BufferedReader(new InputStreamReader(
        System.in));
    char kategorie, griff;
    int menge;
    double preis;

    System.out.print("Bestellmenge: ");
    menge = Integer.parseInt(user_input.readLine());

    System.out.print("Kategorie (w,m,h): ");
    kategorie = user_input.readLine().charAt(0);
    if (!(kategorie == 'w' || kategorie == 'm' || kategorie == 'h')) {
      System.out.println("Fehlerhafte Eingabe. Nochmal.");
      System.out.print("Kategorie (w,m,h): ");
      kategorie = user_input.readLine().charAt(0);
    }

    System.out.print("Griffbezeichnung (g,n,k): ");
    griff = user_input.readLine().charAt(0);
    if (!(griff == 'g' || griff == 'n' || griff == 'k')) {
      System.out.println("Fehlerhafte Eingabe. Nochmal.");
      System.out.print("Griffbezeichnung (g,n,k): ");
      griff = user_input.readLine().charAt(0);
    }

    if (menge < 500)
      preis = menge * 2.5;
    else if (menge < 20000) {
      preis = (menge * 2.5) * 0.95;
      System.out.println("Rabatt von 5% wegen Bestellmenge >= 500");
    } else {
      preis = (menge * 2.5) * 0.9;
      System.out.println("Rabatt von 10% wegen Bestellmenge >= 20.000");
    }

    if (griff == 'k')
      if (kategorie == 'w') {
        preis *= 0.95;
        System.out.println("Rabatt von 5% wegen w und k");
      } else {
        preis *= 0.98;
        System.out.println("Rabatt von 2% wegen m oder h und k");
      }

    if (kategorie == 'w' && (griff == 'n' || griff == 'g')) {
      preis *= 0.99;
      System.out.println("Rabatt von 1% wegen w und n oder g");
    }

    if (kategorie == 'h')
      if (griff == 'n') {
        preis *= 1.025;
        System.out.println("Aufschlag von 2,5% wegen h und n");
      } else if (griff == 'g') {
        preis *= 1.05;
        System.out.println("Aufschlag von 5% wegen h und g");
      }
    System.out.println("Endpreis: " + preis);

  }
}
