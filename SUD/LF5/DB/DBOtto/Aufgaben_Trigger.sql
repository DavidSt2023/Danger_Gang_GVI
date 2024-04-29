
USE dbotto


--(1)
CREATE TABLE PreisHistorie (
    Id INT AUTO_INCREMENT,
    ArtikelNr int,
    alterPreis float,
    neuerPreis float,
    AenderungsDatum TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (ID)
) 

DELIMITER//
CREATE TRIGGER saveOldPrice AFTER UPDATE ON artikel 
FOR EACH ROW BEGIN 
IF OLD.Verkaufspreis <> NEW.Verkaufspreis THEN 
    INSERT INTO PreisHistorie 
    SET ArtikelNr = OLD.ArtikelNr,
        alterPreis = OLD.Verkaufspreis,
        neuerPreis = NEW.Verkaufspreis;
END if;
END;
//DELIMITER;

UPDATE artikel   INNER JOIN warengruppe ON FKwarengruppe = WGNr SET Verkaufspreis = Verkaufspreis * 1.05 WHERE GruppenName  = 'Fleischprodukte' OR GruppenName = 'Meeresfrüchte'


SELECT * FROM kdauftragsposition INNER JOIN artikel ON `ArtikelNr` = `FKArtikel`


DELIMITER// CREATE TRIGGER newBestandOnPositions
AFTER
INSERT
    ON kdauftragsposition FOR EACH ROW BEGIN 
UPDATE
    artikel
SET `Lagerbestand`= `Lagerbestand` - NEW.Anzahl
WHERE `ArtikelNr` = NEW.FKArtikel;
END;
//DELIMITER;

INSERT INTO kdauftragsposition (`FKAuftrag`,`FKArtikel`,`Anzahl`) Values(10370,2,20)

SELECT * FROM liefbestellposition WHERE LieferungErhalten = 1

CREATE TRIGGER newBestandOnUpdatePositions
AFTER
    UPDATE 
    ON liefbestellposition FOR EACH ROW BEGIN
    IF NEW.LieferungErhalten = 1 THEN 
UPDATE
    artikel
SET
    `Lagerbestand` = `Lagerbestand` + NEW.BestellteAnzahl
WHERE
    `ArtikelNr` = NEW.FKArtikel;
END IF;
END;

CREATE TRIGGER newBestandOnInsertPositions
AFTER
INSERT
    ON liefbestellposition FOR EACH ROW BEGIN IF NEW.LieferungErhalten = 1 THEN
UPDATE
    artikel
SET
    `Lagerbestand` = `Lagerbestand` + NEW.BestellteAnzahl
WHERE
    `ArtikelNr` = NEW.FKArtikel;

END IF;

END;

INSERT INTO liefbestellposition (`FKBestellung`,`FKArtikel`,`BestellteAnzahl`,`LieferungErhalten`)VALUES (397,1,25,1)



--(4)
CREATE TABLE deletedKdauftragpositionen LIKE kdauftragsposition

CREATE TABLE deletedKdauftrag LIKE kdauftrag

CREATE TRIGGER saveAuftrag BEFORE DELETE ON kdauftrag FOR EACH ROW BEGIN
INSERT INTO
    deletedKdauftrag
VALUES
    (
        OLD.AuftragsNr,
        OLD.FKKunde,
        OLD.FKBearbeiter,
        OLD.Auftragsdatum,
        OLD.Versanddatum,
        OLD.Lieferdatum,
        OLD.FKVersandfirma,
        OLD.`Frachtkosten`
    );
END;

CREATE TRIGGER saveAuftragPosition BEFORE DELETE ON kdauftragsposition FOR EACH ROW BEGIN
INSERT INTO
    deletedKdauftragpositionen (FKAuftrag, FKArtikel, Anzahl)
VALUES
    (OLD.`FKAuftrag`, OLD.FKArtikel, OLD.Anzahl);
END;

