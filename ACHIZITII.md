<h2> INTRODUCERE </h2>
Functionalitate MODUL ACHIZITII:
<ul>
<blockquote><li> Evidenta  furnizori </li>
<li> Inregistrarea cererilor de aprovizionare </li>
<li> Crearea si gestiune plan de aprovizionare </li>
<li> Crearea si evidenta cererilor de oferta </li>
<li> Inregistrarea ofertelor de achizitie </li>
<li> Analiza ofertei de achizitie pentru a stabili comanda </li>
<li> Crearea comenzii </li>
<li> Crearea si evidenta NIR-uri </li>
<li> Inregistrarea facturii </li>
<li> Evidenta facturilor de retur </li>
<li> Inregistrare receptie materiale </li>
<li> Inregistrare retur materiale </li></blockquote>

<h2> DETALII </h2>
<br>
<br>
<UL><br>
<br>
<br>
<li>
<h3>Descriere functionala - Use Case  </h3></li>

Unknown end tag for </ul>

<br>
<br>
Aplicatia are urmatoarele cazuri de utilizare: <br><br>
<b>Gestiune PLAN DE APROVIZIONARE</b><br>Planul de aprovizionare se creeaza pentru fiecare saptamana din an.<br>Planul de aprovizionare se creeaza prin inregistrarea fiecarei linii din CEREREA DE APROVIZIONARE.<br>In cazul in care in liniile planului exista produsul din cerere se actualizeaza cantitatea, daca nu exista se adauga o noua linie in planul de aprovizionare.<br>Pentru fiecare linie din planul de aprovizionare se va seta un status pentru a observa daca s-a facut comanda pentru acel produs sau nu.<br><br>
<b>Evidenta CERERE DE OFERTA</b><br>Fiecare linie din planul de aprovizionare devine o cerere de oferta ce va fi trimisa furnizorilor<br><br>
<b>Evidenta OFERTA DE ACHIZITIE</b><br>Fiecare oferta va avea mai multe linii, fiecare linie fiind corespunzatoare articolului pentru care furnizorul a facut oferta<br><br>
<b>Analiza oferte de achizitie</b><br>Pentru a se stabili care din ofertele primite se va transforma in comanda catre furnizor se analizeaza ofertele primite per articol pe baza criteriilor pret si timp de livrare.<br><br>
<b>Gestiune COMENZI </b><br>Pe baza analizei ofertelor de achizitie se va creea o comanda.<br>Comanda se realizeaza si pe baza liniilor din planul de aprovionare(comenzi periodice de la furnizor prestabiliti).<br><br>
<b>Evidenta FACTURI </b><br>Se inregistreaza in contabilitate factura primita de la furnizor.<br><br>
<b>Receptia comenzii</b><br>Pe baza facturii se realizeaza nota de intrare receptie.<br>Daca factura este in concordanta cu comanda articolele intra in stoc.<br>Daca articolele primite nu sunt conforme comenzii se inregistreaza in contabilitate factura de retur si se realizeaza iesire din stoc a articolelor.<br>


<br>
<br>
<UL><br>
<br>
<br>
<li>
<h3>Descriere tehnica  </h3></li>

Unknown end tag for </ul>

<br>
<ol>
<li><b>Dependente </b>

Unknown end tag for </LI>

<br>
<blockquote>Modulul ACHIZITII depinde de urmatoarele module: <br><br><b>
 <a href='http://code.google.com/p/sia-openerp/wiki/NOMGEN'> Nomenclatoare generale </a> <br><br>
 <a href='http://code.google.com/p/sia-openerp/wiki/STOCURI'> Stocuri</a> <br><br>
 <a href='http://code.google.com/p/sia-openerp/wiki/CONTABGEN'> Contabilitate generala </a> <br><br>
<li><b>Business Objects Locale</b>

Unknown end tag for </LI>

<br>
</blockquote><blockquote>- Articol<br>
- Cerere Oferta <br>
- Comanda <br>
- Factura <br>
- Furnizor <br>
- Linie Cerere Oferta<br>
- Linie Comanda <br>
- Linie Factura Achizitie <br>
- Linie NIR <br>
- Linie Oferta Achizitie <br>
- Linie Plan Aprovizionare <br>
- NIR <br>
- Oferta Achizitie <br>
- Plan Aprovizionare <br>
<br>
<li><b>Operatiile/ Actiunile/ Application Service</b>

Unknown end tag for </LI>

