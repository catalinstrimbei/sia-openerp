package org.open.erp.services.marketing;

import java.util.HashSet;
import java.util.Set;

public class Intrebare{
	long id;
	String text;
	Set<RaspunsIntrebare> raspunsuriIntrebare =  new HashSet<RaspunsIntrebare>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Set<RaspunsIntrebare> getRaspunsuriIntrebare() {
		return raspunsuriIntrebare;
	}
	public void setRaspunsuriIntrebare(Set<RaspunsIntrebare> raspunsuriIntrebare) {
		this.raspunsuriIntrebare = raspunsuriIntrebare;
	}
}