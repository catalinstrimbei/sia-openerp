# Introducere #
<br />
Descrie functionalitatea modulului SALARIZARE din aplicatia SIA-OPENERP
<br />

# Detalii #
<br />
Principalele functionalitati ale modulului sunt;<br />

- inregistrare si generare automata/manuala pontaj<br />
- adaugare ore suplimentare/concediu
- calcul sporuri<br />
- calcul retineri angajat/angajator<br />
- calcul venit brut<br />
- calcul impozit angajat/angajator<br />
- generare stat plata<br />
- generare centralizatoare si sume pentru contabilitate


Use cases <br />

@ApplicationServiceFacade(ServiceAPI)
  * 
  * @Dependente: PersonalSrv, NomenclatoareSrv
  * 
  * @EntitatiNomenclatoare: Persoana, Departament
  * 
  * @EntitatiPersonalSrv: Angajat
  * 
  * @EntitatiLocale: Pontaj, Retinere, Spor, Configurare, StatSalarii, CentralizatorStatSalarii
  * 
> > @UseCase("inregistrare pontaj"):
  * 1. Creaza instanta pontaj
  * 2. Inregistrare pontaj pe angajat
  * 3. Returneata pontaj initializat pentru un angajat


> @UseCase("inregistrare pontaj la nivel de luna"):
  * 1. Creaza instanta pontaj pe fiecare angajat
  * 2. Incarcare angajati cu contract activ
  * 3. Inregistrare pontaj pe angajat pentru o anumita luna

> @UseCase("Adaugare ore suplimentare si de concediu"):
  * 1.Incarcare pontaj angajat
  * 2.Editare manuala a pontajului
  * 3.Adaugare ore suplimentare si de concediu

> @UseCase("Inregistrare stat salarii"):
  * 1.Incarcare lista pontaje
  * 2.Calcul sporuri
  * 3.Calcul venit brut
  * 3.Calcul retineri
  * 4.Calcul Deduceri
  * 5.Calcul Impozit
  * 6.Calcul Venit Net
  * 7.Generare stat plata

> @UseCase("Generare centralizator stat salarii")
  * 1.Incarcare calcule luna
  * 2.Agregare sume
  * 3.Generare totaluri pentru contabilitate