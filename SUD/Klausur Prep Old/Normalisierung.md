# Normalisierung

* Wenn man eine Zeile ändert, und dadurch Daten in einer anderen Zeile kaputt gehen, ist die finale Normalform noch nicht erreich
* Wenn ich eine Position ändere, will ich nicht noch eine zweite Position ändern müssen

## 1. Normalform

![](./assets/normalform-1-vorher.png)

![](./assets/normalform-1-nachher.png)

* atomar
>
> * fachlich: Jedes Attribut der Relation muss einen atomaren Wertebereich haben, und die Relation muss frei von Wiederholungsgruppen sein
> * oder: Eine Tabelle liegt in der ersten Normalform vor, wenn jeder Attributwert eine atomare, nicht weiter zerlegbare
Dateneinheit ist.

* jede Zelle hat genaue eine Information

## 2. Normalform

**Regel:** Eine Tabelle ist in der 2. Normalform, wenn alle Nicht-Schlüsselattribute vom gesamten Primärschlüssel abhängen. Ist dies nicht der Fall, so muss das Nichtschlüsselattribut in eine separate Tabelle ausgelagert werden.

* jede Zeile muss einzigartig sein
* Primärschlüssel darf sich nicht doppeln

![](./assets/normalform-2-vorher.png)

![](./assets/normalform-2-nachher.png)

* CD-Table enthält nur noch Felder, die `voll funktional` von `CD_ID` abhängen
* `Albumtitel` hängt nur von `CD_ID` ab -> nicht voll umfänglich vom gesamten Schlüssel abhängig -> eigene Tabelle

## 3. Normalform

**Regel:** Die dritte Normalform ist erreicht, wenn sich die Tabellen in 2NF befindet, und kein Nichtschlüsselattribut (hellgraue Zellen in der Tabelle) von einem anderen Nichtschlüsselattribut funktional abhängig ist.

* keine transitiven Abhängigkeiten untereinander
* nur noch direkte Abhängigkeiten -> alles hängt von irgendeinem Primärschlüssel in eigener Tabelle ab

![](./assets/normalform-3-vorher.png)

![](./assets/normalform-3-nachher.png)

* Gründungsjahr ist von Interpret abhängig
* hat nichts mit CD zu tun
* wird in eigene Tabelle ausgelagert

![](./assets/normalform-3-nachher-schoen.png)
