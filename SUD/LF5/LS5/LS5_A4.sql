
--1
SELECT
    KdNr,
    KdNachname,
    ifnull(
        SUM(
            ROUND(verkaufspreis * (1 - rabatt) * 1.19 * Anzahl, 2)
        ),
        0
    ) AS Warenumsatz
FROM
    kunde
    LEFT JOIN kdauftrag ON kdnr = FKkunde
    LEFT JOIN kdauftragsposition ON FKauftrag = auftragsnr
    LEFT JOIN artikel ON FKartikel = artikelnr
GROUP BY
    KdNr
ORDER BY
    Warenumsatz;

--2 
SELECT LFirma, ifnull( AnzahlBestellungen, 0) AS AnzahlBestellungen,ifnull(AnzahlAngebote, 0) AS AnzahlAngebote
FROM lieferant  
LEFT JOIN 
(SELECT FKLieferant, COUNT(*) AS AnzahlBestellungen  FROM liefbestellung
 GROUP BY FKLieferant
) AS qryBestellzahl 
ON LNr = qryBestellzahl.FKLieferant
LEFT JOIN 
(SELECT FKLieferant, COUNT(*) AS AnzahlAngebote 
 FROM liefangebot
 GROUP BY FKLieferant
) AS qryAngebotszahl 
ON LNr = qryAngebotszahl.FKLieferant
ORDER BY Lfirma;

SELECT PersonalNr, Nachname, 
	    COUNT(kdauftrag.AuftragsNr) AS 'Anzahl Aufträge'
FROM personal 
	LEFT JOIN kdauftrag ON PersonalNr = FKBearbeiter
GROUP BY PersonalNr;

--3

SELECT PersonalNr, nachname, 
	    COUNT(kdauftrag.AuftragsNr) AS 'Anzahl Aufträge'
FROM personal 
	LEFT JOIN kdauftrag ON PersonalNr = FKBearbeiter
GROUP BY PersonalNr;

--4
SELECT ArtikelName, ROUND( AVG(BestellteAnzahl * Einkaufspreis), 2) AS BestellSchnitt, ROUND( AVG( Anzahl * Verkaufspreis), 2) AS Auftragsschnitt
FROM artikel 
		LEFT JOIN liefbestellposition ON ArtikelNr = liefbestellposition.FKArtikel
		LEFT JOIN kdauftragsposition ON ArtikelNr = kdauftragsposition.FKArtikel
GROUP BY ArtikelNr;

--5
SELECT artikelname, COUNT(FKArtikel) AS Häufigkeit,IFNULL(SUM(Anzahl), 0) AS Menge
FROM artikel LEFT JOIN kdauftragsposition ON artikelNr = FKArtikel
GROUP BY ArtikelNr
HAVING Häufigkeit <= 5;

--6
SELECT lfirma, 
	IFNULL(SUM(Einkaufspreis*BestellteAnzahl) , 0) AS Bestellbetrag
FROM lieferant  JOIN liefbestellung ON lnr = fklieferant LEFT JOIN liefbestellposition ON Bestellnr = fkBestellung
WHERE lLand != 'Deutschland'
GROUP BY LNr
HAVING Bestellbetrag < 5000;

--7
SELECT
    artikelname,
    IFNULL(eingang, 0) AS eingang,
    lagerbestand,
    IFNULL(ausgang, 0) AS ausgang,
    (IFNULL(eingang, 0) - IFNULL(ausgang, 0)) AS sollBestand
FROM
    artikel
    LEFT JOIN (
        SELECT
            FKArtikel,
            SUM(BestellteAnzahl) AS eingang
        FROM
            liefbestellposition
        WHERE
            LieferungErhalten = 1
        GROUP BY
            FKArtikel
    ) AS qryEingang ON artikelNr = qryEingang.FKArtikel
    LEFT JOIN (
        SELECT
            FKArtikel,
            SUM(Anzahl) AS ausgang
        FROM
            kdauftragsposition
        GROUP BY
            FKArtikel
    ) AS qryAusgang ON artikelNr = qryAusgang.FKArtikel
HAVING
    lagerbestand <> (
        IFNULL(
            (
                SELECT
                    SUM(qryEingang.bestellteAnzahl)
                FROM
                    liefbestellposition
                WHERE
                    LieferungErhalten = 1
                    AND FKArtikel = artikel.artikelNr
            ),
            0
        ) - IFNULL(
            (
                SELECT
                    SUM(qryAusgang.anzahl)
                FROM
                    kdauftragsposition
                WHERE
                    FKArtikel = artikel.artikelNr
            ),
            0
        )
    );
