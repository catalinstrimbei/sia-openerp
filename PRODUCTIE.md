<h3>Modulul OpenERP_Productie</h3>

<h2>Introduction </h2>
Acest modul se ocupa cu realizarea si gestionarea ciclului de productie a produselor.


<h2> Detalii </h2>

> <h3> I. Partea functionala </h3>

<h4>Modulul cuprinde urmatoarele procese:</h4>

<h4><u>1. Crearea unui flux de productie pentru un anumit produs.</u></h4>
Acest proces presupune definirea mai multor faze de productie care sa se desfasoare in cadrul fluxului.


<h4><u>2. Crearea unei faze de productie.</u></h4>
Fazele de productie reprezinta stadii in care anumite materiale si semifabricate sunt prelucrate cu ajutorul unor utilaje de catre anumiti angajati, pentru ca in final sa se obtina un semifabricat sau produsul final.
Pentru fiecare faza sunt necesare o serie de resurse:
  * o lista de materiale care sunt cuprinse in reteta;
  * un semifabricat cuprins in reteta (de regula semifabricatul obtinut in faza anterioara);
  * o lista de functii de personal pentru a efectua operatiile necesare;
  * o lista de angajati pe baza functiilor necesare;
  * un utilaj care sa realizeze anumite operatii intr-un anumit timp;
  * o sectie (divizie) in care sa se desfasoare intreaga activitate.

<h4><u>3. Lansarea in productie a unei comenzi.</u></h4>
Pe baza comenzii primite de la modulul de stocuri, se apeleaza fluxul de productie definit pentru produs si se fabrica produsul pentru care s-a efectuat comanda

<h4><u>3. Comanda de materiale de la stocuri.</u></h4>
Pentru realizarea unui produs sunt necesare anumite materiale care se afla la Stocuri. Pentru fiecare faza se realizeaza o comanda de materiale catre modulul de stocuri.

<h4><u>4. Contorizarea consumului de resurse.</u></h4>
In fiecare faza a unui flux sunt consumate anumite resurse pe care modulul COntabilitate de Gestiune trebuie sa il inregistreze in contabilitate. Aceste resurse sunt: materiile prime, utilajele si angajatii.

<h4><u>5. Realizarea controlului de calitate pentru fiecare unitate de produs.</u></h4>
Dupa fabricare, fiecare unitate de produs trebuie sa treaca printr-un control de calitate. In urma acestui control, o anumita unitate de produs poate fi produs finit sau deseu.

<h4><u>6. Livrarea produsului catre modului de Stocuri.</u></h4>
Dupa fabricare, podusul obtinut trebuie sa fie livrat catre modului de Stocuri.


> <h3> II. Partea tehnica</h3>
<h4><u>1. Dependente</u></h4>
Modulul depinde direct de urmatoarele module pentru a putea utiliza entitatile de care acestea dispun: <br />
<b>Nomenclatoare:</b> Divizie, Departament,MateriePrima, Material, MijlocFix, Persoana, Produs, Document, LinieDocument; <br />
<b>Personal:</b> Angajat, Functie; <br />
<b>Stocuri:</b> ArticolStoc, CerereAprovizionare. <br />
<br />
<h4><u>2. Entitati locale</u></h4>
ComandaProductie <br />
CriteriuCalitate <br />
FazaProductie <br />
FluxProductie <br />
FunctieNecesara <br />
Semifabricat <br />
Utilaj <br />