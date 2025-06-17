## 🔀 **Threads** (Multithreading)

### ✅ Was?

Ein **Thread** ist ein **ausführbarer Teil** deines Programms – Java kann **mehrere Dinge gleichzeitig** machen (Multitasking).

### ✅ Warum?

Damit du **langsame Aufgaben** (z. B. Datei lesen, Netzwerkabfrage) **parallel** erledigen kannst, ohne das Hauptprogramm zu blockieren.

### 📌 Use Case: Datei im Hintergrund laden

```java
class DateiLader extends Thread {
    public void run() {
        System.out.println("Datei wird geladen...");
        // lange Aufgabe
    }
}

public class Main {
    public static void main(String[] args) {
        new DateiLader().start(); // paralleler Start
        System.out.println("UI bleibt benutzbar");
    }
}
```

➡️ **Warum?** Du willst z. B. in einer App die Oberfläche **nicht einfrieren**, während im Hintergrund etwas geladen wird.

---

## 👂 **Observer Pattern**

### ✅ Was?

Ein **Verhaltensmuster**, bei dem ein Objekt (Subject) **mehrere Zuhörer (Observer)** benachrichtigt, wenn sich **etwas ändert**.

### ✅ Warum?

Damit Teile des Programms **automatisch reagieren**, wenn ein Zustand sich ändert – ohne dass sie sich gegenseitig kennen.

### 📌 Use Case: UI aktualisiert sich bei Datenänderung

```java
interface Observer {
    void aktualisieren(String daten);
}

class Datenquelle {
    private List<Observer> beobachter = new ArrayList<>();

    void registrieren(Observer o) {
        beobachter.add(o);
    }

    void datenGeaendert(String daten) {
        for (Observer o : beobachter) {
            o.aktualisieren(daten);
        }
    }
}
```

➡️ **Warum?** Du willst z. B. bei einer Wetter-App mehrere UI-Komponenten **automatisch aktualisieren**, wenn neue Wetterdaten da sind.

---

## 🙈 **Anonyme Klassen**

### ✅ Was?

Eine **anonyme Klasse** ist eine Klasse **ohne Namen**, die du direkt beim Erstellen eines Objekts **innerhalb des Codes** definierst.

### ✅ Warum?

Wenn du eine **kleine, einmalige Klasse brauchst**, z. B. um ein Interface schnell zu implementieren.

### 📌 Use Case: Klick-Handler für einen Button

```java
button.setOnClickListener(new OnClickListener() {
    public void onClick() {
        System.out.println("Button wurde geklickt");
    }
});
```

➡️ **Warum?** Du musst **nicht extra eine neue Klasse** für jede Kleinigkeit schreiben – spart Code und ist übersichtlicher.

---

## 🧠 **Lambdas** (ab Java 8)

### ✅ Was?

Ein **Lambda-Ausdruck** ist eine **Kurzschreibweise für Funktionen oder Interfaces mit nur einer Methode** (z. B. `Runnable`, `Comparator`, eigene Functional Interfaces).

### ✅ Warum?

**Weniger Code, klarer & moderner.** Besonders praktisch bei Listen, Events, Streams usw.

### 📌 Use Case: Hintergrund-Thread mit Lambda

```java
new Thread(() -> {
    System.out.println("Läuft im Hintergrund");
}).start();
```

Oder: **Liste sortieren**

```java
List<String> namen = Arrays.asList("Tom", "Anna", "Zoe");
namen.sort((a, b) -> a.compareTo(b)); // Lambda statt Comparator-Klasse
```

➡️ **Warum?** Spart dir das Schreiben von unnötigem Code – besonders bei kurzen Funktionen oder Event-Handling.

---

## 🔁 Zusammenfassung

| Thema              | Was es macht                  | Warum nutzen?                      | Typischer Use Case                 |
| ------------------ | ----------------------------- | ---------------------------------- | ---------------------------------- |
| **Thread**         | Code gleichzeitig ausführen   | UI bleibt reaktionsfähig           | Datei laden, Netzwerk-Anfragen     |
| **Observer**       | Reaktion auf Zustandsänderung | Locker gekoppelter, reaktiver Code | UI aktualisieren bei Datenänderung |
| **Anonyme Klasse** | Klasse schnell definieren     | Für kleine Einmal-Jobs             | Button-Handler, Event-Listener     |
| **Lambda**         | Kurzform für Funktionen       | Weniger Code, moderne Syntax       | Streams, Sortieren, Threads        |

