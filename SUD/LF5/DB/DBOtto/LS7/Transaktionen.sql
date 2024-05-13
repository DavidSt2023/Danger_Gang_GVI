START TRANSACTION;
-- GANZ VIEL TOLLER CODE
COMMIT; -- Erst jetzt ändert sich der Datenstand

START TRANSACTION;

INSERT INTO kdauftragsposition (FKAuftrag, FKArtikel, Anzahl)
VALUES (11085, 1, 1);

UPDATE artikel
SET Lagerbestand = Lagerbestand -1
    WHERE ArtikelNr = 1;

COMMIT;


-- A7
-- Erstellen Sie eine Transaktion, welche ein Insert auf eine Lieferauftragsposition
-- zum Lieferauftrag 1083 zusammen mit dem passenden Update auf die Tabelle Artikel ausführt.
-- Nutzen Sie dafür den Artikel Nummer 14.


START TRANSACTION;

INSERT INTO liefbestellposition (FKBestellung, FKArtikel, BestellteAnzahl, LieferungErhalten, Einkaufspreis)
VALUES (1083, 14, 5, 1, 1002);

UPDATE artikel
SET Lagerbestand = Lagerbestand + 5
    WHERE ArtikelNr = 14;

COMMIT;
