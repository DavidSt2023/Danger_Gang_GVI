-- TRIGGER

-- 1
CREATE TABLE PreisHistorie(
    Id int AUTO_INCREMENT,
    Aenderungsdatum date,
    ArtikelNr int,
    alterPreis int,
    neuerPreis int,
    PRIMARY KEY (Id),
    FOREIGN KEY (ArtikelNr) REFERENCES artikel(ArtikelNr)
);


DELIMITER //
CREATE TRIGGER saveOldPrice AFTER UPDATE ON artikel
    FOR EACH ROW
    BEGIN
        IF OLD.Verkaufspreis <> NEW.Verkaufspreis
            THEN
            INSERT INTO PreisHistorie
            SET ArtikelNr = OLD.ArtikelNr,
                alterPreis = OLD.Verkaufspreis,
                neuerPreis = NEW.Verkaufspreis,
                Aenderungsdatum = CURRENT_DATE;
        END IF;
    END;
//
DELIMITER ;

UPDATE artikel
SET Verkaufspreis = Verkaufspreis * 1.05
WHERE FKWarengruppe IN (
    SELECT WGNr FROM warengruppe WHERE GruppenName LIKE 'Meeresfrüchte' OR GruppenName LIKE 'Fleischprodukte'
    );

-- 2

DELIMITER //
CREATE TRIGGER decreaseLagerbestand AFTER UPDATE ON kdauftragsposition
    FOR EACH ROW
    BEGIN
        UPDATE artikel
        SET Lagerbestand = Lagerbestand - NEW.Anzahl
        WHERE ArtikelNr = NEW.FKArtikel;
    end;
//
DELIMITER ;

-- 3

DELIMITER //
CREATE TRIGGER increaseLagerbestand AFTER UPDATE ON liefbestellposition
    FOR EACH ROW
    BEGIN
        IF OLD.LieferungErhalten <> NEW.LieferungErhalten
            THEN
            UPDATE artikel
            SET Lagerbestand = Lagerbestand + NEW.BestellteAnzahl
            WHERE ArtikelNr = NEW.FKArtikel;
        END IF;
    END;
//
DELIMITER ;

-- 4

CREATE TABLE kdauftragSave (
                             AuftragsNr int(11) NOT NULL,
                             FKKunde int(11) DEFAULT NULL,
                             FKBearbeiter int(11) DEFAULT NULL,
                             Auftragsdatum date DEFAULT NULL,
                             Versanddatum date DEFAULT NULL,
                             Lieferdatum date DEFAULT NULL,
                             FKVersandfirma int(11) DEFAULT NULL,
                             Frachtkosten decimal(18,5) DEFAULT 0.00000
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE kdauftragspositionSave (
                                      FKAuftrag int(11) NOT NULL,
                                      FKArtikel int(11) NOT NULL,
                                      Anzahl int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE abweichenderversandSave (
                                       AuftragsNr int(11) NOT NULL DEFAULT 0,
                                       Empfaenger varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                       Str varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                       Ort varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                       PLZ varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                       Land varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DELIMITER //
CREATE TRIGGER saveOldAuftraege BEFORE DELETE ON kdauftrag
    FOR EACH ROW
    BEGIN

    END;
//
DELIMITER ;