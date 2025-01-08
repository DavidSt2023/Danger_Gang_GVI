import fahrzeuge.Bus;
import fahrzeuge.Personentransportfahrzeug;
import personen.Bueroarbeiter;
import personen.Fahrer;
import personen.Manager;
import personen.Person;
import personen.Schichtarbeiter;
import utils.GpsLocation;
import verwaltungen.Abteilung;
import verwaltungen.Mitarbeiterverwaltung;

public class Main {

  public static void main(String[] args) {
    Abteilung abteilung = new Abteilung("Abteilung 1");
    Mitarbeiterverwaltung mv = new Mitarbeiterverwaltung();

    Person person = new Person("Max Mustermann");
    System.out.println(person);

    Bueroarbeiter bueroarbeiter = new Bueroarbeiter(5234, "Max Mustermann", 2000);

    System.out.println(bueroarbeiter);

    Schichtarbeiter schichtarbeiter = new Schichtarbeiter(3234, "Max Mustermann", 20, 8);
    abteilung.addMitarbeiter(schichtarbeiter);
    System.out.println(schichtarbeiter);

    Manager manager = new Manager(5235, "Max Mustermann", 2000, 0.1);
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
    System.out.println("Abteilung");
    abteilung.printMitarbeiter();
    System.out.println("Gesamtes Einkommen: " + abteilung.getEinkommen());
    System.out.println("---------------------");

  }

}