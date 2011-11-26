package org.open.erp.services.stocuri;

public class ArticolStoc {
Integer id;
String denumire;
Integer cantitateStoc;

public ArticolStoc() {
 super();
}

public ArticolStoc(Integer id, String denumire, Integer cantitateStoc) {
 super();
 this.id = id;
 this.denumire = denumire;
 this.cantitateStoc = cantitateStoc;
}

public Integer getId() {
 return id;
}

public void setId(Integer id) {
 this.id = id;
}

public String getDenumire() {
 return denumire;
}

public void setDenumire(String denumire) {
 this.denumire = denumire;
}

public Integer getCantitateStoc() {
 return cantitateStoc;
}

public void setCantitateStoc(Integer cantitateStoc) {
 this.cantitateStoc = cantitateStoc;
}




}
