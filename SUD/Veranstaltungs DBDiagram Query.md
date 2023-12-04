```
 TABLE Personen {
    Person_ID INT [pk]
    Vorname VARCHAR(255)
    Nachname VARCHAR(255)
    Str VARCHAR(255)
    PLZ VARCHAR(255)
    ORT VARCHAR(255)
}

TABLE Teilnehmer{
  Person_ID INT [pk]
  Bonitaet INT
}

TABLE Kursbuchung {
  Person_ID INT
  Startdatum DATE
  PNr_Leiter INT
}

TABLE Kursleiter {
  Person_ID INT [pk]
  Stundensatz INT
}

TABLE Standort {
  Standort_ID INT [pk]
  Str VARCHAR(255)
  PLZ VARCHAR(255)
  ORT VARCHAR(255)
  AnzahlRaeume INT
}

TABLE Kursveranstaltung {
  PNr_Leiter INT
  Startdatum DATE
  Kurs_ID INT
  Standort_ID INT
}

TABLE Themengebiet {
  Themen_ID INT [pk]
  Themenbezeichnung VARCHAR(255)
  Tagespreis INT
}

TABLE Kurs {
  Kurs_ID INT [pk]
  Themen_ID INT
}
```