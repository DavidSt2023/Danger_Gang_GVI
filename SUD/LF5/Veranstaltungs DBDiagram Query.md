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
  Person_ID INT [pk]
  Startdatum DATE [pk]
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
  PNr_Leiter INT [pk]
  Startdatum DATE [pk]
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

Ref: "Personen"."Person_ID" < "Teilnehmer"."Person_ID"

Ref: "Personen"."Person_ID" < "Kursleiter"."Person_ID"

Ref: "Teilnehmer"."Person_ID" < "Kursbuchung"."Person_ID"

Ref: "Standort"."Standort_ID" < "Kursveranstaltung"."Standort_ID"

Ref: "Kursbuchung"."PNr_Leiter" < "Kursveranstaltung"."PNr_Leiter"

Ref: "Themengebiet"."Themen_ID" < "Kurs"."Themen_ID"

Ref: "Kursveranstaltung"."Kurs_ID" < "Kurs"."Kurs_ID"
```