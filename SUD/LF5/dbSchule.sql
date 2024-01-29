CREATE DATABASE dbschule;
USE dbschule;

CREATE TABLE Fachbereich
(
    fachBereichID INT NOT NULL AUTO_INCREMENT,
    fachBereich VARCHAR(30) NOT NULL,
    PRIMARY KEY (fachBereichID)
);

CREATE TABLE Fach
(
    fachID INT NOT NULL AUTO_INCREMENT,
    fachBereichID INT NOT NULL,
    FOREIGN KEY (fachBereichID)
        REFERENCES Fachbereich(fachBereichID),
    PRIMARY KEY (fachID)
);

CREATE TABLE Note
(
    schuelerID INT NOT NULL,
    fachID INT NOT NULL,
    notenartID INT NOT NULL,
    zeitpunkt VARCHAR(30) NOT NULL,
    note CHAR(2) NOT NULL,
    FOREIGN KEY (schuelerID)
        REFERENCES Schueler(schuelerID),
    FOREIGN Fach(fachID),
    REFERENCES Fach(fachID),
    FOREIGN KEY (notenartID)
        REFERENCES Notenart(notenartID),
    PRIMARY KEY(fachID, notenartID, zeitpunkt, schuelerID)
);

CREATE TABLE Schueler
(
    schuelerID INT NOT NULL AUTO_INCREMENT,
    vorname CHAR(30) NOT NULL,
    nachname CHAR(30) NOT NULL,
    strasse VARCHAR(30) NOT NULL,
    ort CHAR(30) NOT NULL,
    PRIMARY KEY (schuelerID)
);

CREATE TABLE Funktion(
    funktionID INT NOT NULL AUTO_INCREMENT,
    Funktion VARCHAR(30) NOT NULL,
    PRIMARY KEY (funktionID)
);

CREATE TABLE Raum
(
    raumID INT NOT NULL AUTO_INCREMENT,
    funktionID INT NOT NULL,
    PRIMARY KEY (raumID),
    FOREIGN KEY (funktionID)
        REFERENCES Funktion(funktionID)
);

CREATE TABLE Lehrer
(
    lehrerKuerzel CHAR(3) NOT NULL,
    nachname CHAR(30) NOT NULL,
    telefonNr VARCHAR(30) NOT NULL,
    geburtsdatum DATE,
    nationalitaet CHAR(20) DEFAULT 'deutsch',
    PRIMARY KEY (lehrerKuerzel)
);

CREATE TABLE Stundenplan
(
    klassenID INT NOT NULL,
    lehrerID CHAR(3) NOT NULL,
    fachBereichID INT NOT NULL,
    wochentag CHAR(10) NOT NULL,
    stunde INT NOT NULL,
    raumID INT NOT NULL,
    FOREIGN KEY (klassenID)
        REFERENCES Klasse(klassenID),
    FOREIGN KEY (lehrerID)
        REFERENCES Lehrer(lehrerKuerzel),
    FOREIGN KEY (fachBereichID)
        REFERENCES Fachbereich(fachBereichID),
    FOREIGN KEY (raumID)
        REFERENCES Raum(raumID),
    PRIMARY KEY (raumID, wochentag, stunde)
);

CREATE TABLE Bildungsgang
(
    bildungsgangID INT NOT NULL AUTO_INCREMENT,
    bildungsgangBez VARCHAR(30) NOT NULL,
    bildungsgangLeiter CHAR(3) NOT NULL,
    FOREIGN KEY (bildungsgangLeiter)
        REFERENCES Lehrer(lehrerKuerzel),
    PRIMARY KEY (bildungsgangID)
);

CREATE TABLE Klasse
(
    klassenID INT NOT NULL AUTO_INCREMENT,
    klassenLehrer CHAR(3) NOT NULL,
    bildungsgangID INT NOT NULL,
    FOREIGN KEY (klassenLehrer)
        REFERENCES Lehrer(lehrerKuerzel),
    FOREIGN KEY (bildungsgangID)
        REFERENCES Bildungsgang(bildungsgangID),
    PRIMARY KEY (klassenID)
);

CREATE TABLE Notenart
(
    notenartID INT NOT NULL AUTO_INCREMENT,
    notenartBez VARCHAR(30),
    PRIMARY KEY (notenartID)
);

--David: Lehrer, Bildungsgang, Klasse
--Julian: Unterrichtsstunde, Raum, Funktion
--Lukas: Schueler, Note, Fach, Fachbereich