USE dbotto --(1)	Löschen Sie alle Aufträge, die keine Auftragspositionen haben, da sie keinen Sinn ergeben.

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