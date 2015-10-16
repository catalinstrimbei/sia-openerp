## Introducere ##


## Functionalitati: ##

  * Gestioneaza plata facturilor primite de la furnizori, inclusiv plata partiala a acestora
  * Gestioneaza plata cecurilor si a biletelor la ordin
  * Inregistreaza platile efectuate catre clienti
  * Gestioneaza platile in lei si in valuta
  * Actualizeaza sold furnizor si cont bancar

## Detalii functionale: ##

  * Jurnalizeaza notele contabile aferente efectuarii unei plati
  * Jurnalizeaza plata unui cec sau a unui bilet la ordin
  * Calculeaza suma de plata in funtie de moneda
  * Calculeaza diferenta dintre suma totala a facturii si suma platita
  * Se efectueaza inregistrarea platii in contabilitate pe baza chitantei, a unui cec sau a unui bilet la ordin
  * Se verifica daca starea cecului sau a biletului la ordin este acceptata
  * Se verifica inregistrarea platii in contabilitate pe baza extrasului de cont.

> ### **Module dependente:** ###

| **Nr** | **Modul** | **Entitati utilizate** |
|:-------|:----------|:-----------------------|
| 1      | ACHIZITII  |Factura                 |
| 2      | PERSONAL  | Angajat                |
| 3      | NOMGEN    | Partener               |
| 4      | CTBGEN    | StareDocument, TipPlata |

> ### **Entitati:** ###

| _Nr_ | _Denumire entitate_ |
|:-----|:--------------------|
| 1    | Cec                 |
| 2    | Chitanta            |
| 3    | ContBancaPF         |
| 4    | ContBancaPJ         |
| 5    | ExtrasCont          |
| 6    | OrdinPlata          |
| 7    | Plata               |

> ### **Metode implementate/Observatii:** ###


| confirmareDepunereLaBanca() | Jurnalizeaza plata unui cec sau a unui bilet la ordin; |
|:----------------------------|:-------------------------------------------------------|
| getSumaRon()	               | Calculeaza suma in funtie de moneda in care se efectueaza plata; |
| restPlataFactura()          | Calculeaza diferenta dintre suma totala a facturii si suma platita; |
| inregistrareChitanta()      | Se efectueaza inregistrarea platii in contabilitate pe baza chitantei, a unui cec sau a unui bilet la ordin; Se specifica, ca suma incasata sa nu fie nula, apoi se instantiaza o noua chitanta pe baza uneia sau a mai multor facturi |
| inregistrareCec()           |	Se verifica daca starea cecului sau a biletului la ordin este acceptata; |
| inregistrareOrdinDePlata()  | Se efectueaza inregistrarea platii in contabilitate pe baza unui ordin de plata |
| inregistrareExtrasCont()    | Se efectueaza inregistrarea platii in contabilitate pe baza unui extras de cont; |
| compensariPlatiFacturi()    |  Verifica achitarea facturilor in ordine cronologica   |
| salveazaCec()               | Se salveaza inregistrarea unui Cec                     |
| salveazaPlata()             | Se salveaza inregistrarea unei plati                   |
| salveazaBiletLaOrdin()      | Se salveaza inregistrarea unui bilet la ordin          |
| salveazaChitanta()	         |  Se salveaza inregistrarea unei chitante               |
| StergePlata()               |  Are loc stergerea unei plati                          |
| getPlati()                  | Se interogheaza lista platilor                         |
| getFurnizor()	              | Se interogheaza lista clientilor                       |
| getFacturiDupaFurnizor()    | Se interogheaza lista facturilor in functie de furnizor |
| getFacturaDupaId()          | Se interogheaza lista facturilor in functie de id      |