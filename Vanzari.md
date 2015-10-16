<h2>Pagina modulului VANZARI.</h2>
> <h3>Functionalitatile modulului VANZARI:</h3>
    1. Crearea si gestionarea comenzilor
    1. Crearea si gestionarea facturilor
    1. Actualizarea stocului
    1. Modificarea soldului clientului
    1. Realizarea returului produselor


<h3>Descrierea detaliata a modulului  </h3>
<b>Operatiuni specifice modulului VANZARI: <br></br></b>

<b>CREAREA UNEI NOI COMENZI</b><br>
Datele necesare:<br>
<ul><li>Vector de produse ce vor face parte din comanda<br>
</li><li>Vector de cantitati aferente fiecarui produs<br>
</li><li>Clientul pentru care se inregistreaza comanda<br>
</br></li></ul>

<b> CREAREA UNEI NOI FACTURI.</b><br>
Datele necesare:<br>
<ul><li>O comanda inregistrata<br>
</li><li>Clientul pentru care se factureaza produsele<br>
</li><li>Vanzatorul care realizeaza factura<br>
</br></li></ul>

<b>INREGISTRAREA UNEI FACTURI</b><br>
Datele necesare:<br>
<ul><li>Factura pentru care se realizeaza inregistrarea</li></ul>

<b>ACTUALIZAREA STOCULUI IN MOMENTUL EMITERII FACTURII</b><br>
Datele necesare:<br>
<ul><li>Tipul actualizarii: intrare sau iesire din gestiune<br>
</li><li>Factura cu produsele ce vor fi actualizate<br>
</br>
<br></br>
<b>MODIFICAREA SOLDULUI CLIENTULUI DUPA EMITEREA UNEI NOI FACTURI</b><br>
Datele necesare:<br>
</li><li>Factura din care se va prelua valoarea<br>
</li><li>Clientul pentru care se va modifica soldul<br>
</br>
<br></br>
<b>AFISAREA UNEI LISTE CU FACTURI EMISE UNUI CLIENT</b><br>
Datele necesare:<br>
</li><li>Clientul pentru care se cauta lista de facturi</li></ul>

<b>REALIZARE RETUR PRODUSE</b>
Datele necesare:<br>
<ul><li>Factura cu produsele ce vor fi returnate</li></ul>

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
<blockquote><a href='http://sia-openerp.googlecode.com/svn/trunk/OpenERP/OpenERP_STOCURI/src/org/open/erp/services/stocuri/StocuriSrv.java'> Stocuri </a> <br><br>
<a href='http://sia-openerp.googlecode.com/svn/trunk/OpenERP/OpenERP_NOMGEN/src/org/open/erp/services/nomgen/NomenclatoareSrv.java'> Nomenclatoare generale</a> <br><br>
<a href='http://sia-openerp.googlecode.com/svn/trunk/OpenERP/OpenERP_CONTABGEN/src/org/open/erp/services/ctbgen/ContabilizareSrv.java'>Contabilitate generala</a><br><br>
<li><b>Business Objects</b>

Unknown end tag for </LI>

<br>
<ul><li>Client<br>
</li><li>FacturaEmisa<br>
</li><li>Comanda<br>
</li><li>Vanzator