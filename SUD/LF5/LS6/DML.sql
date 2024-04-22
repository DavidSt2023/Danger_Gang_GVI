-- DML
-- 1
DELETE FROM kdauftrag WHERE kdauftrag.AuftragsNr NOT IN
(SELECT kdauftragsposition.FKAuftrag FROM kdauftragsposition);

-- 2
UPDATE
    artikel
SET
    Verkaufspreis = Verkaufspreis * 1.1
WHERE
    ArtikelNr IN (
        SELECT
            FKArtikel
        FROM
            kdauftragsposition
        GROUP BY
            FKArtikel
        HAVING
            COUNT(FKArtikel) > 20
);

-- 3
UPDATE artikel SET Auslaufartikel = 1 ,  Verkaufspreis = (Verkaufspreis - Verkaufspreis * 0.4) WHERE NOT ArtikelNr IN (
    SELECT
        ArtikelNr
    FROM
        kdauftragsposition kap
            LEFT JOIN kdauftrag kd ON FKAuftrag = AuftragsNr
            LEFT JOIN artikel ON FKArtikel = ArtikelNr
    WHERE
        Year(Auftragsdatum) = 2021
    GROUP BY
        FKArtikel
    HAVING
        COUNT(FKArtikel) > 1
);

-- 4

SELECT AVG(sub.Amount) FROM
(
    SELECT FKArtikel, COUNT(FKArtikel) as Amount
       FROM kdauftragsposition ka
       INNER JOIN dbotto.kdauftrag k on ka.FKAuftrag = k.AuftragsNr
       GROUP BY FKArtikel, Year(Auftragsdatum)
) sub GROUP BY FKArtikel
HAVING AVG(sub.Amount) > 10;

-- 5

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

-- 6
DELETE FROM
    kdauftrag
WHERE
    AuftragsNr IN (
        SELECT
            kdauftrag.AuftragsNr
        FROM
            kdauftrag
        WHERE
            YEAR(Auftragsdatum) = 2019
        GROUP BY
            AuftragsNr
    );

DELETE FROM
    kdauftragsposition
WHERE
    FKAuftrag IN (
        SELECT
            AuftragsNr
        FROM
            kdauftrag
        WHERE
            YEAR(Auftragsdatum) = 2019
    );

DELETE FROM
    abweichenderversand
WHERE
    AuftragsNr IN (
        SELECT
            AuftragsNr
        FROM
            kdauftrag
        WHERE
            YEAR(Auftragsdatum) = 2019
    );