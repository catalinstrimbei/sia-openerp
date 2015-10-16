Modul OpenERP\_PERSONAL

# Introducere #

Se ocupa cu gestionarea Resurselor Umane.


# Detalii #

> ## Descriere functionala ##

## Modulul cuprinde urmatoarele procese: ##
### 1. Procesul de recrutare ce include: ###
  * alcatuirea anunturilor pentru locurile de munca;
  * organizarea interviurilor;
  * selectia candidatilor pentru angajare.

### 2. Procesul de angajare ###
  * presupune atribuirea unei marci unui candidat selectat pentru angajare, crearea dosarului si a contractului de munca pentru acesta;
  * angajatul este activ dupa completarea dosarului de angajare.

### 3. Procesul de demitere ###
  * incheierea activitatii, poate fi prin:
    * _demisie_ - se inregistreaza cererea de demisie depusa de angajat si se urmareste statusul cerererii pana la finalizare.
    * _concediere_ - se modifica datele contractului de munca pentru un angajat: data terminarii cu data curenta a realizarii actiunii, motivul de incheiere.
### 4. Procesul de relocalizare ###
  * relocalizarea unui angajat ca urmare a resturcturarii firmei sau ca urmare a promovarii angajatului si are ca rezultat contractul nou incheiat sau contractul modificat in urma promovarii.
### 5. Procesul de evaluare anuala a angajatilor ###
  * se inregistreaza probele de avaluare pe departamente si se pot obtine rezultatele pe fiecare departament / proba / angajati
### 6. Procesul de organizare a evenimentelor din cadrul companiei. ###
  * se inregistreaza evenimentele spre aprobare; statusul documentelor se modifica cand acestea sunt aprobate, tinandu-se cont de bugetul alocat.


> ## Descriere tehnica ##

## 1. Dependente ##

Modulul PERSONAL depinde de urmatorul modul:

- [NOMGEN](NOMGEN.md)

de unde utilizeaza entitatile:

- Persoana Fizica, Departament


## 2. Entitati Locale ##

- Activitate
- Angajat
- AnuntLocMunca
- Candidat
- CerereDemisie
- ContractMunca
- CV
- DosarAngajat
- Eveniment
- Functie
- InstructorTraining
- Interviu
- ProbaEvaluare