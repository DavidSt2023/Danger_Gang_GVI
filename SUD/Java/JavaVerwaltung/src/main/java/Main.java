import fahrzeuge.Bus;
import fahrzeuge.Personentransportfahrzeug;
import personen.*;
import utils.GpsLocation;
import verwaltungen.Abteilung;
import verwaltungen.Gut;
import verwaltungen.Lagerverwaltung;
import verwaltungen.Mitarbeiterverwaltung;

public class Main {

  public static void main(String[] args) {
    Abteilung abteilung = new Abteilung("Abteilung 1");
    Mitarbeiterverwaltung mv = new Mitarbeiterverwaltung();

    Person person = new Person("Alexandra Rollins");
    System.out.println(person);

    Bueroarbeiter bueroarbeiter = new Bueroarbeiter(5234, "David Stemmler", 2000);

    System.out.println(bueroarbeiter);

    Schichtarbeiter schichtarbeiter = new Schichtarbeiter(3234, "Julian Enkirchen", 20, 8);
    abteilung.addMitarbeiter(schichtarbeiter);
    System.out.println(schichtarbeiter);

    Manager manager = new Manager(5235, "Lukas Leufen", 2000, 0.1);
    abteilung.setLeiter(manager);
    System.out.println(manager);

    Personentransportfahrzeug pkw = new Personentransportfahrzeug(200, 50, new GpsLocation(50, 50), 5);
    mv.addFahrzeug(pkw);
    System.out.println(pkw);

    Fahrer fahrer = new Fahrer(schichtarbeiter, 'B');
    Bus bus = new Bus(100, 100, new GpsLocation(50, 50), 50, fahrer);
    mv.printFahrzeuge();
    System.out.println(bus);


    System.out.println("---------------------");
    System.out.println("Mitarbeiterverwaltung");
    mv.addAbteilung(abteilung);
    mv.printAbteilungen();
    mv.printFahrzeuge();
    System.out.println("---------------------");
    System.out.println("Abteilung Sorted  ");
    for(Mitarbeiter m: abteilung.getMitarbeiterListe()) {
      System.out.println(m);
    }
    System.out.println("---------------------");
    System.out.println("Gesamtes Einkommen: " + abteilung.getEinkommen());
    System.out.println("---------------------");

    Lagerverwaltung Lager = new Lagerverwaltung();
    Lager.addGut(new Gut("Metal", 1, 100,"Tonnen"));
    Lager.addGut(new Gut("Seide", 2, 500,"KG"));
    Lager.addGut(new Gut("Kunststoff", 3, 500,"KG"));
    Lager.addGut(new Gut("Holz", 4, 500,"KG"));
    for(Gut g: Lager.getGutListe()) {
      System.out.println(g);
    }
    System.out.println("---------------------");
  }

}