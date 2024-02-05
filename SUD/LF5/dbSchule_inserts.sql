-- Schueler
INSERT INTO Schueler (vorname, nachname, strasse, ort) VALUES
                                                           ('Max', 'Mustermann', 'Musterstraße 123', 'Musterstadt'),
                                                           ('Anna', 'Musterfrau', 'Beispielweg 456', 'Beispielstadt'),
                                                           ('Laura', 'Schulz', 'Schulweg 789', 'Schulstadt'),
                                                           ('Felix', 'Meier', 'Meierstraße 456', 'Meierstadt'),
                                                           ('Sophie', 'Wagner', 'Wagnerweg 123', 'Wagnerstadt'),
                                                           ('Tim', 'Becker', 'Beckerplatz 789', 'Beckerstadt'),
                                                           ('Lena', 'Hoffmann', 'Hoffmannallee 456', 'Hoffmannstadt'),
                                                           ('David', 'Mayer', 'Mayerweg 789', 'Mayerstadt');

-- Lehrer
INSERT INTO Lehrer (lehrerKuerzel, nachname, telefonNr, geburtsdatum, nationalitaet) VALUES
                                                                                         ('LM1', 'Lehrermann', '123-456789', '1980-05-15', 'deutsch'),
                                                                                         ('LK2', 'Lehrerfrau', '987-654321', '1975-11-20', 'deutsch'),
                                                                                         ('LS3', 'Schulze', '111-222333', '1985-08-25', 'deutsch'),
                                                                                         ('LF4', 'Fischer', '444-555666', '1978-04-12', 'deutsch'),
                                                                                         ('LS5', 'Schmidt', '777-888999', '1982-11-30', 'deutsch'),
                                                                                         ('LK6', 'Koch', '000-999888', '1970-07-15', 'deutsch'),
                                                                                         ('LS7', 'Schneider', '123-456789', '1987-03-05', 'deutsch'),
                                                                                         ('LL8', 'Lange', '111-222333', '1983-08-15', 'deutsch'),
                                                                                         ('LH9', 'Hahn', '444-555666', '1976-04-22', 'deutsch'),
                                                                                         ('LJ10', 'Jäger', '777-888999', '1981-10-28', 'deutsch'),
                                                                                         ('LK11', 'Kühn', '000-999888', '1969-06-10', 'deutsch'),
                                                                                         ('LR12', 'Richter', '123-456789', '1986-02-08', 'deutsch'),
                                                                                         ('LD13', 'Dietrich', '999-888777', '1973-07-25', 'deutsch'),
                                                                                         ('LF14', 'Fuchs', '888-777666', '1980-11-12', 'deutsch'),
                                                                                         ('LB15', 'Berg', '666-555444', '1975-05-18', 'deutsch');

-- Bildungsgang
INSERT INTO Bildungsgang (bildungsgangBez, leiterKuerzel) VALUES
                                                              ('Informatik', 'LM1'),
                                                              ('Biologie', 'LK2'),
                                                              ('Physik', 'LS3'),
                                                              ('Geschichte', 'LF4'),
                                                              ('Sport', 'LS5'),
                                                              ('Musik', 'LR12'),
                                                              ('Chemie', 'LL8'),
                                                              ('Mathematik', 'LB15');

-- Raumfunktion
INSERT INTO Raumfunktion (raumFunktion) VALUES
                                            ('Klassenraum'),
                                            ('Labor'),
                                            ('Bibliothek'),
                                            ('Sporthalle'),
                                            ('Computerlabor'),
                                            ('Seminarraum'),
                                            ('Cafeteria'),
                                            ('Physiklabor'),
                                            ('Schulhof'),
                                            ('Aula'),
                                            ('Chemiesaal'),
                                            ('Lehrerzimmer'),
                                            ('Technikraum');

-- Raum
INSERT INTO Raum (raumFunktion) VALUES
                                    (1),
                                    (2),
                                    (3),
                                    (4),
                                    (5),
                                    (6),
                                    (7),
                                    (8);

-- Fachbereich
INSERT INTO Fachbereich (fachBereich) VALUES
                                          ('Mathematik'),
                                          ('Chemie'),
                                          ('Physik'),
                                          ('Geschichte'),
                                          ('Biologie'),
                                          ('Musik'),
                                          ('Sport'),
                                          ('Informatik');

-- Fach
INSERT INTO Fach (fachBereichID) VALUES
                                     (1),
                                     (2),
                                     (3),
                                     (4),
                                     (5),
                                     (6),
                                     (7),
                                     (8);

-- Klasse
INSERT INTO Klasse (klassenLehrer, bildungsgangID) VALUES
                                                       ('LM1', 1),
                                                       ('LK2', 2),
                                                       ('LS3', 3),
                                                       ('LF4', 4),
                                                       ('LS5', 5),
                                                       ('LR12', 6),
                                                       ('LL8', 7),
                                                       ('LB15', 8);

-- Stundenplan
INSERT INTO Stundenplan (klassenID, lehrerID, fachBereichID, datum, stunde, raumID) VALUES
                                                                                        (1, 'LM1', 1, '2024-02-05', 1, 1),
                                                                                        (2, 'LK2', 2, '2024-02-06', 2, 2),
                                                                                        (3, 'LS3', 3, '2024-02-07', 3, 3),
                                                                                        (4, 'LF4', 4, '2024-02-08', 4, 4),
                                                                                        (5, 'LS5', 5, '2024-02-09', 5, 5),
                                                                                        (6, 'LR12', 6, '2024-02-10', 1, 6),
                                                                                        (7, 'LL8', 7, '2024-02-11', 2, 7),
                                                                                        (8, 'LB15', 8, '2024-02-12', 3, 8);

-- Notenart
INSERT INTO Notenart (notenartBez) VALUES
                                       ('Klausur'),
                                       ('Mündliche Prüfung'),
                                       ('Referat'),
                                       ('Hausarbeit'),
                                       ('Projektarbeit'),
                                       ('Test'),
                                       ('Kurzarbeit'),
                                       ('Präsentation'),
                                       ('Portfolio'),
                                       ('Gruppenarbeit'),
                                       ('Quiz'),
                                       ('Fachgespräch'),
                                       ('Projektergebnis'),
                                       ('Klassenarbeit'),
                                       ('Abschlussprüfung');

-- Noten
INSERT INTO Noten (schuelerID, fachID, notenartID, zeitpunkt, note) VALUES
                                                                        (1, 1, 1, '2024-01-15', 'A'),
                                                                        (2, 2, 2, '2024-01-20', 'B+'),
                                                                        (3, 3, 3, '2024-01-25', 'A+'),
                                                                        (4, 4, 4, '2024-02-01', 'A-'),
                                                                        (5, 5, 5, '2024-02-10', 'C'),
                                                                        (6, 6, 6, '2024-02-15', 'B'),
                                                                        (7, 7, 7, '2024-02-20', 'B+'),
                                                                        (8, 8, 8, '2024-02-25', 'A-'),
                                                                        (3, 3, 1, '2024-01-28', 'A+'),
                                                                        (4, 4, 2, '2024-02-02', 'B-'),
                                                                        (5, 5, 3, '2024-02-07', 'A'),
                                                                        (1, 1, 4, '2024-02-12', 'C+'),
                                                                        (2, 2, 5, '2024-02-17', 'B'),
                                                                        (3, 3, 6, '2024-02-22', 'A-'),
                                                                        (4, 4, 7, '2024-02-27', 'B+'),
                                                                        (5, 5, 8, '2024-03-03', 'A');
