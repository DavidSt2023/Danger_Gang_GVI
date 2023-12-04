´´´
 TABLE Personen {
    Person_ID INT [pk]
    Name VARCHAR(255)
    Adresse VARCHAR(255)
    Teilnehmer_ID BOOLEAN
    Kursleiter INT
    Bonitaet VARCHAR(50)
}

TABLE Kurse {
    Kurs_ID INT [pk]
    Kursnummer VARCHAR(50)
    Kursbezeichnung VARCHAR(255)
    Themengebiet VARCHAR(255)
    Kursdauer_Tage INT
    Kursgebuehr_pro_Tag DECIMAL(10, 2)
}

TABLE Kursleiter_Kurse {
    Kursleiter_ID INT 
    Kurs_ID INT 
    Verguetung_pro_Stunde DECIMAL(10, 2)
}

TABLE Standorte {
    Standort_ID INT [pk]
    Adresse VARCHAR(255)
    Anzahl_Schulungsraeume INT
}

TABLE Kursveranstaltungen {
    Veranstaltungs_ID INT [pk]
    Kurs_ID INT 
    Standort_ID INT 
    Kursleiter_ID INT 
    Kursbeginn DATE
}
TABLE Teilnehmer{
  Teilnehmer_ID INT
  Person_ID INT
  Veranstaltungs_ID INT
}
ref:Kursveranstaltungen.Kursleiter_ID > Personen.Person_ID
ref: Kursveranstaltungen.Standort_ID > Standorte.Standort_ID
ref: Kursveranstaltungen.Kurs_ID > Kurse.Kurs_ID
ref:Kursleiter_Kurse.Kurs_ID > Kurse.Kurs_ID
ref:Kursleiter_Kurse.Kursleiter_ID > Personen.Person_ID

Ref: "Personen"."Teilnehmer_ID" < "Teilnehmer"."Teilnehmer_ID"
´´´