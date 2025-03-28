USE dbotto 

--(1)	Löschen Sie alle Aufträge, die keine Auftragspositionen haben, da sie keinen Sinn ergeben.
DELETE FROM
    kdauftrag
WHERE
    `AuftragsNr` IN (
        SELECT
            `AuftragsNr`
        FROM
            kdauftrag
            LEFT JOIN kdauftragsposition ON `FKAuftrag` = `AuftragsNr`
        WHERE
            `FKAuftrag` IS NULL
    ) 

--(2)	Heben Sie die Preise von gut verkauften Artikeln (mehr als 20 Kundenaufträge) um 10% an. 

UPDATE
    artikel
SET
    `Verkaufspreis` = `Verkaufspreis` * 1.1
WHERE
    `ArtikelNr` IN (
        SELECT
            `FKArtikel`
        FROM
            kdauftragsposition
        GROUP BY
            `FKArtikel`
        HAVING
            COUNT(`FKArtikel`) > 20
    )
    
/*(3)
     Kennzeichnen Sie schlecht zu verkaufende Artikel als Auslaufartikel und senken Sie deren Preise um 60%. 
     Als Kriterium soll dienen, ob sie im Jahr 2021 höchstens ein Mal verkauft wurden. */

UPDATE
    artikel
SET
    `Auslaufartikel` = 1,
    `Verkaufspreis` = (`Verkaufspreis` - `Verkaufspreis` * 0.4)
WHERE
    NOT `ArtikelNr` IN (
        SELECT
            `ArtikelNr`
        FROM
            kdauftragsposition kap
            LEFT JOIN kdauftrag kd ON `FKAuftrag` = `AuftragsNr`
            LEFT JOIN artikel ON `FKArtikel` = `ArtikelNr`
        WHERE
            Year(`Auftragsdatum`) = 2021
        GROUP BY
            `FKArtikel`
        HAVING
            COUNT(`FKArtikel`) > 1
    )

/*(4)
Verdoppeln Sie den Mindestbestand der Artikel,
die im Durchschnitt mehr als 10 Mal pro Jahr an Kunden verkauft wurden.
*/

UPDATE artikel SET `Mindestbestand` = `Mindestbestand` * 2
WHERE
    `ArtikelNr` IN (
        SELECT
            `FKArtikel`
        FROM
            (
                SELECT
                    `FKArtikel`,
                    COUNT(`FKArtikel`) AS Amount
                FROM
                    kdauftragsposition ka
                    INNER JOIN kdauftrag kp ON `FKAuftrag` = `AuftragsNr`
                GROUP BY
                    `FKArtikel`,
                    Year(`Auftragsdatum`)
            ) sub
        GROUP BY
            `FKArtikel`
        HAVING
            AVG(sub.Amount) > 10 
    ) AND `Mindestbestand` <> 0 
    
CREATE table kdAuftragSAV
SELECT * FROM abweichenderversand WHERE AuftragsNr IN
(SELECT FKAuftrag
FROM kdauftragsposition kap
         INNER JOIN dbotto.artikel a on kap.FKArtikel = a.ArtikelNr
WHERE Lagerbestand = 0
  and Auslaufartikel = 1
GROUP BY FKAuftrag
);

CREATE table kdAuftragspositionSAV
SELECT * FROM kdauftragsposition kap
                 INNER JOIN dbotto.artikel a on kap.FKArtikel = a.ArtikelNr
        WHERE Lagerbestand = 0
          and Auslaufartikel = 1
GROUP BY FKAuftrag;


--5
CREATE table abweichenderVersandSAV
SELECT *
       FROM kdauftragsposition kap
                INNER JOIN dbotto.artikel a on kap.FKArtikel = a.ArtikelNr
       WHERE Lagerbestand = 0
         and Auslaufartikel = 1
       GROUP BY FKAuftrag;


DELETE FROM abweichenderversand WHERE AuftragsNr IN
(SELECT FKAuftrag
FROM kdauftragsposition kap
    INNER JOIN dbotto.artikel a on kap.FKArtikel = a.ArtikelNr
WHERE Lagerbestand = 0
  and Auslaufartikel = 1
GROUP BY FKAuftrag
);

DELETE FROM kdauftrag WHERE AuftragsNr IN
(SELECT FKAuftrag
 FROM kdauftragsposition kap
          INNER JOIN dbotto.artikel a on kap.FKArtikel = a.ArtikelNr
 WHERE Lagerbestand = 0
   and Auslaufartikel = 1
 GROUP BY FKAuftrag
);

DELETE FROM kdauftragsposition WHERE FKAuftrag IN
(SELECT FKAuftrag
  FROM kdauftragsposition kap
           INNER JOIN dbotto.artikel a on kap.FKArtikel = a.ArtikelNr
  WHERE Lagerbestand = 0
    and Auslaufartikel = 1
  GROUP BY FKAuftrag
);

DELETE FROM artikel WHERE Auslaufartikel = 1 and Lagerbestand = 0;

/* 
(6) 
Die Kunden - Auftragsdaten des ersten Betriebsjahres (Jahreszahl des Datums)
 von Otto & Co.werden für betriebsinterne Zwecke nicht mehr benötigt.
 Sie sollen daher aus der Datenbank gelöscht werden.

 Kontrolle: alteKdPositionen 427 Datensätze mit vorheriger Löschung in Aufgabe 
 (1) + (5) (513 ohne) alteAbweichenderVersand 6 Datensätze mit (10 ohne) 
 Löschung alteKdAuftrag 168 Datensätze mit (194 ohne) Löschung
*/


DELETE FROM
    kdauftrag
WHERE
    `AuftragsNr` IN (
        SELECT
            kdauftrag.`AuftragsNr`
        FROM
            kdauftrag
        WHERE
            YEAR(`Auftragsdatum`) = 2019
        GROUP BY
            `AuftragsNr`
    )

DELETE FROM
    kdauftragsposition
WHERE
    `FKAuftrag` IN (
        SELECT
            `AuftragsNr`
        FROM
            kdauftrag
        WHERE
            YEAR(`Auftragsdatum`) = 2019
    )

DELETE FROM
    abweichenderversand
WHERE
    `AuftragsNr` IN (
        SELECT
            `AuftragsNr`
        FROM
            kdauftrag
        WHERE
            YEAR(`Auftragsdatum`) = 2019
    )

