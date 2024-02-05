-- Schueler
INSERT INTO Schueler (vorname, nachname, strasse, ort) VALUES
('Laura', 'Schulz', 'Schulweg 789', 'Schulstadt'),
('Felix', 'Meier', 'Meierstraße 456', 'Meierstadt'),
('Sophie', 'Wagner', 'Wagnerweg 123', 'Wagnerstadt'),
('Tim', 'Becker', 'Beckerplatz 789', 'Beckerstadt'),
('Lena', 'Hoffmann', 'Hoffmannallee 456', 'Hoffmannstadt');

-- Lehrer
INSERT INTO Lehrer (lehrerKuerzel, nachname, telefonNr, geburtsdatum, nationalitaet) VALUES
('LS3', 'Schulze', '111-222333', '1985-08-25', 'deutsch'),
('LF4', 'Fischer', '444-555666', '1978-04-12', 'deutsch'),
('LS5', 'Schmidt', '777-888999', '1982-11-30', 'deutsch'),
('LK6', 'Koch', '000-999888', '1970-07-15', 'deutsch'),
('LS7', 'Schneider', '123-456789', '1987-03-05', 'deutsch');

-- Bildungsgang
INSERT INTO Bildungsgang (bildungsgangBez, leiterKuerzel) VALUES
('Physik', 'LS3'),
('Geschichte', 'LF4'),
('Sport', 'LS5'),
('Musik', 'LK6'),
('Geografie', 'LS7');

-- Raumfunktion
INSERT INTO Raumfunktion (raumFunktion) VALUES
('Bibliothek'),
('Sporthalle'),
('Computerlabor'),
('Kunstraum'),
('Mehrzweckraum');

-- Raum
INSERT INTO Raum (raumFunktion) VALUES
(3),
(2),
(1),
(4),
(5);

-- Fachbereich
INSERT INTO Fachbereich (fachBereich) VALUES
('Physik'),
('Geschichte'),
('Sport'),
('Musik'),
('Geografie');

-- Fach
INSERT INTO Fach (fachBereichID) VALUES
(1),
(2),
(3),
(4),
(5);

-- Klasse
INSERT INTO Klasse (klassenLehrer, bildungsgangID) VALUES
('LS3', 3),
('LF4', 2),
('LS5', 1),
('LK6', 4),
('LS7', 5);

-- Stundenplan
INSERT INTO Stundenplan (klassenID, lehrerID, fachBereichID, datum, stunde, raumID) VALUES
(1, 'LS3', 3, '2024-02-10', 2, 2),
(2, 'LF4', 2, '2024-02-11', 1, 1),
(3, 'LS5', 1, '2024-02-12', 3, 3),
(4, 'LK6', 4, '2024-02-13', 4, 4),
(5, 'LS7', 5, '2024-02-14', 5, 5);

-- Notenart
INSERT INTO Notenart (notenartBez) VALUES
('Referat'),
('Hausarbeit'),
('Projektarbeit'),
('Test'),
('Kurzarbeit');

-- Noten
INSERT INTO Noten (schuelerID, fachID, notenartID, zeitpunkt, note) VALUES
(3, 3, 1, '2024-01-25', 'A'),
(2, 2, 2, '2024-01-30', 'B+'),
(4, 4, 3, '2024-02-01', 'A-'),
(1, 1, 4, '2024-02-05', 'B'),
(5, 5, 5, '2024-02-10', 'C');
