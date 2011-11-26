package org.open.erp.services.salarizare;

import java.util.ArrayList;
import java.util.List;

public class CentralizatorStatSalarii {
	private Integer An;
	private Integer Luna;
	private List<StatSalarii> centralizator = new ArrayList<StatSalarii>();
	public Integer getAn() {
		return An;
	}
	public void setAn(Integer an) {
		An = an;
	}
	public Integer getLuna() {
		return Luna;
	}
	public void setLuna(Integer luna) {
		Luna = luna;
	}
	public List<StatSalarii> getCentralizator() {
		return centralizator;
	}
	public void setCentralizator(List<StatSalarii> centralizator) {
		this.centralizator = centralizator;
	}
	
	public void addStatSalarii(StatSalarii s){
		this.centralizator.add(s);
	}
}
