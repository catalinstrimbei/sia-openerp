<h1> INTRODUCERE </h1>

Modul STOCURI se ocupa cu evidenta stocurilor, a gestiunilor si a loturilor acestora. 

&lt;BR/&gt;



Modulul cuprinde urmatoarele functionalitati:
<ul>
<blockquote><li> Intrarea in stoc a materialeleor </li>
<li> Transferul materialelor de la o gestiune la alta</li>
<li> Iesirea din stoc a materialelor</li></blockquote>

<h1> DETALII </h1>
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
<br>
Aplicatia are urmatoarele cazuri de utilizare: <br> <br>
<b>Intrarea materialelor in stoc</b><br>Intrarea in stoc se face pe baza unui document (NIR) intr-o anumita gestiune si intr-un lot. <br><br>
<b>Transferul materialelor de la o gestiune la alta</b> <br> Se poate transfera o anumita cantitate dintr-un matetrial de la o gestiune la alta. <br>

<BR>

<br>
<b>Iesirea materialelor din stoc pentru Productie </b><br> Pe baza unui bon de consum se dau materiale din stoc catre productie. In cazul in care cantitatea ceruta nu este suficienta in stoc, se face o cerere de aprovizionare catre Achizitii.<br><br>
<b>  Iesirea produselor din stoc pentru vanzare </b><br> Pe baza documentului aferent, se face iesirea din stoc catre modulul vanzari (pentru vanzare). <br><br>
<b> Verificarea stocului de materiale</b> <br> Putem obtine stocul unui material la un moment dat.<br>


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
<blockquote>Modulul STOCURI depinde de urmatoarele module: <br><br>
-<a href='http://code.google.com/p/sia-openerp/wiki/NOMGEN'> Nomenclatoare generale </a> <br><br>
- <a href='http://code.google.com/p/sia-openerp/wiki/PERSONAL'> Personal</a> <br><br>
- <a href='http://code.google.com/p/sia-openerp/wiki/ACHIZITII'> Achizitii </a> <br> <br><br>
<li><b>Business Objects Locale</b>

Unknown end tag for </LI>

<br>
</blockquote><blockquote>- Articol Stoc <br>
- Bon Consum <br>
- Bon Transfer <br>
- Cerere Aprovizionare<br>
- Comanda Produse<br>
- Depozit<br>
- Gestionar<br>
- Gestiune<br>
- Loturi Intrari<br>
- Prioritate Materiale Productie<br>
<br>
<li><b>Operatiile/ Actiunile/ Application Service</b>

Unknown end tag for </LI>

