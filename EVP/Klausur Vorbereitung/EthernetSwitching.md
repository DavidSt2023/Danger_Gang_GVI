# 🧠 Lernzettel: Ethernet-Switching

---

## 📡 1. Funktionsweise Ethernet

- Ethernet ist eine Netzwerktechnologie zur Datenübertragung in lokalen Netzwerken (LAN).
- Arbeitet auf:
  - **OSI-Schicht 1 (Bitübertragungsschicht)**
  - **OSI-Schicht 2 (Sicherungsschicht)**
- Daten werden in **Frames** übertragen:
  - Enthalten Ziel-/Quell-MAC-Adresse, Nutzdaten und Prüfsumme (CRC).
- Übliche Topologie: **Stern** (Geräte an Switch angeschlossen).
- Ethernet ist broadcast-basiert: unbekannte Zieladressen → Sendung an alle.

---

## 🔢 2. Aufbau MAC-Adressen (Media Access Control)

- MAC = Hardware-Adresse eines Netzwerkgeräts (Layer 2).
- Länge: **48 Bit (6 Byte)**, hexadezimal dargestellt:
  - Beispiel: `00:1A:2B:3C:4D:5E`
- Aufbau:
  - **Erste 24 Bit**: Herstellerkennung (OUI)
  - **Letzte 24 Bit**: Gerätenummer
- MAC-Adressen sind **weltweit eindeutig**.

---

## 🔌 3. Funktionsweise Switch

- Switch arbeitet auf **OSI-Schicht 2**.
- Erkennt und speichert MAC-Adressen mit zugehörigem Port (MAC-Tabelle).
- Weiterleitung eines Frames:
  1. Quell-MAC wird gelernt.
  2. Ziel-MAC wird nachgeschlagen:
     - **Bekannt** → gezielte Weiterleitung.
     - **Unbekannt** → Broadcast an alle Ports.
- Vorteil gegenüber Hub: **intelligente Weiterleitung**, reduziert Datenverkehr.

---

## 🔁 4. Zusammenspiel von MAC- und IP-Adressen

| Ebene         | Adresse            | Beispiel              | Funktion                                    |
|---------------|--------------------|------------------------|---------------------------------------------|
| OSI-Schicht 2 | MAC-Adresse        | `00:1A:2B:3C:4D:5E`    | Lokale Identifikation im **LAN und WLAN**   |
| OSI-Schicht 3 | IP-Adresse         | `192.168.1.5`          | Logische Adressierung im Netzwerk (z. B. WAN) |

### Ablauf:
1. Kommunikation beginnt mit IP-Adresse (Ziel z. B. `192.168.1.5`).
2. Zur Zustellung im lokalen Netz wird die **MAC-Adresse benötigt**.
3. Falls nicht bekannt, erfolgt **ARP-Anfrage**:
   - "Wer hat IP 192.168.1.5?" → Zielgerät antwortet mit MAC.
4. Danach: gezielte Weiterleitung durch den Switch.

### Hinweis:
- Auch **WLAN** nutzt MAC-Adressen – WLAN-Adapter haben eigene MACs.
- Betriebssysteme können **zufällige MAC-Adressen (Privacy MACs)** verwenden.

---

## ✅ Zusammenfassung

- Ethernet nutzt MAC-Adressen für die lokale Zustellung.
- Switches lernen MAC-Adressen und leiten gezielt weiter.
- IP-Adressen regeln die logische Adressierung, MAC-Adressen die physische.
- ARP verknüpft IP- und MAC-Adressen.
- MAC-Adressen sind zentral für **LAN und WLAN**.

---
