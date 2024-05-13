CREATE USER IF NOT EXISTS 'dev'@'localhost'
IDENTIFIED BY 'dev';

CREATE USER IF NOT EXISTS 'maintainer'@'localhost'
    IDENTIFIED BY 'maintainer';
GRANT CREATE ON dbotto TO 'maintainer'@'localhost';
FLUSH PRIVILEGES;

CREATE USER IF NOT EXISTS 'observer'@'localhost'
    IDENTIFIED BY 'observer';
GRANT SELECT ON dbotto.liefangebot TO 'observer'@'localhost';
GRANT SELECT ON dbotto.liefbestellung TO 'observer'@'localhost';
GRANT SELECT ON dbotto.lieferant TO 'observer'@'localhost';
FLUSH PRIVILEGES;

CREATE USER IF NOT EXISTS 'worker'@'localhost'
    IDENTIFIED BY 'worker';
GRANT INSERT ON dbotto.kdauftrag TO 'worker'@'localhost';
GRANT INSERT ON dbotto.kdauftragsposition TO 'worker'@'localhost';
FLUSH PRIVILEGES;

-- Create 3 Roles
CREATE ROLE 'admin','sekretariat','nutzer';

-- Add priviledges to admin
GRANT ALL ON dbotto.* TO admin;
FLUSH PRIVILEGES;

-- Add priviledges to sekretariat
GRANT SELECT ON dbotto.* TO sekretariat;
GRANT INSERT ON dbotto.* TO sekretariat;
GRANT DELETE ON dbotto.* TO sekretariat;
FLUSH PRIVILEGES;

-- Add priviledges to nutzer
GRANT SELECT ON dbotto.artikel TO nutzer;
GRANT UPDATE ON dbotto.artikel TO nutzer;
FLUSH PRIVILEGES;

GRANT 'admin' TO 'dev'@'localhost';
GRANT 'nutzer' TO 'worker'@'localhost';
GRANT 'sekretariat' TO 'maintainer'@'localhost';
FLUSH PRIVILEGES;
