CREATE database dbSchule;

use dbSchule;

CREATE TABLE Schueler ( schuelerID INT NOT NULL AUTO_INCREMENT, vorname
CHAR(30) NOT NULL, nachname CHAR(30) NOT NULL, straße VARCHAR(30) NOT
NULL, ort CHAR(30) NOT NULL, PRIMARY KEY (schuelerID) );

CREATE TABLE Lehrer ( lehrerKuerzel CHAR(3) NOT NULL, nachname CHAR(30)
NOT NULL, telefonNr VARCHAR(30) NOT NULL, geburtsdatum DATE,
nationalitaet CHAR(20) DEFAULT \'deutsch\', PRIMARY KEY (lehrerKuerzel)
);

CREATE TABLE Bildungsgang ( bildungsgangID INT NOT NULL AUTO_INCREMENT,
bildungsgangBez VARCHAR(30) NOT NULL, PRIMARY KEY (bildungsgangID) );

CREATE TABLE Fach ( fachID INT NOT NULL AUTO_INCREMENT, fachBereichID
INT NOT NULL, FOREIGN KEY (fachBereichID) REFERENCES
Fachbereich(fachBereichID), PRIMARY KEY (fachID) );

CREATE TABLE Raum ( raumID INT NOT NULL AUTO_INCREMENT, raumFunktion
VARCHAR(30), PRIMARY KEY (raumID) );

CREATE TABLE Fachbereich ( fachBereichID INT NOT NULL AUTO_INCREMENT,
fachBereich VARCHAR(30) NOT NULL PRIMARY KEY (fachBereichID) );

CREATE TABLE Klasse ( klassenID INT NOT NULL AUTO_INCREMENT,
klassenLehrer CHAR(3) NOT NULL, bildungsgangID INT NOT NULL, FOREIGN KEY
(klassenLehrer) REFERENCES Lehrer(lehrerKuerzel), FOREIGN KEY
(bildungsgangID) REFERENCES Bildungsgang(bildungsgangID), PRIMARY KEY
(klassenID) );

CREATE TABLE Stundenplan ( stundenplanID INT NOT NULL AUTO_INCREMENT,
klassenID INT NOT NULL, lehrerID CHAR(3) NOT NULL, fachBereichID INT NOT
NULL, datum DATE NOT NULL, stunde INT NOT NULL, raumID INT NOT NULL,
FOREIGN KEY (klassenID) REFERENCES Klasse(klassenID), FOREIGN KEY
(lehrerID) REFERENCES Lehrer(lehrerID), FOREIGN KEY (fachBereichID)
REFERENCES FachBereich(fachBereichID), REFERENCES (raumID) FOREIGN
Raum(raumID), PRIMARY KEY (stundenplanID) );

CREATE TABLE Noten ( schuelerID INT NOT NULL, fachID INT NOT NULL,
notenartID INT NOT NULL, FOREIGN KEY (schuelerID) REFERENCES
Schueler(schuelerID), FOREIGN Fach(fachID), REFERENCES Fach(fachID),
FOREIGN KEY (notenartID) REFERENCES Notenart(notenartID), );

CREATE TABLE Notenart ( notenartID INT NOT NULL AUTO_INCREMENT,
notenartBez VARCHAR(30), PRIMARY (notenartID) );
