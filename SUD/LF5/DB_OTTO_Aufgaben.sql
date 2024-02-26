-- 1
SELECT LFirma, LOrt
FRom lieferant
WHERE
    `LLand` = 'USA'
ORDER BY `LOrt`;

-- 2
SELECT *
FROM artikel
WHERE
    `Auslaufartikel`;

-- 3
SELECT Lb.`Bestelldatum`, l.`LFirma`
FROM
    lieferant l
        INNER JOIN liefbestellung Lb ON l.LNr = Lb.`FKLieferant`
WHERE
    Lb.`Bestelldatum` = '2021-04-26'
  AND l.`LFirma` LIKE 'F%ini';

-- 4
SELECT *
FROM artikel Ar
         INNER JOIN warengruppe Wg ON Ar.`FKWarengruppe` = Wg.`WGNr`
WHERE
    Wg.`Beschreibung` LIKE '%Nudeln%';

-- 5
SELECT *
FROM kunde
WHERE
    `KdNachname` LIKE 'M__er';

-- 6
SELECT *
FROM artikel Ar
         INNER JOIN warengruppe Wg ON Ar.`FKWarengruppe` = Wg.`WGNr`
WHERE
    NOT Wg.`GruppenName` LIKE '%Süßwaren%'
ORDER BY Wg.`GruppenName`, Ar.`Artikelname`;

-- 7
SELECT *
FROM kunde ku
         INNER JOIN kdauftrag ka ON ku.`KdNr` = ka.`FKKunde`
WHERE
    ka.`Auftragsdatum` BETWEEN '2021-06-01' AND '2021-06-31'
   OR ka.`Lieferdatum` BETWEEN '2021-06-01' AND '2021-06-31';

-- 8
SELECT *
FROM
    lieferant li
        INNER JOIN liefbestellung lb ON li.`LNr` = lb.`FKLieferant`
WHERE
    lb.`Bestelldatum` BETWEEN '2021-03-01' AND '2021-05-31'
  AND li.`LFirma` LIKE 'Fr%markets';

-- 9
SELECT *
FROM personal
WHERE
    `Geschlecht` = 'W'
        AND `Geburtsdatum` > '1986-01-01'
   OR `Bemerkungen` LIKE '%University of California%';

-- 10
SELECT *
FROM
    kunde ku
        INNER JOIN kdauftrag kd ON ku.`KdNr` = kd.`FKKunde`
        INNER JOIN abweichenderversand av ON av.`AuftragsNr` = kd.`AuftragsNr`
WHERE
    av.`Land` = 'USA'
  AND ku.`KdLand` <> 'USA';

-- 11
SELECT li.`LFirma`,ar.*, la.Angebotspreis
FROM
    lieferant li
        INNER JOIN liefangebot la ON li.`LNR` = la.`FKLieferant`
        INNER JOIN artikel ar ON ar.`ArtikelNr` = la.`FKArtikel`
        INNER JOIN warengruppe wg ON wg.WGNr = ar.FKWarengruppe
WHERE ar.`Auslaufartikel` <> 1 AND ar.`Lagerbestand` =  0 OR wg.GruppenName like '%Fleisch%';

-- 12
SELECT *
FROM
    kunde ku
        INNER JOIN kdauftrag kd ON kd.FKKunde = ku.KdNr
WHERE kd.Lieferdatum IN ('2021-06-04', '2021-06-11', '2021-06-18');

-- 13
SELECT Vorname, Nachname FROM personal WHERE Titel is null;

-- 14
SELECT *
FROM
    liefbestellung lb
        INNER JOIN lieferant li ON li.LNr = lb.Bestelldatum
WHERE lb.Bestelldatum between '2021-01-13' AND '2021-03-15' AND
      li.LFirma like '%markets' AND li.LFirma <> 'F%' AND li.LFirma <> 'B%';

-- 15
SELECT KdNachname, KdTelefon FROM kunde
WHERE KdNachname REGEXP '^[L-N].*';

-- 16
SELECT artikel.Artikelname, ROUND(verkaufspreis *1.19, 2) AS Bruttopreis FROM artikel;

-- 17
SELECT Artikelname, (Mindestbestand - Lagerbestand) AS Bestellmenge FROM artikel WHERE Mindestbestand > Lagerbestand;

-- 18
SELECT AuftragsNr, DATEDIFF(Versanddatum, Auftragsdatum) AS Dauer
FROM kdauftrag
WHERE YEAR(Auftragsdatum) = 2019 and MONTH(Auftragsdatum) >= 6;

-- 19
SELECT Artikelname, ROUND(Verkaufspreis * 1.19,2) AS BruttoVerkaufspreis
FROM
    artikel ar
        INNER JOIN warengruppe wg ON ar.FKWarengruppe = wg.WGNr
WHERE wg.Beschreibung <> '%Meeresfrüchte%' or wg.Beschreibung <> '%Fleischprodukte%'
ORDER BY Verkaufspreis LIMIT 5;

-- 20

-- 21
SELECT
    `Vorname`,
    `DurchwahlOffice`,
    FLOOR(DATEDIFF(CURDATE(), `Geburtsdatum`) / 365)
FROM
    personal
WHERE
    TIMESTAMPDIFF(YEAR, `Geburtsdatum`, CURDATE()) BETWEEN 25
    AND 35

-- 22
SELECT Artikelname,Angebotsdatum, DATEDIFF('2021-10-01',Angebotsdatum) as Tage_Seit_Bestellung
FROM
    liefangebot la
        INNER JOIN artikel ar ON la.FKArtikel = ar.ArtikelNr
WHERE DATEDIFF('2021-10-01',Angebotsdatum) > 15;

-- 23

-- 24
SELECT Artikelname, BestellteAnzahl, Bestelldatum
FROM
    artikel ar
        INNER JOIN liefbestellposition lbp ON lbp.FKArtikel = ar.ArtikelNr
        INNER JOIN liefbestellung lb ON lb.Bestellnr = lbp.FKBestellung
WHERE MONTH(Bestelldatum) = 5 or DAY(Bestelldatum) = 30;

-- 25
SELECT LFirma, ArtikelNr, Artikelname, ROUND((BestellteAnzahl * Einkaufspreis * (1-Lieferantenrabatt) * 1.19),2) AS Gesamtpreis
FROM
    liefbestellposition lbp
        INNER JOIN artikel ar ON lbp.FKArtikel = ar.ArtikelNr
        INNER JOIN liefbestellung lb ON lbp.FKBestellung = lb.Bestellnr
        INNER JOIN lieferant lf ON lb.FKLieferant = lf.LNr
ORDER BY ROUND((BestellteAnzahl * Einkaufspreis * (1-Lieferantenrabatt) * 1.19),2) DESC
LIMIT 10;

-- 26
SELECT ArtikelNr, Artikelname, ROUND((((Verkaufspreis * (1- Rabatt)) - Einkaufspreis)* -1),2) AS Verlust
FROM
    liefbestellposition lbp
        INNER JOIN artikel ar ON lbp.FKArtikel = ar.ArtikelNr
        INNER JOIN liefbestellung lb ON lbp.FKBestellung = lb.Bestellnr
        INNER JOIN lieferant li ON lb.FKLieferant = li.LNr
WHERE (Verkaufspreis - Einkaufspreis) < 0 and YEAR(Bestelldatum) in (2020, 2021);

-- 26 ohne Rabatt
SELECT ArtikelNr, Artikelname, ROUND(((Verkaufspreis - Einkaufspreis)* -1),2) AS Verlust
FROM
    liefbestellposition lbp
        INNER JOIN artikel ar ON lbp.FKArtikel = ar.ArtikelNr
        INNER JOIN liefbestellung lb ON lbp.FKBestellung = lb.Bestellnr
        INNER JOIN lieferant li ON lb.FKLieferant = li.LNr
WHERE (Verkaufspreis - Einkaufspreis) < 0 and YEAR(Bestelldatum) in (2020, 2021);
