package verwaltungen;


import lombok.Getter;
import personen.Bueroarbeiter;
import personen.Manager;
import personen.Mitarbeiter;
import personen.Schichtarbeiter;
import utils.ToStringUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;


@Getter
public class Abteilung {

    private String name;
    private final SortedSet<Mitarbeiter> mitarbeiterListe;
    private final PriorityQueue<Schichtarbeiter> schichtarbeiterQueue;
    private Manager leiter;

    public Abteilung(String name) {
        setName(name);
        mitarbeiterListe = new TreeSet<>(Comparator.comparing(Mitarbeiter::getName));
        schichtarbeiterQueue = new PriorityQueue<>(Comparator.comparingInt(Schichtarbeiter::getAnzahlStunden));
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Der Name darf nicht leer sein.");
        }
    }

    public void setLeiter(Manager leiter) {
        this.leiter = leiter;
        addMitarbeiter(leiter);
    }

    public void removeLeiter(Manager leiter) {
        removeMitarbeiter(leiter);
        leiter = null;
    }

    public void addMitarbeiter(Mitarbeiter m) {
        mitarbeiterListe.add(m);
        if (m instanceof Schichtarbeiter) {
            schichtarbeiterQueue.add((Schichtarbeiter) m);
        }
    }

    public void removeMitarbeiter(Mitarbeiter m) {
        mitarbeiterListe.remove(m);
        if (m instanceof Schichtarbeiter) {
            schichtarbeiterQueue.remove(m);
        }
    }

    public void printMitarbeiter() {
        for (Mitarbeiter m : mitarbeiterListe) {
            System.out.println(m.toString());
        }
    }

    public void printSchichtarbeiter() {
        for (Schichtarbeiter s : schichtarbeiterQueue) {
            System.out.println(s.toString());
        }
    }

    public double getEinkommen() {
        double einkommen = 0;
        for (Mitarbeiter m : mitarbeiterListe) {
            if (m instanceof Schichtarbeiter s) {
                einkommen += s.einkommen();
            } else if (m instanceof Manager ma) {
                einkommen += ma.getFestgehalt() + ma.getBonus();
            } else if (m instanceof Bueroarbeiter b) {
                einkommen += b.getFestgehalt();
            } else {
                throw new IllegalArgumentException("Mitarbeiterklasse nicht bekannt.");
            }
        }
        return einkommen;
    }

    public String toString() {
        return ToStringUtil.toString(this);
    }
}