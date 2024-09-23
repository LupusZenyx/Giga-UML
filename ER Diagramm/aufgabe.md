# Vorlesungsdatenbank
## Aufgabe 1.1



### Beziehungen:
- Professor hat Assistent (1, N)
- Professor hält Vorlesung (1, N)
- Vorlesung findet statt in Hörsaal (N, 1)

## Aufgabe 1.2

- Professor (<u>PersonalID</u>, Name, Besoldungsgruppe, Gehaltszulage)
- Assistent (<u>PersonalID</u>, Name, Fachgebiet)
- Student (<u>MatrikelID</u>, Name, SemesterAnzahl)
- Vorlesung (<u>VorlesungsID</u>, Thema, Semesterwochenstunden, Professor#)
- Hörsaal (<u>HörsaalID</u>, Bezeichnung, Sitzplätze)
