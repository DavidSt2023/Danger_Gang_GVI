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

SELECT
    `AuftragsNr`,
    `ArtikelNr`,
    `Verkaufspreis`,
    ROUND(SUM(`Verkaufspreis`) *(1 - `Rabatt`) * 1.19, 2)
FROM
    artikel
    INNER JOIN kdauftragsposition kp ON `ArtikelNr` = `FKArtikel`
    INNER JOIN kdauftrag ka ON kp.`FKAuftrag` = ka.`AuftragsNr`
WHERE
    `Auftragsdatum` BETWEEN '2020-01-01'
    AND '2020-03-31'
GROUP BY
    `AuftragsNr`



-- 21
SELECT
    Vorname,
    DurchwahlOffice,
    FLOOR(DATEDIFF(CURDATE(), Geburtsdatum) / 365)
FROM
    personal
WHERE
    TIMESTAMPDIFF(YEAR, Geburtsdatum, CURDATE()) BETWEEN 25
    AND 35;

-- 22
SELECT Artikelname,Angebotsdatum, DATEDIFF('2021-10-01',Angebotsdatum) as Tage_Seit_Bestellung
FROM
    liefangebot la
        INNER JOIN artikel ar ON la.FKArtikel = ar.ArtikelNr
WHERE DATEDIFF('2021-10-01',Angebotsdatum) > 15;

-- 23
SELECT LFirma, Artikelname, ROUND((Angebotspreis * (1-Lieferantenrabatt)),2) as PreisMitRabatt
FROM
    liefangebot la
        INNER JOIN artikel ar ON la.FKArtikel = ar.ArtikelNr
        INNER JOIN lieferant li ON la.FKLieferant = li.LNr
WHERE Artikelname like 'C%' or Artikelname like 'I%'
ORDER BY Artikelname, ROUND((Angebotspreis * (1-Lieferantenrabatt)),2);

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



-- Aufgabe 3
--1
SELECT `KdLand`,COUNT(`KdLand`)  from kunde,kdauftrag  GROUP BY `KdLand`

--2
SELECT
    COUNT(kd.`FKKunde`),
    ku.`KdNachname`
from
    kunde ku
    INNER JOIN kdauftrag kd ON ku.`KdNr` = kd.`FKKunde`
WHERE
    ku.`KdLand` = 'Deutschland'
GROUP BY
    kd.`FKKunde`
HAVING
    COUNT(kd.`FKKunde`) > 5

--3
SELECT ROUND(MAX(`Verkaufspreis`),2),ROUND(MIN(`Verkaufspreis`),2) FROM artikel 


--4
SELECT ROUND(MAX(`Verkaufspreis`),2),ROUND(AVG(`Verkaufspreis`),2),ROUND(MIN(`Verkaufspreis`),2) FROM artikel 

--5
SELECT wa.`GruppenName`,ROUND(MAX(`Verkaufspreis`),2),ROUND(AVG(`Verkaufspreis`),2),ROUND(MIN(`Verkaufspreis`),2) FROM artikel INNER JOIN warengruppe wa ON `FKWarengruppe` = `WGNr` GROUP BY `FKWarengruppe`  HAVING AVG(`Verkaufspreis`) > 21  AND  MAX(`Verkaufspreis`) < 100 



-- 6
SELECT Artikelname,
       SUM(Anzahl) AS Gesamt
FROM
    artikel ar
        INNER JOIN kdauftragsposition kap ON ar.ArtikelNr = kap.FKArtikel
GROUP BY Artikelname
HAVING
    SUM(Anzahl) > 700;

-- 7
SELECT Artikelname,
       COUNT(Artikelname) AS Anzahl_Angebote,
       ROUND(MIN(Angebotspreis),2) AS MIN_Preis,
       ROUND(AVG(Angebotspreis),2) AS AVG_Preis,
       ROUND(MAX(Angebotspreis),2) AS MAX_Preis
FROM
    liefangebot la
        INNER JOIN artikel ar ON la.FKArtikel = ar.ArtikelNr
GROUP BY Artikelname;

-- 8
SELECT LFirma, Artikelname, BestellteAnzahl
FROM
    lieferant li
        INNER JOIN liefbestellung lb ON li.LNr = lb.FKLieferant
        INNER JOIN liefbestellposition lbp ON lb.Bestellnr = lbp.FKBestellung
        INNER JOIN artikel ar ON lbp.FKArtikel = ar.ArtikelNr
WHERE
    BestellteAnzahl < 60
GROUP BY
    LFirma;

-- 9
SELECT Vorname, Nachname, COUNT(PersonalNr) AS Anzahl_Auftrage
FROM
    personal p
        INNER JOIN kdauftrag k on p.PersonalNr = k.FKBearbeiter
GROUP BY PersonalNr;

-- 10
SELECT GruppenName,
       ROUND(AVG(Lagerbestand),1) AS AVG_Lagerbestand
FROM
    artikel ar
        INNER JOIN warengruppe wg ON ar.FKWarengruppe = wg.WGNr
GROUP BY FKWarengruppe;

-- 11
SELECT GruppenName,
       ROUND(SUM((Verkaufspreis * Lagerbestand)),2) AS Netto_Wert
FROM
    artikel ar
        INNER JOIN warengruppe wg ON ar.FKWarengruppe = wg.WGNr
GROUP BY FKWarengruppe
HAVING ROUND(SUM((Verkaufspreis * Lagerbestand)),2) > 100000;

-- 12
SELECT KdVorname,
       KdNachname,
       MAX(DATEDIFF(Versanddatum, Auftragsdatum)) AS MAX_Zeit,
       ROUND(AVG(DATEDIFF(Versanddatum, Auftragsdatum)),2) AS AVG_Zeit
FROM
    kunde k
        INNER JOIN kdauftrag ka ON k.KdNr = ka.FKKunde
GROUP BY KdNachname
ORDER BY KdNachname;

-- 13

SELECT
    li.`LFirma`
    ,ROUND(SUM(lip.`BestellteAnzahl`* lip.`Einkaufspreis`),2)
FROM
    liefbestellung lb
    INNER JOIN liefbestellposition lip ON lb.`Bestellnr` = lip.`FKBestellung`   
    INNER JOIN lieferant li ON lb.`FKLieferant` = li.`LNr`
GROUP BY
    lb.`Bestellnr`
    HAVING
    SUM(lip.`BestellteAnzahl`* lip.`Einkaufspreis`) >= 500
    AND SUM(lip.`BestellteAnzahl`* lip.`Einkaufspreis`)<=  1000


-- 14
SELECT KdNachname,
       AuftragsNr,
       ROUND(SUM((Verkaufspreis * Anzahl * (1 - Rabatt) * 1.19)),2) AS Warenumsatz,
       ROUND((SUM((Verkaufspreis * Anzahl * (1 - Rabatt) * 1.19)) + Frachtkosten),2) AS Rechnungsbetrag
FROM
    kunde k
        INNER JOIN kdauftrag ka ON k.KdNr = ka.FKKunde
        INNER JOIN kdauftragsposition kap ON ka.AuftragsNr = kap.FKAuftrag
        INNER JOIN artikel ar ON kap.FKArtikel = ar.ArtikelNr
WHERE MONTH(Auftragsdatum) < 4 and YEAR(Auftragsdatum) = 2019
GROUP BY AuftragsNr;
