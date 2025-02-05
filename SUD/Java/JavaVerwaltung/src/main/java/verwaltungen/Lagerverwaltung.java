package verwaltungen;

import lombok.Getter;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Lagerverwaltung {

    private final Set<Gut> GutListe;

    public Lagerverwaltung() {
        GutListe = new HashSet<>();
    }

    public void addGut(Gut gut) {
        if (!GutListe.add(gut)) {
            System.out.println("Gut existiert bereits im Lager.");
        }
    }

    public void removeGut(Gut gut) {
        if (!GutListe.remove(gut)) {
            System.out.println("Gut existiert nicht im Lager.");
        }
    }

    public boolean containsGut(Gut gut) {
        return GutListe.contains(gut);
    }

    public void printLager() {
        for (Gut gut : GutListe) {
            System.out.println(gut);
        }
    }
}