
--1
SELECT
    li.`LFirma`
    ,la.Bestellungen Bestellungen
    ,lb.Bestellungen Angebote
FROM
    lieferant li
    INNER JOIN (SELECT COUNT(`FKLieferant`) Bestellungen,`FKLieferant` FROM liefangebot GROUP BY `FKLieferant` ) lb ON li.`LNr` = lb.`FKLieferant`
    INNER JOIN (SELECT COUNT(`Bestellnr`) Bestellungen,`FKLieferant` FROM liefbestellung GROUP BY `FKLieferant`) la ON li.`LNr` = la.`FKLieferant`
    GROUP BY li.`LNr`
    ORDER BY li.`LFirma`

--2
SELECT
    `Artikelname`
    ,la.`FKLieferant`
    ,MINVerkauf
FROM
    artikel ar
    INNER JOIN (
        SELECT
            MIN(`Angebotspreis`) MINVerkauf,
            `FKArtikel`,
            `FKLieferant`
        FROM
            liefangebot
        GROUP BY
            `FKArtikel`
    ) la ON ar.`ArtikelNr` = la.`FKArtikel`
    INNER JOIN lieferant li ON la.
GROUP BY
    ar.`ArtikelNr`

--3

SELECT
    lfirma,
    artikelname,
    minPreis,
    ROUND(angebotspreis * (1 - lieferantenrabatt), 2) AS preisangebot
FROM
    liefangebot
    INNER JOIN artikel ON artikelnr = liefangebot.FKArtikel
    INNER JOIN lieferant ON FKLieferant = LNr
    INNER JOIN (
        SELECT
            FKArtikel,
            ROUND(MIN(angebotspreis * (1 - lieferantenrabatt)), 2) AS minPreis
        FROM
            liefangebot la
            INNER JOIN lieferant ON lnr = FKLieferant
        GROUP BY
            FKArtikel
    ) AS qryMinPreise ON minPreis = ROUND((angebotspreis * (1 - lieferantenrabatt)), 2)
    AND qryMinPreise.FKArtikel = liefangebot.FKArtikel;

--4
SELECT GruppenName, ROUND( AVG( Mengenschnitt ),1)  AS 'Durchschnitt Auftragsmenge'
FROM warengruppe INNER JOIN 
(
SELECT FKwarengruppe, ArtikelNr, AVG(Anzahl) AS Mengenschnitt FROM artikel INNER JOIN kdauftragsposition ON ArtikelNr = FKartikel
GROUP BY ArtikelNr
) AS schnitt
 ON WGNr = FKwarengruppe
GROUP BY WGNr;

--5
SELECT KdNr, KdNachname FROM kunde WHERE KdNr NOT IN 
(
SELECT FKkunde FROM kdauftrag a INNER JOIN abweichenderversand av		ON  a.auftragsNr = av.auftragsNr
);

--6
SELECT
    kdnr,
    kdvorname,
    kdnachname
FROM
    kunde
WHERE
    kdnr NOT IN (
        SELECT
            FKkunde
        FROM
            kdauftrag
        WHERE
            YEAR(auftragsdatum) = 2020
            AND MONTH(auftragsdatum) = 05
    );

--7
SELECT
    Vorname,
    Nachname,
    DATEDIFF(CURDATE(), Geburtsdatum) / 365.25 AS Age
FROM
    personal
WHERE
    DATEDIFF (CURDATE(), Geburtsdatum) / 365.25 > (
        SELECT
            AVG(DATEDIFF(CURDATE(), Geburtsdatum) / 365.25)
        FROM
            personal
    );

--8
SELECT
    Artikelname
FROM
    artikel
WHERE
    ArtikelNr NOT IN (
        SELECT
            FKArtikel
        FROM
            kunde
            INNER JOIN kdauftrag ON kdnr = FKkunde
            INNER JOIN kdauftragsposition ON FKAuftrag = auftragsnr
        WHERE
            kdland = 'Deutschland'
    )
--9

SELECT kdnr, kdvorname, kdnachname, ROUND( AVG( auftragswert ) ,2) AS durchschnitt
FROM kunde INNER JOIN kdauftrag ON FKkunde = KdNr INNER JOIN
( 
 SELECT FKAuftrag, SUM( anzahl * verkaufspreis * (1 - rabatt) * 1.19) AS auftragswert
 FROM artikel INNER JOIN kdauftragsposition  ON artikelNr = FKartikel
 GROUP BY FKAuftrag
) AS qryAuftragswert
ON qryAuftragswert.FKauftrag = AuftragsNr
GROUP BY kdnr
ORDER BY durchschnitt DESC
LIMIT 5;

--10
SELECT
    DISTINCT Kunde.kdland
FROM
    Kunde
WHERE
    kdland NOT IN (
        SELECT
            DISTINCT Kunde.kdland
        FROM
            versandfirma
            INNER JOIN kdAuftrag ON VNr = kdAuftrag.FKVersandfirma
            INNER JOIN Kunde ON KdNr = FKkunde
        WHERE
            vfirma = 'Speedy Express'
    )
