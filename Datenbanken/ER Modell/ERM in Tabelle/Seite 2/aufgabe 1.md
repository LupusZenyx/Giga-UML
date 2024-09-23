# ER-Modell in Tabellenstruktur transformieren

## Aufgabe 1
### a)

Hersteller (**<u>HerstellerName</u>**, HerstellerStraße, HerstellerPLZ, HerstellerOrtsname)

Reifen (**<u>Markenbezeichnung </u>**, Reifenbreite, Höhen-Breiten-Verhältnis, Reifenbauart, Felgendurchmesser, Geschwindigkeitsindex, schlauchlos/nicht schlauchlos)

Großhändler (**<u>GroßhändlerName</u>**, GroßhändlerStraße, GroßhändlerPLZ, GroßhändlerOrtsname, GroßhändlerTelefonnummer, GroßhändlerFaxnummer, Ansprechpartner, **Reifenpreis**)

Kunden (**<u>Kundenname</u>**, KundenStraße, KundenPLZ, KundenOrtsname; KundenRabatt)

Verkauf (**<u>VerkaufsID</u>**, Verkaufsdatum, **Kundenname**, **Reifenmarkenbezeichnung**, **Großhändlername**, Verkaufsmenge, Verkaufspreis)

#### Hersteller
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| HerstellerName | String | PK |---------------|
| HerstellerStraße | String |--------------|---------------|
| HerstellerPLZ | int |--------------|---------------|
| HerstellerOrtsname | String |--------------|---------------|

#### Reifen
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| Markenbezeichnung | String | PK |---------------|
| Reifenbreite | int |--------------|---------------|
| Höhen-Breiten-Verhältnis | int |--------------|---------------|
| Reifenbauart | String |--------------|---------------|
| Felgendurchmesser | int |--------------|---------------|
| Geschwindigkeitsindex | String |--------------|---------------|
| schlauchlos/nicht schlauchlos | String |--------------|---------------|

#### Großhändler
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| GroßhändlerName | String | PK |---------------|
| GroßhändlerStraße | String |--------------|---------------|
| GroßhändlerPLZ | int |--------------|---------------|
| GroßhändlerOrtsname | String |--------------|---------------|
| GroßhändlerTelefonnummer | String |--------------|---------------|
| GroßhändlerFaxnummer | String |--------------|---------------|
| Ansprechpartner | String |--------------|---------------|
| Reifenpreis | int | FK | Reifen |

#### Kunden
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| Kundenname | String | PK |---------------|
| KundenStraße | String |--------------|---------------|
| KundenPLZ | int |--------------|---------------|
| KundenOrtsname | String |--------------|---------------|
| KundenRabatt | int |--------------|---------------|

#### Verkauf
| Attribut | Datentyp | Schlüsseltyp | Bezugstabelle |
|:----------|:----------:|:--------------:|:---------------:|
| VerkaufsID | int | PK |---------------|
| Verkaufsdatum | Date |--------------|---------------|
| Kundenname | String | FK | Kunden |
| Reifenmarkenbezeichnung | String | FK | Reifen |
| Großhändlername | String | FK | Großhändler |
| Verkaufsmenge | int |--------------|---------------|
| Verkaufspreis | int |--------------|---------------|

### b)
