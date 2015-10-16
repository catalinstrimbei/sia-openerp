# Modulul CONTABGEN #

[![](http://code.google.com/p/sia-openerp/source/browse/trunk/OpenERP/OpenERP_CONTABGEN/src/accountant.jpg)](http://code.google.com/p/sia-openerp/)

### Introducere ###

**Obiectiv:** Inregistrarea in contabilitate a notelor contabile aferente documentelor contabilizabile si a pune la dispozitie informatii sintetizate.

> Functionalitati:
    * definirea unui plan de conturi si a sabloanelor de inregistrare pentru documentele contabilizabile frecvent utilizate;
    * inregistrarea articolelor contabile aferente documentelor contabilizabile;
    * realizarea de calcule de sinteza pentru perioadele contabile;
    * oferirea de informatii necesare celorlalte module sau pentru raportare.

### Detalii ###

> #### I. Detalii functionale: ####
    * _Asigura urmatoarele metode de jurnalizare si transfer informatii:_
      1. **Creaza planul de conturi** utilizat in tratarea cheltuielilor si a clasificarii materialelor gestionate
      1. **Creaza sabloane contabile** specifice operatiilor de jurnalizare frecvente
      1. **Contabilizarea vanzarilor** in registru jurnal pentru tranzactiile de la vanzari(factura)
      1. **Contabilizarea achizitiilor** in registru jurnal pentru tranzactiile de la achizitii(factura)
      1. **Contabilizarea incasarilor**  in registru jurnal pentru tranzactiile de la incasari(casa, banca,cec,bo)
      1. **Contabilizarea platilor**  in registru jurnal pentru tranzactiile de la plati(casa, banca)
      1. **Contabilizarea salariilor**  in registru jurnal pentru salarii(stat de salarii)
      1. **Contabilizarea consumurilor** in registru jurnal pentru tranzactiile de consum(bon de consum)
      1. **Contabilizarea productiei obrinute** in registru jurnal pentru tranzactiile de productie obtinuta(note de productie)
      1. **Contabilizarea notelor diverse**
      1. **Jurnalizarea si inchiderea TVA**
      1. **Inchiderea lunilor contabile** prin calcularea soldurilor balantei de verificare
      1. **Extragerea de fise de cont** pentru parteneri sau pentru conturi contabile
    * _Pentru functionarea celorlate module pune la dispozitie:_
      1. **Planul de conturi**(pentru asignarea la plati si incasari diverse)
      1. **Tipurile Contabile** de utilizat la definirea materialor(din liniile Documentelor)
      1. **Metoda de verificare a statusului lunii** in care se introduce un document(INCHISA/DESCHISA)

> #### II. Detalii tehnice ####
  * _Dependente:_
> > - Modulul CONTABGEN depinde de modulele:

| **Nr** | **Modul** | **Entitati utilizate** |
|:-------|:----------|:-----------------------|
| 1      | <a href='http://code.google.com/p/sia-openerp/wiki/NOMGEN'> NOMGEN </a>  | Material, Document, LiniiDocument |

  * _Entitati locale:_
| **Nr** | **Denumire entitate** | **Registru aferent** |
|:-------|:----------------------|:---------------------|
| 1      | Cont                  |          RegConturi  |
| 2      | TipContabil           | RegTipuriContabile   |
| 3      | SablonNC              | RegSablonNC          |
| 4      | ArticolCtb            |                      |
| 5      | InregistrareRJ        |RegInregistrareRJ     |
| 6      | LunaLucru             | RegLuniLucru         |
| 7      | Balanta               | RegBalante           |
| 8      | FisaCont              |                      |
| 9      | Tipincasare           |                      |
| 10     | TipPlata              |                      |
| 11     | LinieMaterialValoare  |                      |
| 12     | StareDocument         |                      |

  * _Operatiuni/Actiuni:_
| **Metode/Procese** | **Observatii**  |
|:-------------------|:----------------|
| CrearePlanContabil() | -adauga conturile, sau un nou cont |
| CreareLunaLucru()  | -creaza sau deschide o luna de lucru noua |
| CreareSablonNC()   | -creaza sabloane cu note contabile pentru documentele utilizate frecvent |
| JurnalizareVanzare() | -jurnalizeaza notele contabile aferente unei vanzari si scaderea din gestiune daca e cazul |
| JurnalizareAchizitie() | -jurnalizeaza notele contabile aferente unei achizitii si intrarea in gestiune daca e cazul |
| JurnalizareIncasare() | -jurnalizeaza notele contabile aferente unei incasari prin casa sau banca |
| JurnalizarePlata() | -jurnalizeaza notele contabile aferente unei plati prin casa sau banca |
| JurnalizareConsum() | -jurnalizeaza notele contabile aferente unui Bon de Consum |
| JurnalizareProductie() | -jurnalizeaza notele contabile aferente unei Note de Productie |
| JurnalizareSalarii() | -jurnalizeaza notele contabile aferente unui Stat de plata |
| JurnalizareDiversa() | -jurnalizeaza notele contabile diverse fara utilizarea de sabloane |
| getRegConturi()    | -returneaza lista cu conturile disponibile |
| getRegLuniLucru()  | -returneaza lista cu lunile contabile create |
| getTipuriContabile() | -returneaza o lista cu `<string>`urile aferente tipurilor contabile create |
| inchideLuna()      | -inchide o luna contabila apeland procesul de calculare a soldurilor din balanta, si schimbare status |
| anuleazaInchidere() | -schimba statusul luniide lucru in DESCHIS, permitand noi inregistrari contabile  |
| creazaFisaCont()   | -returneaza o fisa de tranzactii pentru un cont solicitat |
| verificaLunaInchisa | -verifica daca luna aferenta unei date parametru este DESCHISA inregistrarii |
| getContDisponibil  | - verifica daca un cont este tranzactional (adica nu este parinte pentru alte conturi) |
| SolduriBalanta()   | -Proces care calculeaza soldurile lunare ale unei balante conform inregistrarilor din registru jurnal|
| JurnalizareTVA()   | -Proces care jurnalizaeaza conturile de TVA dedus si colectat si inchide cu nota contabila |