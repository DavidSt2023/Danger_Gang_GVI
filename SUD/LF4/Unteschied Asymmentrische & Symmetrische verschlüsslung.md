Bei einer **symmetrischen** Verschlüsslung gibt es eigentlich nur private key ergo muss ich wenn ich mit 20 leuten kommuzier mit der verschlüsslung 20 private keys haben von jeden einem 
einmal um zu verschlüsseln der nachricht die ich zu der person mit dem schlüssel schicke und zum entschlüsseln der nachricht die ich von der person mit dem schlüssel bekommen habe.

Bei einer **Asymmetrischen** Verschlüsslung gibt es einemal ein Öffentlichen key (der z.B. auf einer website oder visitenkarte stehen kann) und einen Privaten key der nur der besitzer der
Öfftenlichen keys besitzt ergo hatt nur z.B Tom den Privaten schlüssel um die nachricht zu entschlüsseln und Till den öffentschlichen schlüssel um seine nachricht zu verschlüsseln
wenn Tom jetzt eine nachricht zurück senden will muss er den öffentlichen schlüssel von Til benutzten um es zuverschlüsseln damit Tom seine nachricht lesen kann

in einer **hybrid** verschküsslung wird der symmetrische schlüssel in einer asymmertischen email veschickt und ist darduch sicher verpackt dann kann mann den symmertischen schlüssel 
benutzten und ist nicht mehr so unsicher wie wenn der symmetrische schlüssel und verschlüssel veschickt wird 

**Transport vetrschlüsslung TLS** ist eine unsichere form mail zum mail server zu schicken da es nur veschlüsselt wird bis ein email server erreicht wurden und nicht bis der ziel server
ereicht wurde deswegen benutzt man besser deine end zu end verschlüsslung (OpenPGP oder S/MMIE) bei vertraulichen daten.S/MMIE hatt den vorteil das die key zum verschlüsseln von einer zertifkate stelle erstellt werden was sicher ist aber daruch auch kosten machen .