package org.open.erp.services.contabgest.impl;
import java.util.ArrayList;

import org.open.erp.services.contabgest.CalculCost;
import org.open.erp.services.contabgest.contabGestSrv;;

public class contabGestImpl implements contabGestSrv{


		private int id;
		private ArrayList <CalculCost> lista=new ArrayList<CalculCost>();
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public ArrayList<CalculCost> getLista() {
			return lista;
		}
		public void setLista(ArrayList<CalculCost> lista) {
			this.lista = lista;
		} 
				

	
	
	
}
