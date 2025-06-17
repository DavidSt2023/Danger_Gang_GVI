#### Glossar

| Kürzel   | begriff                      | Bedeutung                                    |
| -------- | ---------------------------- | -------------------------------------------- |
| **DBMS** | Datenbank Management system  |                                              |
| **DML**  | Data Manipulation Language   | Daten einfügen oder Löschen                   |
| **DQL**  | Data Query Language          | Abfragen                                     |
| **DDL**  | Data Definition Language     | Datenbanken anlegen                          |
| **DCL**  | Data Control Language        | Verwaltung von Zugriffsrechten auf Tabellen  |
| **TCL**  | Transaction Control Language | Sicherungsmaßnahmen bei der Datenübertragung |
#### DDL
##### Database
``` MYSQL
CREATE DATABASE testDB;

SHOW DATABASES;

DROP DATABASE testDB;
```
##### Table

- ein **UNIQUE INDEX** sorgt dafür das kein selber wert in der Tabelle stehen darf in fall von mit Mitarbeiter soll kein Mitarbeiter den selben Kürzel haben
``` MYSQL
USE testDB;

SHOW TABLES;

CREATE TABLE Mitarbeiter
(
	MAID INT NOT NULL AUTO_INCREMENT,
	Kurzel CHAR (4),
	Vorname CHAR(30) NOT NULL,
	Nachname CHAR(30) NOT NULL,
	geburtsdatum DATE,
	Strasse CHAR(30),
	Ort CHAR(30),
	gehalt float,
	Ersthelfer BOOLEAN,
	Angestellt BOOLEAN DEFAULT TRUE,
	PRIMARY KEY (MAID),
	UNIQUE INDEX(Kurzel)
);
CREATE TABLE Auftrag
(
	AuftragsID INT NOT NULL AUTO_INCREMENT,
	Bearbeiter INT NOT NULL,
	PRIMARY KEY (AuftragsID),
	FOREIGN KEY (MAID) REFERENCES Mitarbeiter(MAID)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT
);

SHOW COLUMNS FROM Mitarbeiter;
```
#### Table Änderung oder löschen
``` MYSQL
DROP TABLE Auftrag;

ALTER TABLE Mitarbeiter
	ADD Hausnummer INT;

ALTER TABLE Mitarbeiter
	DROP geburtsdatum;

ALTER TABLE Mitarbeiter
	MODIFY Angestellter TINYINT;

CREATE [UNIQUE] INDEX MAID_INDEX ON Mitarbeiter(MAID);

SHOW INDEX FROM users;

DROP INDEX MAID_INDEX ON Mitarbeiter;

```

#### INDEX 
 Ein Index ermöglichet eine schnellere suche 
![[Screenshot 2024-06-02 165131.png]]
#### DML 

``` MYSQL 
INSERT INTO Mitarbeiter(Kuerzel,Vorname,Nachname,geburstag)VALUES
('HEKO','Helmut','Kohl','1990-06-01'),
('WISK','Wilma','Skuba','1992-11-05');
```