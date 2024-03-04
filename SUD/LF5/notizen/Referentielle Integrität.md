# Referentielle Integrität
Die referentielle Integrität verhindert verwaiste Child-Elemente

## Parent-Tabelle

Die Tabelle, auf deren Primärschlüssel verwiesen wird, heißt Parent-Tabelle.

## Child-Tabelle

Die Tabelle, die den bzw. die Fremdschlüssel enthält, bezeichnet man als Child-Tabelle.

## Update-Anomalie

Die referentielle Integrität verhindert Update des Primärschlüsselattributs in einem Datensatz der Parent-Tabelle, wenn es zugehörige Datensätze in der Child-Tabelle gibt.

Klasse -> **KlassenNr**, KlassenRaum
Schüler -> **SchülerNr**, Name, *KlassenNr*

Man kann nicht einfach in der Tabelle Klasse die KlassenNr ändern, da es sonst zu Problemen in der Schüler-Tabelle kommt.

## Einfüge-Anomalie

Die referentielle Integrität verhindert das Einfügen eines Datensatzes in der Child-Tabelle, wenn es keinen zugehörigen Datensatz in der Parent-Tabelle gibt.

Klasse -> **KlassenNr  [PK]**, KlassenRaum
Schüler -> **SchülerNr [PK]**, Name, *KlassenNr*

Man kann nicht einfach eine neue KlassenNr der Schüler-Tabelle verwenden, ohne sie vorher in der KlassenTabelle definiert zu haben!

## Lösch-Anomalie

Die referentielle Integrität verhindert das Löschen eines Datensatzes in der Parent-Tabelle, wenn es zugehörige Datensätze in der Child-Tabelle gibt.

Klasse -> **KlassenNr [PK]**, KlassenRaum
Schüler -> **SchülerNr [PK]**, Name, *KlassenNr*

Ich kann nicht einfach die KlassenNr in der Tabelle Klasse löschen, da es sonst die KlassenNr in der Schülertabelle auf ein leeres Feld zeigt!