public class Main {

    // Cody written by Julian Enkirch
    public static void main(String[] args) {
        int ganzZahl1 = 4;
        int ganzZahl2 = 2;
        int ergebnis = ganzZahl1 + ganzZahl2;
        System.out.println(ergebnis + "\n");
        ergebnis = ganzZahl1 - ganzZahl2;
        System.out.println(ergebnis + "\n");
        ergebnis = ganzZahl1 * ganzZahl2;
        System.out.println(ergebnis + "\n");
        ergebnis = ganzZahl1 / ganzZahl2;
        System.out.println(ergebnis + "\n");

        ganzZahl1 = 10;
        ganzZahl2 = 3;

        // % gibt den Restwert einer Rechnung zurück
        System.out.println(ganzZahl1 % ganzZahl2 + "\n");

        // Bei einem integer ist das Ergebnis von 3%2=1
        System.out.println(ganzZahl2 % 2 + "\n");

        // Mit % 10 kann man die Einerstellen ermitteln
        System.out.println(2345 % 10 + "\n");

        // Bei dem ändern des Datentyps zu double werden die Kommastellen von Zahlen abgeschnitten, bei denen berechnet wurde.
        double ergebnis2 = ganzZahl1 / ganzZahl2;
        System.out.println(ergebnis2 + "\n");

        // Das Ergebnis ändert sich, weil die Kommastelen des Ergebnisses bei einem int nicht behalten werden, sondern abgeschnitten werden
        // was bei einem double nich der Fall ist.
        ergebnis2 = (double) ganzZahl1 / ganzZahl2;
        System.out.println(ergebnis2 + "\n");
    }
}