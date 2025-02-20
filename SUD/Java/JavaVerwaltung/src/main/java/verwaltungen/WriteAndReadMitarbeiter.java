import mitarbeiter.Mitarbeiter;
import mitarbeiter.Büroarbeiter;
import mitarbeiter.SchichtArbeiter;
import mitarbeiter.Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadMitarbeiter {

    public static void writeMitarbeiterToCSV(List<Mitarbeiter> mitarbeiterListe, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Mitarbeiter mitarbeiter : mitarbeiterListe) {
                writer.write(mitarbeiterToCSV(mitarbeiter));
                writer.newLine();
            }
        }
    }

    public static List<Mitarbeiter> readMitarbeiterFromCSV(String filePath) throws IOException {
        List<Mitarbeiter> mitarbeiterListe = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                mitarbeiterListe.add(csvToMitarbeiter(line));
            }
        }
        return mitarbeiterListe;
    }
    private static String mitarbeiterToCSV(Mitarbeiter mitarbeiter) {
        if (mitarbeiter instanceof Manager manager) {
            return "Manager," + manager.getId() + "," + manager.getName() + "," + manager.getStundenSatz() + "," + manager.getBonusProzent();
        } else if (mitarbeiter instanceof Büroarbeiter) {
            return "Büroarbeiter," + mitarbeiter.getId() + "," + mitarbeiter.getName() + "," + ((Büroarbeiter) mitarbeiter).getStundenSatz();
        } else if (mitarbeiter instanceof SchichtArbeiter) {
            return "SchichtArbeiter," + mitarbeiter.getId() + "," + mitarbeiter.getName() + "," + ((SchichtArbeiter) mitarbeiter).getStundenSatz();
        }
        return "";
    }

    private static Mitarbeiter csvToMitarbeiter(String csvLine) {
        String[] parts = csvLine.split(",");
        String type = parts[0];
        int id = Integer.parseInt(parts[1]);
        String name = parts[2];
        int stundenSatz = Integer.parseInt(parts[3]);

        switch (type) {
            case "Büroarbeiter":
                return new Büroarbeiter(id, name, stundenSatz);
            case "SchichtArbeiter":
                return new SchichtArbeiter(id, name, stundenSatz);
            case "Manager":
                double bonusProzent = Double.parseDouble(parts[4]);
                return new Manager(id, name, stundenSatz, bonusProzent);
            default:
                throw new IllegalArgumentException("Unbekannter Mitarbeitertyp: " + type);
        }
}
