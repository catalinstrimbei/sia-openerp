# Introduction #

Modul FININCASARI


# Details #

### Introducere ###

**Obiectiv:** Implementeaza procesul de incasare inregistrand platile efectuate

**Functionalitati:**
  * Gestioneaza incasarea sumelor in numerar
  * Gestioneaza incasarea Facturilor emise in urma vanzarii, inclusiv incasarea partiala a acestora
  * Gestioneaza incasarea cecurilor si a biletelor la ordin
  * Gestioneaza incasarile in lei si in valuta
  * Actualizeaza Sold client si sold Cont bancar
  * Inregistrarea platilor efectuate de clienti.

### Detalii ###

  * Detalii functionale

Asigura urmatoarele metode de jurnalizare si transfer informatii

  * Jurnalizeaza notele contabile aferente efectuarii unei plati
  * Jurnalizeaza depunerea unui cec sau a unui bilet la ordin
  * Calculeaza suma in funtie de moneda in care se efectueaza plata
  * Calculeaza diferenta dintre suma totala a facturii si suma incasata
  * Se efectueaza inregistrarea platii in contabilitate pe baza chitantei, a unui cec sau a unui bilet la ordin
  * Se verifica daca starea cecului sau a biletului la ordin este "refuzat"
  * Se efectueaza inregistrarea platii in contabilitate pe baza unui extras de cont.

  * Detalii tehnice*** _Dependente:_
- Modulul FININCASARI depinde de modulele:**

| **Nr** | **Modul** | **Entitati utilizate** |
|:-------|:----------|:-----------------------|
| 1      | VANZARI   |FacturaEmisa, Client    |
| 2      | PERSONAL  | Angajat                |
| 3      | NOMGEN    | PersoanaFizica         |

  * _Entitati locale:_
| **Nr** | **Denumire entitate** |
|:-------|:----------------------|
| 1      | BiletLaOrdin          |
| 2      | Cec                   |
| 3      | Chitanta              |
| 4      | ExtrasCont            |
| 5      | Incasare              |
| 6      | StareDocument         |
| 7      | TipIncasare           |

**_Operatiuni/Actiuni:_**| **Metode/Procese** | **Observatii**  |
|:-------------------|:----------------|

| confirmareIncasare()| Jurnalizeaza notele contabile aferente efectuarii unei plati; |
|:--------------------|:--------------------------------------------------------------|
| confirmareDepundereLaBanca() |	Jurnalizeaza depunerea unui cec sau a unui bilet la ordin;    |
| getSumaRon()	       | Calculeaza suma in funtie de moneda in care se efectueaza plata; |
| restIncasareFactura() | Calculeaza diferenta dintre suma totala a facturii si suma incasata; |
| inregistrareChitanta() | Se efectueaza inregistrarea platii in contabilitate pe baza chitantei, a unui cec sau a unui bilet la ordin; Se specifica, ca suma incasata sa nu fie nula, apoi se instantiaza o noua chitanta pe baza unei sau a mai multor facturi |
| inregistrareCec()   |	Se verifica daca starea cecului sau a biletului la ordin este “refuzat”; |
| inregistrareBiletLaOrdin() | Se efectueaza inregistrarea platii in contabilitate pe baza unui bilet la ordin. Se specifica, ca suma incasata sa nu fie nula, apoi se instantiaza o noua inregistrare in baza de date |
| confirmareImposibilitatePlata() |  Se constata imposibilitatea de plata a clientului, daca starea cec-ului sau biletului la ordin este "refuzat" |
| inregistrareExtrasCont() | Se efectueaza inregistrarea platii in contabilitate pe baza unui extras de cont; |
| compensariIncasariFacturi() |  Verifica achitarea facturilor in ordine cronologica          |
|jurnalizareIncasareNoua() | Se efectueaza jurnalizarea unei noi incasari                  |
| jurnalizareIncasareModificata() |  Se inregistreaza modifcarea unei incasari                    |
| jurnalizareIncasare() |  Se jurnalizeaza o incasare                                   |
| salveazaCec()       | Se salveaza inregistrarea unui Cec                            |
| salveazaIncasare()  | Se salveaza o inregistrare                                    |
| salveazaBiletLaOrdin() | Se salveaza inregistrarea unui bilet la ordin                 |
| salveazaClient()    |  Se salveaza inregistrarea unui client                        |
| salveazaFactura()   |  Se salveaza inregistrarea unei facturi                       |
| salveazaChitanta()	 |  Se salveaza inregistrarea unei chitante                      |
| StergeIncasare()    |  Are loc stergerea unei incasari                              |
| getIncasari()       | Se interogheaza lista incasarilor                             |
| getClient()	        | Se interogheaza lista clientilor                              |
| getFacturiDupaClient() | Se interogheaza lista facturilor in functie de client         |
| getFacturaDupaId()  | Se interogheaza lista facturilor in functie de id             |
| getClientDupaId()   | Se interogheaza lista clientilor in functie de id             |
| getChitante()       | Se interogheaza lista chitantelor                             |