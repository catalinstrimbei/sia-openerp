package org.open.erp.services.nomgen;

import java.util.Calendar;

public class Test {
	private static Test test;
	private int week=Calendar.WEEK_OF_MONTH;
	private String attr1;
	private Integer attr2;
	
	private Test(int week){
		this.week=week;
	}	
	
	public static Test getTest(){
			if (Calendar.WEEK_OF_MONTH!=test.getWeek()){
				test = new Test(Calendar.WEEK_OF_MONTH);
			}
			return test;
		
	}
	public Integer getAttr2() {
		return attr2;
	}
	public void setAttr2(Integer attr2) {
		this.attr2 = attr2;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}
	
}
