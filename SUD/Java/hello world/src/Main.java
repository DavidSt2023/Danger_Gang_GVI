//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hausaufgaben();
        int linusAlter = 20;
        int elshadsAlter = 32;
        System.out.println("Linus Alter: " + linusAlter);
        System.out.println("Elshads Alter: " + elshadsAlter);

        int ausbildungsvergütungLinus = 900;
        int ausbildungsvergütungThorben = 950;
        System.out.println("Ausbildungsvergütung von Linus: " + ausbildungsvergütungLinus);
        System.out.println("Ausbildungsvergütung von Thorben: " + ausbildungsvergütungThorben);

        char geschlecht = 'W';
        System.out.println("Geschlecht: " + geschlecht);
        geschlecht = 'M';
        System.out.println("Geschlecht: " + geschlecht);

        boolean schulpflicht = true;
        System.out.println("Schulpflicht: " + schulpflicht);
        schulpflicht = false;
        System.out.println("Schulpflicht: " + schulpflicht);

        double preisSchokorigel = 3;
        System.out.println("Preis für Schokorigel: " + preisSchokorigel);
        preisSchokorigel = preisSchokorigel * 1.19;
        System.out.println("Preis für Schokorigel inkl. MwSt: " + preisSchokorigel);

        String mutter = "Ute";
        System.out.println("Name der Mutter: " + mutter);
        mutter = "Ute Hessami";
        System.out.println("Name der Mutter: " + mutter);
    }

    public static void Hausaufgaben() {
        // Deklaration und Initialisierung der Variablen
        int zahl1 = 10;
        int zahl2 = 3;
        int ergebnis; // Variable für das Ergebnis

        // Berechnungen mit verschiedenen Operatoren und Ausgabe der Ergebnisse
        ergebnis = zahl1 + zahl2;
        System.out.println("Ergebnis von " + zahl1 + " + " + zahl2 + " = " + ergebnis);

        ergebnis = zahl1 - zahl2;
        System.out.println("Ergebnis von " + zahl1 + " - " + zahl2 + " = " + ergebnis);

        ergebnis = zahl1 * zahl2;
        System.out.println("Ergebnis von " + zahl1 + " * " + zahl2 + " = " + ergebnis);

        ergebnis = zahl1 / zahl2;
        System.out.println("Ergebnis von " + zahl1 + " / " + zahl2 + " = " + ergebnis);

        ergebnis = zahl1 % zahl2;
        System.out.println("Ergebnis von " + zahl1 + " % " + zahl2 + " = " + ergebnis);

        // Beantwortung der Fragen
        System.out.println("\nFragen und Antworten:");

        // 1. Was macht der % Operator?
        System.out.println("1. Der % Operator, genannt Modulo, gibt den Rest einer Division zurück.");

        // 2. Was ist das Ergebnis von jeder ungeraden Zahl % 2?
        System.out.println("2. Das Ergebnis von jeder ungeraden Zahl % 2 ist 1.");

        // 3. Wie kann ich die Einerstellen einer mehrstelligen Zahl ermitteln?
        int mehrstelligeZahl = 2345;
        int einerstelle = mehrstelligeZahl % 10;
        System.out.println("3. Die Einerstelle von 2345 ist: " + einerstelle);

        // 4. Ändern des Datentyps der Ergebnisvariable zu double
        double ergebnisDouble;

        // Division mit double
        ergebnisDouble = zahl1 / zahl2;
        System.out.println("4. Ergebnis von " + zahl1 + " / " + zahl2 + " als double (ohne Typecasting) = " + ergebnisDouble);

        // 5. Verwendung von (double) Typecasting
        ergebnisDouble = (double) zahl1 / zahl2;
        System.out.println("5. Ergebnis von " + zahl1 + " / " + zahl2 + " mit Typecasting (double) = " + ergebnisDouble);

        // Erklärung
        System.out.println("Warum ändert sich das Ergebnis?");
        System.out.println("Ohne Typecasting wird die Division zwischen zwei Ganzzahlen durchgeführt, " +
                "und das Ergebnis ist ebenfalls eine Ganzzahl, wobei Nachkommastellen abgeschnitten werden.");
        System.out.println("Mit Typecasting (double) wird eine der Zahlen in einen Gleitkommawert umgewandelt, " +
                "wodurch die Division im Gleitkommabereich stattfindet und das Ergebnis präziser (inkl. Nachkommastellen) ist.");
    }
}