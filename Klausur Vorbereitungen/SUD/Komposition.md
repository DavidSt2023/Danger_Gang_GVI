
---

### 🔁 **Komposition (Komposition statt Vererbung)**

**Komposition** bedeutet, dass eine Klasse andere Objekte enthält und deren Funktionen nutzt, anstatt von einer Klasse zu erben.

#### 🧠 **Warum?**

Komposition erlaubt dir, Klassen flexibel zusammenzusetzen, ohne starre Vererbungsstrukturen. Du kannst Verhalten kombinieren, ohne alles erben zu müssen.

#### 📌 **Use Case:**

Ein Auto kann z. B. einen Motor, ein Radio, und Reifen enthalten. Diese Komponenten ändern sich oft oder sollen austauschbar sein – das geht mit Komposition viel besser als mit Vererbung.
**Beispiel:**

```java
class Motor {
    void starten() {
        System.out.println("Motor startet...");
    }
}

class Auto {
    private Motor motor = new Motor(); // Komposition

    void fahren() {
        motor.starten();
        System.out.println("Auto fährt...");
    }
}
```

➡️ **Vorteil:** Besser wartbar und flexibler als Vererbung. Vermeidet die Probleme einer starren Vererbungshierarchie.

---

### 🔄 **Dependency Inversion Principle (DIP)**

**Prinzip:** High-Level-Module (z. B. Geschäftslogik) sollen nicht direkt von Low-Level-Modulen (z. B. Datenbank) abhängen. Beide sollen von **Abstraktionen** abhängen.

#### 🧠 **Warum?**

Damit dein Code leicht austauschbar und testbar ist. Wenn du Interfaces nutzt, kannst du später neue Versionen (z. B. andere Datenbanken, Dienste) einbauen ohne alles umzuschreiben.

#### 📌 **Use Case:**

Du hast eine App, die den Nutzer per E-Mail benachrichtigt. Später willst du auf WhatsApp oder SMS umsteigen. Dank DIP brauchst du dann nur eine neue Klasse schreiben, die dasselbe Interface benutzt – keine Änderungen am restlichen Code.

**Java Beispiel:**

```java
interface Nachrichtendienst {
    void sendeNachricht(String text);
}

class EmailDienst implements Nachrichtendienst {
    public void sendeNachricht(String text) {
        System.out.println("Email: " + text);
    }
}

class BenutzerBenachrichtiger {
    private Nachrichtendienst dienst;

    public BenutzerBenachrichtiger(Nachrichtendienst dienst) {
        this.dienst = dienst;
    }

    public void benachrichtige(String text) {
        dienst.sendeNachricht(text);
    }
}
```

➡️ **Vorteil:** Austauschbarkeit, z. B. später durch `SmsDienst` ersetzbar, ohne `BenutzerBenachrichtiger` zu ändern.

---

### 🚪 **Open/Closed Principle (OCP)**

**Prinzip:** Eine Klasse sollte **offen für Erweiterungen**, aber **geschlossen für Veränderungen** sein.

#### 🧠 **Warum?**

Damit du bestehenden Code nicht ändern musst, wenn neue Anforderungen kommen. Statt Code zu ändern, erweiterst du ihn.

#### 📌 **Use Case:**

Ein Onlineshop soll neue Rabattarten bekommen (z. B. Black Friday, Student, Treueprogramm). Du willst dafür keine bestehenden Klassen anfassen, sondern nur neue Strategien hinzufügen – das klappt perfekt mit OCP.

**Java Beispiel mit Strategy Pattern:**

```java
interface RabattStrategie {
    double berechneRabatt(double betrag);
}

class KeinRabatt implements RabattStrategie {
    public double berechneRabatt(double betrag) {
        return betrag;
    }
}

class WeihnachtsRabatt implements RabattStrategie {
    public double berechneRabatt(double betrag) {
        return betrag * 0.9;
    }
}

class BestellungsRechner {
    private RabattStrategie strategie;

    public BestellungsRechner(RabattStrategie strategie) {
        this.strategie = strategie;
    }

    public double berechneGesamt(double betrag) {
        return strategie.berechneRabatt(betrag);
    }
}
```

➡️ **Vorteil:** Neue Rabattstrategien können **hinzugefügt** werden, ohne alte Klassen anzufassen.

---

### 🔁 **DRY – Don't Repeat Yourself**

**Prinzip:** Vermeide **doppelten Code**. Jeder Wissensbereich soll **nur einmal** im Code abgebildet sein.

#### 🧠 **Warum?**

Wiederholter Code ist fehleranfällig und schwer zu warten. Wenn du etwas ändern musst, musst du es an vielen Stellen ändern. DRY sorgt für klaren, sauberen Code.

#### 📌 **Use Case:**

Du berechnest die Fläche eines Kreises an 5 Stellen im Code. Wenn sich die Formel ändert oder du z. B. Einheiten anpassen willst, musst du alles durchgehen. Mit einer gemeinsamen Methode (berechneFlaeche(radius)) brauchst du nur eine Änderung.

**Schlechtes Beispiel:**

```java
double flaeche1 = 3.14 * radius1 * radius1;
double flaeche2 = 3.14 * radius2 * radius2;
```

**Besser:**

```java
double berechneKreisflaeche(double radius) {
    return Math.PI * radius * radius;
}
```

➡️ **Vorteil:** Weniger Fehler, leichter wartbar.

---

### 🔁 **Liskov Substitution Principle (LSP)**

**Prinzip:** Subklassen sollen sich **wie ihre Oberklassen** verhalten – sie sollen austauschbar sein.

#### 🧠 Warum?

Wenn du eine Unterklasse anstelle einer Oberklasse einsetzt, soll nichts kaputtgehen. Die Unterklasse soll sich wie die Oberklasse verhalten.

#### 📌 Use Case:

Du hast ein Vogel-Interface mit fliegen(). Dann erstellst du Pinguin extends Vogel – aber der kann nicht fliegen. Wenn du Pinguin in einem Vogel-System benutzt, kracht's.

➡️ Lösung: Besser unterschiedliche Interfaces (z. B. Flugfaehig, Laufvogel) – so hältst du LSP ein.

**Schlechtes Beispiel:**

```java
class Vogel {
    void fliegen() {}
}

class Pinguin extends Vogel {
    void fliegen() {
        throw new UnsupportedOperationException(); // Problem!
    }
}
```

➡️ **Besser:** Statt `Vogel` als Basisklasse, evtl. `Tier` oder ein Interface wie `Flugfaehig`.

---

### 🧱 **SRP – Single Responsibility Principle**

**Prinzip:** Eine Klasse soll **nur eine einzige Verantwortung** haben.

#### 🧠 Warum?
Wenn eine Klasse mehr als eine Aufgabe hat, wird sie schwer zu testen, zu ändern und zu verstehen. Mit SRP ist jede Klasse fokussiert und übersichtlich.

#### 📌 Use Case:
Ein RechnungsManager, der Rechnungen berechnet, speichert und per Mail verschickt, hat 3 Verantwortungen. Wenn sich eine davon ändert (z. B. Mail-Format), musst du alle anderen Teile anfassen. Besser ist: Eine Klasse pro Aufgabe.

**Schlechtes Beispiel:**

```java
class Bericht {
    void generieren() {}
    void speichern() {}
    void perEmailVersenden() {}
}
```

**Besser:**

```java
class BerichtGenerator { void generieren() {} }
class BerichtSpeicher { void speichern() {} }
class EmailVersender { void senden() {} }
```

➡️ **Vorteil:** Bessere Wartbarkeit, Wiederverwendbarkeit, Testbarkeit.

---

### 🧠 **KISS – Keep It Simple, Stupid**

**Prinzip:** Schreibe **einfachen, klaren Code**. Vermeide unnötige Komplexität.

#### 🧠 Warum?
Einfacher Code ist leichter zu verstehen, zu warten und zu testen. Komplexität ist der Feind – du musst den Code nicht clever, sondern klar schreiben.
#### 📌 Use Case:
Du willst prüfen, ob zwei Werte gleich sind:

**Schlecht:**

```java
if ((a && b) || (!a && !b)) { ... } // schwer lesbar
```

**Besser:**

```java
if (a == b) { ... } // einfacher und klarer
```

➡️ **Ziel:** Einfacher Code ist leichter zu verstehen, zu testen und zu warten.

---

