# ER-Modell in Tabellenstruktur transformieren
## Aufgabe 1
### a) 
Tabellen:

- Abteilung (AbteilungsID, Bezeichnung)
- Mitarbeiter (MitarbeiterID, Vorname, Nachname, Wohnort, Strasse, AbteilungsID, ArbeitsvertragsID)
- Arbeitsvertrag (ArbeitsvertragsID, Funktion, Gehalt)
- Projekt (ProjektID, Name)
- Projektmitarbeit (MitarbeiterID, ProjektID, Stunden)

Primärschlüssel:

- AbteilungsID in Abteilung
- MitarbeiterID in Mitarbeiter
- ArbeitsvertragsID in Arbeitsvertrag
- ProjektID in Projekt

Fremdschlüssel:

- AbteilungsID in Mitarbeiter
- ArbeitsvertragsID in Mitarbeiter
- MitarbeiterID in Projektmitarbeit
- ProjektID in Projektmitarbeit

#### Schreibweise
- Abteilung (<u>**AbteilungsID**</u>, Bezeichnung)
- Mitarbeiter (<u>**MitarbeiterID**</u>, Vorname, Nachname, Wohnort, Strasse, **AbteilungsID#**, **ArbeitsvertragsID#**)
- Arbeitsvertrag (<u>**ArbeitsvertragsID**</u>, Funktion, Gehalt)
- Projekt (<u>**ProjektID**</u>, Name)
- Projektmitarbeit (**MitarbeiterID#**, **ProjektID#**, Stunden)


### b)
#### Abteilung
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle | 
|:----------|:----------:|:--------------:|:---------------:|
| AbteilungsID | int | PK |---------------|
| Bezeichnung | String |--------------|---------------|

#### Mitarbeiter
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| MitarbeiterID | int | PK |---------------|
| Vorname | String |--------------|---------------|
| Nachname | String |--------------|---------------|
| Wohnort | String |--------------|---------------|
| Strasse | String |--------------|---------------|
| AbteilungsID | int | FK | Abteilung |
| ArbeitsvertragsID | int | FK | Arbeitsvertrag |

#### Arbeitsvertrag
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| ArbeitsvertragsID | int | PK |---------------|
| Funktion | String |--------------|---------------|
| Gehalt | int |--------------|---------------|

#### Projekt
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| ProjektID | int | PK |---------------|
| Name | String |--------------|---------------|

#### Projektmitarbeit
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| MitarbeiterID | int | FK | Mitarbeiter |
| ProjektID | int | FK | Projekt |
| Stunden | int |--------------|---------------|


