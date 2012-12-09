package org.open.erp.services.stocuri;

import java.util.ArrayList;
import java.util.List;
 
public class ListaGestiuni {
	private Integer idLista;
    private List<Gestiune> gestiuni = new ArrayList<Gestiune>();
               
    public ListaGestiuni(Integer idLista, List<Gestiune> gestiuni) {
    	super();
        this.idLista = idLista;
        this.gestiuni = gestiuni;
        }
               
    public Integer getIdLista() {
    	return idLista;
        }
    public void setIdLista(Integer idLista) {
    	this.idLista = idLista;
        }
    public List<Gestiune> getGestiuni() {
    	return gestiuni;
    }
    public void setGestiuni(List<Gestiune> gestiuni) {
    	this.gestiuni = gestiuni;
        }
    public void addGestiune(Gestiune gest){
    	this.gestiuni.add(gest);
    }
    public void removeGestiune(Gestiune gest){
    	this.gestiuni.remove(gest);
    }
    public Gestiune getGestiuneById(Integer id) {
    	for(Gestiune g:this.getGestiuni()){
    		if(g.getIdGest() == id){
            return g;
            }
    	}
    	return null;
                              
    }
               
    @Override
    public int hashCode() {
    	final int prime = 31;
        int result = 1;
        result = prime * result
        		+ ((gestiuni == null) ? 0 : gestiuni.hashCode());
                result = prime * result + ((idLista == null) ? 0 : idLista.hashCode());
                return result;
    }
 
    @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
        if (obj == null)
        	return false;
        if (getClass() != obj.getClass())
        	return false;
        ListaGestiuni other = (ListaGestiuni) obj;
        	if (gestiuni == null) {
        		if (other.gestiuni != null)
        			return false;
              	} else if (!gestiuni.equals(other.gestiuni))
              		return false;
             	if (idLista == null) {
             		if (other.idLista != null)
             			return false;
                 	} else if (!idLista.equals(other.idLista))
                 		return false;
             	return true;
    	}
               
}