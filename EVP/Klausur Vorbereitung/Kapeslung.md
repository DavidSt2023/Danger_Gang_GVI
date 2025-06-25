
### 🧱 **Prinzip der Kapselung von IP**

**Kapselung** bedeutet, dass Daten in mehreren Schichten verpackt werden:

* Die Anwendung erstellt Daten.
* Diese werden vom **Transportprotokoll** (z. B. TCP oder UDP) mit Headern versehen.
* Danach kommt das **IP-Protokoll**, das nochmal Infos wie Absender- und Ziel-IP-Adresse hinzufügt.
* Schließlich kommen noch MAC-Adressen auf der **Sicherungsschicht (Layer 2)** dazu.

Das Ganze nennt man „Kapselung“, weil jede Schicht die Daten der vorherigen Schicht „einpackt“.

---

### 🔒 **Drei Merkmale des IP-Protokolls**

1. **Verbindungslos:** Es wird keine feste Verbindung zwischen Sender und Empfänger aufgebaut.
2. **Medienunabhängig:** Der Betrieb ist unabhängig vom Medium (d.h. Kupfer, Glasfaser oder Wireless), das die Daten überträgt.
3. **Best-Effort:** Es wird versucht, das Paket zuzustellen, aber ohne Garantie.

---

### 📦 **Wie wird sichergestellt, dass Pakete nicht verloren gehen?**

**IP selbst tut das nicht!**
Das **Transmission Control Protocol (TCP)** kümmert sich darum:

* Es nummeriert Pakete.
* Es fordert fehlende Pakete erneut an (ACK/NACK).
* Es stellt die richtige Reihenfolge wieder her.

UDP dagegen macht das **nicht**, ist also schneller, aber unzuverlässig (z. B. bei Livestreams).

---

### 📡 **Was machen IP-Protokolle?**

* Zerlegen Daten in kleine Pakete.
* Fügen Absender- und Empfänger-IP hinzu.
* Finden den besten Weg zum Ziel.
* Geben Pakete an die nächste Station weiter (Routing).

---

### 🔢 **Unterschied IPv4 vs. IPv6 Header**

| Merkmal           | IPv4                        | IPv6                         |
| ----------------- | --------------------------- | ---------------------------- |
| Adresslänge       | 32 Bit (z. B. 192.168.0.1)  | 128 Bit (z. B. 2001\:db8::1) |
| Headergröße       | Variabel (20–60 Bytes)      | Fix (40 Bytes)               |
| Felder            | Mehr Felder, z. B. Checksum | Weniger, effizienter         |
| NAT-Unterstützung | Ja                          | Eigentlich nicht nötig       |
| QoS-Unterstützung | Eingeschränkt               | Besser integriert            |

---

### 🧭 **Weshalb muss ein Host routen?**

Ein Host muss entscheiden:

* Ist das Ziel im gleichen Netzwerk?
  → Dann geht das Paket direkt per MAC-Adresse an das Ziel.
* Ist das Ziel außerhalb?
  → Dann muss das Paket an das **Default Gateway** (meist der Router).

---

### 🗺️ **Wie routet ein Host?**

* Er schaut in seine **Routing-Tabelle**.
* Findet das passende Zielnetz (z. B. 192.168.1.0/24).
* Leitet das Paket zur passenden Schnittstelle oder zum Gateway.

---

### 📋 **Wie ist eine Routing-Tabelle aufgebaut und wie funktioniert sie?**

Routing-Tabelle besteht aus Einträgen wie:

| Zielnetz          | Netzmaske     | Gateway     | Schnittstelle | Metrik |
| ----------------- | ------------- | ----------- | ------------- | ------ |
| 192.168.1.0       | 255.255.255.0 | –           | eth0          | 0      |
| 0.0.0.0 (Default) | 0.0.0.0       | 192.168.1.1 | eth0          | 1      |

**Funktion:**

* Das Ziel-IP wird mit Einträgen in der Tabelle verglichen (Longest Prefix Match).
* Das passendste Netz wird ausgewählt.
* Das Paket wird an die dazugehörige Schnittstelle oder Gateway gesendet.

---

### 🔁 **Wie trifft ein Router Routing-Entscheidungen?**

* Der Router schaut auf die Ziel-IP des Pakets.
* Vergleicht mit seiner Routing-Tabelle.
* Wählt den Eintrag mit der längsten passenden Netzmaske.
* Leitet das Paket entsprechend weiter.

---

### 🔄 **Statisches vs. Dynamisches Routing**

**Statisches Routing:**

* Von Admin manuell eingerichtet.
* Vorteil: Kontrolle.
* Nachteil: Keine Anpassung bei Ausfall.

**Dynamisches Routing:**

* Router lernen selbstständig Netzwerke kennen.
* Über Routing-Protokolle wie **RIP, OSPF, BGP**.
* Vorteil: Anpassung bei Änderungen.
* Nachteil: Komplexität, mehr Traffic durch Routing-Infos.

---

### 🧪 **Routing-Tabelle eines Routers anzeigen (Linux Beispiel)**

```bash
ip route
```

Beispielausgabe:

```
default via 192.168.1.1 dev eth0
192.168.1.0/24 dev eth0 proto kernel scope link src 192.168.1.100
10.10.10.0/24 via 192.168.1.254 dev eth1
```

**Interpretation:**

* Pakete ins Internet (default) gehen über 192.168.1.1.
* 192.168.1.0/24 ist direkt über eth0 erreichbar.
* 10.10.10.0/24 geht über ein anderes Gateway (192.168.1.254).

---

Wenn du willst, kann ich dir eine kleine Übung oder ein Beispielnetzwerk basteln – oder dir helfen, Routing live zu üben auf Linux oder mit Packet Tracer. Sag einfach Bescheid!
