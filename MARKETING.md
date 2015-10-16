# Introducere #

Aceasta pagina contine informatiile necesare unei utilizator care doreste sa intrebuinteze intr-un mod cat mai adecvat modulul de MARKETING ca parte a acestei aplicatii.

> Modulul de MARKETING ofera urmatoarele facilitati:
  1. Crearea si gestionarea cercetarilor de piata;
  1. Crearea si distribuirea de chestionare, precum si procesarea raspunsurilor obtinute in urma completarii acestora;
  1. Crearea si administrarea campaniilor de promovare prin canalele de distributie corespunzatoare;
  1. Stabilirea promotiilor;
  1. Primirea de reclamatii de la clienti, precum si rezolvarea acestora in timp util.


<h3>Descrierea detaliata a modulului MARKETING </h3>

Modulul de MARKETING permite derularea urmatoarelor operatiuni: <br><br>
<b>DEFINIREA UNEI CERCETARI DE PIATA</b><br>
Informatiile necesare pentru definirea unei cercetari de piata sunt:<br>
<ul><li>Numarul cercetarii de piata;<br>
</li><li>Data de start si data de final;<br>
</li><li>Responsabilul cercetarii de piata;<br>
</li><li>Bugetul aferent;<br>
</li><li>Lista intrebarilor.</li></ul>

Dependentele:<br>
<ul><li>PersonalSRV - avem nevoie de o instanta a clasei Angajat pentru a stabili un responsabil al cercetarii de piata.<br>
<br>
<b> INITIEREA UNEI CERCETARI DE PIATA.</b><br>
In aceasta etapa, responsabilul campaniei aloca un buget cercetarii de piata pe care o are in vedere in perioada urmatoare. De asemenea, se va aloca un chestionar corespunzator.</li></ul>

<br>
<b>DEFINIREA UNUI CHESTIONAR</b><br>
Chestionarele sunt folosite pentru obtinerea unui feedback din partea clientilor sau pentru efectuarea unui studiu de piata pentru un produs ce urmeaza a fi lansat. Acestea pot contine mai multe tipuri de intrebari. Pentru definirea unui chestionar, avem nevoie de urmatoarele informatii:<br>
<ul><li>Denumirea chestionarului;<br>
</li><li>Responsabilul chestionarului;<br>
</li><li>Numarul de intrebari;<br>
</li><li>Persoana chestionata;<br>
</li><li>Lista intrebarilor;<br>
</li><li>Raspunsurile aferente;</li></ul>

Dependentele:<br>
<ul><li>PersonalSRV - avem nevoie de o instanta a clasei Angajat pentru a stabili un responsabil al chestionarului;<br>
<ul><li>NomenclatorSRv - Persoana Chestionata - pentru obtinerea listei Persoanelor tinta.</li></ul></li></ul>

<br>
<b>DERULAREA UNUI CHESTIONAR</b><br>
In aceasta etapa chestionarul este trimis prin email catre clienti. Raspunsurile la chestionar vor fi colectate pe durata a 2 saptamani<br>

<br>
<b>PROCESAREA REZULTATELOR UNUI CHESTIONAR</b><br>
In aceasta etape sistemul analizeaza raspusurile colectate si afiseaza un raport cu rezultatele obtinute.<br>
<br>
<br>
<b>DEFINIREA UNEI CAMPANII DE PROMOVARE</b><br>
Informatiile necesare pentru definirea unei campanii de promovare sunt:<br>
<ul><li>Numarul campaniei;<br>
</li><li>Tipurile alese de promovare;<br>
</li><li>Data de inceput si data de Sfarsit;<br>
</li><li>Bugetul campaniei;<br>
</li><li>Responsabilul campaniei, numit Promoter;<br>
</li><li>Canalele de distributie.</li></ul>

Dependentele:<br>
<ul><li>PersonalSRV - avem nevoie de o instanta a clasei Angajat pentru a stabili un responsabil al campaniei de promovare.<br>
<br>
<b>DEFINIREA UNEI PROMOTII</b><br></li></ul>

Promotiile sunt un mijloc excelent pentru atragerea de noi clienti, precum si de fidelizare a celor existenti.<br>
Definirea unei promotii presupune urmatoarele elemente:<br>
<ul><li>Numarul promotiei;<br>
</li><li>Mesaj promotional<br>
</li><li>Data de inceput si  de sfarsit;<br>
</li><li>Lista produselor;<br>
</li><li>returile promotionale asociate produselor;<br>
</li><li>esponsabil promotie;</li></ul>

Dependentele:<br>
<ul><li>NomenclatorSRv - Produs- pentru obtinerea listei produselor ce fac parte din promotie;<br>
</li></ul><ul><li>PersonalSRV - avem nevoie de o instanta a clasei Angajat pentru a stabili un responsabil al campaniei de promovare.<br>
<br></li></ul>

<b>PRIMIREA UNEI RECLAMATII</b><br>
Informatiile necesare pentru primirea si inregistrarea unei reclamatii sunt:<br>
<ul><li>Motivul reclamatiei;<br>
</li><li>Statusul reclamatiei;<br>
</li><li>Persoana reclamanta;<br>
</li><li>Data primirii;<br>
</li><li>Raspunsul acordat.</li></ul>

Dependentele:<br>
<ul><li>PersonalSRV - avem nevoie de o instanta a clasei Angajat pentru a stabili un responsabil cu primirea reclamatiilor;<br>
</li><li>NomenclatorSRv - Persoana - pentru obtinerea listei Persoanelor reclamante.</li></ul>

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
<blockquote>Modulul MARKETING depinde de urmatoarele module: <br><br><b>
 <a href='http://code.google.com/p/sia-openerp/wiki/NOMGEN'> Nomenclatoare generale </a> <br> <br>
 <a href='http://code.google.com/p/sia-openerp/wiki/PERSONAL'> Personal</a> <br>
</blockquote><blockquote> Nomenclatoare Materiale. <br><br></blockquote>

<li><b>Business Objects</b>

Unknown end tag for </LI>

<br>
<ul><li>Campanie Promovare;<br>
</li><li>Cercetare Piata<br>
</li><li>Canal Distributie;<br>
</li><li>Chestionar;<br>
</li><li>Persoana Chestionata;<br>
</li><li>Persoana Reclamanta;<br>
</li><li>Promoter;<br>
</li><li>Promotie;<br>
</li><li>Raspuns Intrebare;<br>
</li><li>Status Reclamatie;<br>
</li><li>Tip Promovare;<br>
<br>