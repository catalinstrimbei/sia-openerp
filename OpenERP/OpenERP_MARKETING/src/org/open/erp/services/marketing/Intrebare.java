package org.open.erp.services.marketing;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Intrebare {
	
	@Id @GeneratedValue
	long id;
	
	String text;
	
	@ManyToOne
	Chestionar chestionar;
	
	@OneToMany(mappedBy = "intrebare", targetEntity = RaspunsIntrebare.class, cascade = ALL, fetch = EAGER)
	Set<RaspunsIntrebare> raspunsuriIntrebare = new HashSet<RaspunsIntrebare>();

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

	public Chestionar getChestionar() {
		return chestionar;
	}

	public void setChestionar(Chestionar chestionar) {
		this.chestionar = chestionar;
	}

	public Set<RaspunsIntrebare> getRaspunsuriIntrebare() {
		return raspunsuriIntrebare;
	}

	public void setRaspunsuriIntrebare(Set<RaspunsIntrebare> raspunsuriIntrebare) {
		this.raspunsuriIntrebare = raspunsuriIntrebare;
	}

	public void adaugaRaspuns(RaspunsIntrebare raspuns) {
		this.raspunsuriIntrebare.add(raspuns);
	}

	public Intrebare() {

	}

	public Intrebare(long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Intrebare other = (Intrebare) obj;
		if (id != other.id)
			return false;
		return true;
	}
}