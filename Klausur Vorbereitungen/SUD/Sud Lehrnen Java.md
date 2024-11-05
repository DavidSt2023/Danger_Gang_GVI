#### Arten von Loops 
----
- ##### Bedingungsgesteuerte Schleifen
- ##### while
	- Führt den Schleifenkörper **nur aus, wenn die Bedingung zu Beginn `true` ist**. Wenn die Bedingung am Anfang `false` ist, wird die Schleife kein einziges Mal ausgeführt.
- ##### do while
	- Führt den Schleifenkörper **mindestens einmal aus**, da die Bedingung erst am Ende des Schleifenblocks geprüft wird. 
```java
int count = 10;

// while-Schleife
while (count < 5) {
System.out.println("Das wird nicht gedruckt.");
};

// do-while-Schleife
do {
System.out.println("Das wird einmal gedruckt, auch wenn count >= 5 ist.");
} while (count < 5);
```
```console
Das wird einmal gedruckt, auch wenn count >= 5 ist.
```
- ##### for
	```java
	for (Initialisierung; Bedingung; Änderung) {
    // Schleifenanweisungen
	}
	for (int i = 0; i < 5; i++) {
    System.out.println("Die aktuelle Zahl ist: " + i);
	}
	//for Each
	int[] zahlen = {1, 2, 3, 4, 5};
	for (int zahl : zahlen) {
	    System.out.println("Zahl: " + zahl);
	}

	```
	
 - Fagen presi:
1. Worin besteht der Unterschied zwischen einer kopf- und einer fußgesteuerten Schleife?​
    - **Kopfgesteuerte Schleife**: Die Bedingung wird vor dem Ausführen des Schleifenblocks geprüft. Beispiele sind die `while`-Schleife und die `for`-Schleife. Wenn die Bedingung am Anfang `false` ist, wird der Schleifenblock kein einziges Mal ausgeführt.
    
	- **Fußgesteuerte Schleife**: Die Bedingung wird erst nach dem Ausführen des Schleifblocks geprüft. Ein Beispiel ist die `do-while`- Schleife. Der Schleifen block wird immer mindestens einmal ausgeführt, da die Bedingung erst am Ende geprüft wird.
	  
	kurz: **Kopf prüft vor der ersten Iiteration, fuß prüft erstnach der ersten Iiteration ab**
	
	
2. Was ist ein anderer Name für "Schleife"?​
	- Ein anderer Begriff für "Schleife" ist **Iteration**.
	  
3.  Was ist der Überbegriff für Verzweigungen und Schleifen?​
	    **Kontrollstrukturen**
	
4. Wie sieht das Struktogramm-Symbol für eine kopfgesteuerte Schleife aus?​
    ![[Pasted image 20241103145755.png]]
5. Wie kann man bei Schleifen-Struktogrammsymbolen erkennen, was zu wiederholen ist?​
    -  Im Struktogramm ist der Anweisungsblock, der sich innerhalb des Schleifenrahmens befindet, der Teil, der wiederholt wird. Die Anweisungen innerhalb des Schleifensymbols sind eingerahmt und damit klar als wiederholbar markiert.
      
6. Was sind andere Begriffe für kopf- und fußgesteuerte Schleifen?​
    - **Kopfgesteuerte Schleife**: Wird auch als **"Eingangskontrollierte Schleife"** bezeichnet.
	- **Fußgesteuerte Schleife**: Wird auch als **"Ausgangskontrollierte Schleife"** bezeichnet.
	  
7. Wie viele Anweisungen kann man in einer Schleife wiederholen?​
    - In einer Schleife kann man **beliebig viele Anweisungen** wiederholen, von einer einzelnen bis hin zu komplexen Blöcken mit vielen Zeilen Code.
      
8. Kann man auch eine Verzweigung wiederholen?​
    - Ja, eine Verzweigung kann innerhalb einer Schleife platziert werden und somit wiederholt werden. Zum Beispiel kann ein `if`-Statement innerhalb einer `while`- oder `for`-Schleife wiederholt ausgeführt werden.
      
9. Wofür benötigt man geschweifte Klammern bei Schleifen?
   - Geschweifte Klammern `{}` werden bei Schleifen benötigt, um den **Block von Anweisungen** zu kennzeichnen, der in jeder Iteration der Schleife ausgeführt wird. Wenn nur eine einzelne Anweisung wiederholt wird, sind sie optional, aber für mehrere Anweisungen sind sie erforderlich, um die Blockstruktur zu kennzeichnen.
---- 

### Methoden

```java
Zugriffsmodifizierer Rückgabewert Methodenname (Parameterliste) {
    // Methodenkörper (Code, der ausgeführt wird)
}
```
**Details zu den Bestandteilen:**
- **Zugriffsmodifizierer**: Bestimmt, wer die Methode aufrufen kann. Häufige Modifizierer sind:
    - `public`: Die Methode ist von überall im Programm aufrufbar.
    - `private`: Die Methode ist nur innerhalb der Klasse aufrufbar.
    - `protected`: Die Methode ist innerhalb des Pakets und von Unterklassen aufrufbar.

- **Rückgabewert**: Gibt den Datentyp an, den die Methode zurückgibt (z.B. `int`, `String`, `void` für keine Rückgabe).

- **Methodenname**: Sollte beschreiben, was die Methode macht (z.B. `berechneSumme`).

- **Parameterliste**: Optional. Eine Liste von Eingabewerten, die die Methode akzeptiert, z.B. `(int a, int b)`.
- **Methodenkörper**: Der Codeblock, der ausgeführt wird, wenn die Methode aufgerufen wird.
##### Beispiel einer Methode ohne Rückgabewert (`void`)
```java 
public void begruessen(String nachricht) {
    System.out.println(nachricht);
}
public void druckeNachricht(String nachricht, int anzahl) {
    for (int i = 0; i < anzahl; i++) {
        begruessen(nachricht);
    }
}

```
##### Beispiel einer Methode mit Rückgabewert
```java
public int addiere(int a, int b) {
    return a + b;
}
int ergebnis = addiere(5, 7); 
System.out.println("Das Ergebnis ist: " + ergebnis); 
// Ausgabe: Das Ergebnis ist: 12
```
---
-  Arrays
#### Beispiel array
```java
int[] zahlenleer; // Deklaration eines Arrays, das int-Werte speichern kann

int[] zahlen = {10, 20, 30, 40, 50}; // Ein Array mit Werten direkt initialisiert
zahlen = new int[5]; // Initialisierung eines Arrays mit 5 Elementen (Standardwert: 0)


```
#### werte ändern im Array
```java 
int[] zahlen = {10, 20, 30, 40, 50};

// Zugriff auf das erste Element
System.out.println(zahlen[0]); // Ausgabe: 10

// Ändern des Werts des dritten Elements
zahlen[2] = 100;
System.out.println(zahlen[2]); // Ausgabe: 100

```
### loop durch array
``` java
int[] zahlen = {10, 20, 30, 40, 50};

for (int i = 0; i < zahlen.length; i++) {
    System.out.println("Element " + i + ": " + zahlen[i]);
}
```
---
- #### Bubblesort
	**Beschreibung**:
	- Bubblesort ist ein einfacher Sortieralgorithmus, bei dem benachbarte Elemente wiederholt verglichen und vertauscht werden, wenn sie in der falschen Reihenfolge sind. Dieser Vorgang wird so lange wiederholt, bis das gesamte Array sortiert ist.
	
	**Funktionsweise**:
	
	- In jedem Durchlauf wird das größte unsortierte Element an das Ende der Liste „gebubbelt“.
	- Der Prozess wird für die restlichen unsortierten Elemente wiederholt, bis das Array vollständig sortiert ist.
	```java
	public void bubbleSort(int[] array) {
	    int n = array.length;
	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            if (array[j] > array[j + 1]) {
	                // Tauschen
	                int temp = array[j];
	                array[j] = array[j + 1];
	                array[j + 1] = temp;
	            }
	        }
	    }
	}
	
	```
	**Eigenschaften**:
	
	- Einfach zu implementieren, aber ineffizient für große Arrays.


- ###  **Selectionsort**
	
	**Beschreibung**:
	
	- Selectionsort ist ein Sortieralgorithmus, bei dem wiederholt das kleinste (oder größte) Element aus dem unsortierten Teil des Arrays gesucht und an den Anfang (oder das Ende) verschoben wird.
	
	**Funktionsweise**:
	
	- Das Array wird in einen sortierten und einen unsortierten Teil geteilt.
	- Der Algorithmus sucht das kleinste Element im unsortierten Teil und tauscht es mit dem ersten Element des unsortierten Teils.
	- Der Vorgang wird für den Rest des Arrays wiederholt.
	```java
	public void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			// Tauschen
			int temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
	}
		
	```
	**Eigenschaften**:
	
	- Besser als Bubblesort in der Praxis, da weniger Vertauschungen notwendig sind, aber immer noch ineffizient für große Arrays.

- ### **Quicksort**
	
	**Beschreibung**:
	
	- Quicksort ist ein Divide-and-Conquer-Algorithmus, der das Array in kleinere Teile aufteilt, sortiert und dann die Teile zusammenführt. Er ist einer der effizientesten Algorithmen für große Datensätze.
	
	**Funktionsweise**:
	
	1. Wähle ein **Pivot-Element** (häufig das erste, letzte oder ein zufälliges Element).
	2. Teile das Array so, dass alle Elemente, die kleiner als das Pivot sind, links davon und alle, die größer sind, rechts davon liegen.
	3. Wiederhole den Vorgang rekursiv für die linken und rechten Teile.
	
	``` java
	public void quickSort(int[] array, int low, int high) {
	    if (low < high) {
	        int pivotIndex = partition(array, low, high);
	        quickSort(array, low, pivotIndex - 1);
	        quickSort(array, pivotIndex + 1, high);
	    }
	}
	
	private int partition(int[] array, int low, int high) {
	    int pivot = array[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (array[j] <= pivot) {
	            i++;
	            int temp = array[i];
	            array[i] = array[j];
	            array[j] = temp;
	        }
	    }
	    int temp = array[i + 1];
	    array[i + 1] = array[high];
	    array[high] = temp;
	    return i + 1;
	}
	
	```
	**Eigenschaften**:
	
	- Sehr effizient für große Arrays.
	- Nicht stabil, d.h. die relative Reihenfolge gleicher Elemente kann sich ändern.
	- In-Place, d.h. es benötigt keinen zusätzlichen Speicherplatz.

- ###  **Insertionsort**

	**Beschreibung**:
	- Insertionsort funktioniert ähnlich wie das Sortieren von Spielkarten. Das Array wird in einen sortierten und einen unsortierten Teil unterteilt, und in jeder Iteration wird ein Element aus dem unsortierten Teil genommen und in die richtige Position im sortierten Teil eingefügt.
	
	**Funktionsweise**:
	
	1. Beginne mit dem zweiten Element und vergleiche es mit den vorherigen Elementen.
	2. Verschiebe größere Elemente nach rechts, um Platz zu schaffen.
	3. Füge das aktuelle Element an der richtigen Stelle ein.
	```java
	public void insertionSort(int[] array) {
	    for (int i = 1; i < array.length; i++) {
	        int key = array[i];
	        int j = i - 1;
	        while (j >= 0 && array[j] > key) {
	            array[j + 1] = array[j];
	            j--;
	        }
	        array[j + 1] = key;
	    }
	}
	
	```
	**Eigenschaften**:
	- Einfach zu implementieren und gut für kleine oder fast sortierte Arrays.
	- Stabil, d.h. die relative Reihenfolge gleicher Elemente bleibt erhalten.
	- In-Place, benötigt keinen zusätzlichen Speicher.
#### Zusammenfassung:
- **Bubblesort** und **Selectionsort** sind einfach zu verstehen, aber ineffizient für große Arrays (O(n²)).
- **Insertionsort** ist besser für kleine oder fast sortierte Arrays.
- **Quicksort** ist der effizienteste Algorithmus unter den genannten, mit O(n log n) im Durchschnitt, aber kann im schlimmsten Fall O(n²) haben, wenn das Pivot-Element schlecht gewählt ist.
--- 
- Klassen
#### Struktur einer Klasse

Eine Klasse besteht aus:

1. **Eigenschaften** (auch **Attribute** oder **Felder** genannt): Das sind Variablen, die den Zustand oder die Daten eines Objekts beschreiben.
2. **Methoden**: Das sind Funktionen, die beschreiben, was ein Objekt tun kann.
```java
public class Auto {
    // Eigenschaften (Felder)
    String marke;
    String farbe;
    int baujahr;

    // Methode (Aktion)
    public void hupen() {
        System.out.println("Hup, Hup!");
    }
}

```


### Ein Objekt erstellen

Um eine Klasse zu verwenden, musst du ein **Objekt** erstellen. Ein Objekt ist eine Instanz der Klasse.
```java
public class Hauptprogramm {
    public static void main(String[] args) {
        // Ein Objekt der Klasse Auto erstellen
        Auto meinAuto = new Auto();
        
        // Werte für die Eigenschaften setzen
        meinAuto.marke = "VW";
        meinAuto.farbe = "Rot";
        meinAuto.baujahr = 2020;
        
        // Methode aufrufen
        meinAuto.hupen(); // Ausgabe: Hup, Hup!
        
        // Eigenschaften ausgeben
        System.out.println("Marke: " + meinAuto.marke);
        System.out.println("Farbe: " + meinAuto.farbe);
        System.out.println("Baujahr: " + meinAuto.baujahr);
    }
}

```

### Konstruktoren

Ein **Konstruktor** ist eine spezielle Methode, die aufgerufen wird, wenn ein Objekt erstellt wird. Damit kannst du einem Objekt direkt beim Erstellen Werte zuweisen.
```java
public class Auto {
    String marke;
    String farbe;
    int baujahr;

    // Konstruktor
    public Auto(String marke, String farbe, int baujahr) {
        this.marke = marke;
        this.farbe = farbe;
        this.baujahr = baujahr;
    }

    public void hupen() {
        System.out.println("Hup, Hup!");
    }
}

// Im Hauptprogramm:
public class Hauptprogramm {
    public static void main(String[] args) {
        // Objekt erstellen mit dem Konstruktor
        Auto meinAuto = new Auto("BMW", "Blau", 2021);

        // Eigenschaften ausgeben
        System.out.println("Marke: " + meinAuto.marke);
        System.out.println("Farbe: " + meinAuto.farbe);
        System.out.println("Baujahr: " + meinAuto.baujahr);
    }
}

```
### Vorteile von Klassen

- **Modularität**: Dein Code wird übersichtlicher, da du Funktionen und Daten in einzelnen Klassen kapseln kannst.
- **Wiederverwendbarkeit**: Einmal erstellte Klassen kannst du in anderen Programmen wiederverwenden.
- **Objektorientierte Programmierung (OOP)**: Klassen sind der Kern von OOP und erlauben dir, mit Objekten zu arbeiten, die Eigenschaften und Methoden haben, ähnlich wie echte Objekte im Alltag.

### Zusammenfassung

- Eine **Klasse** ist ein Bauplan für Objekte.
- **Eigenschaften** beschreiben den Zustand eines Objekts.
- **Methoden** sind Aktionen, die ein Objekt ausführen kann.
- Ein **Objekt** ist eine Instanz einer Klasse.
- **Konstruktoren** helfen, Objekte mit bestimmten Anfangswerten zu erstellen.