package org.app.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilizator implements Serializable{
	@Override
	public String toString() {
		return "Utilizator [numeUtilizator=" + numeUtilizator + ", parola="
				+ parola + "]";
	}
	@Id
	private String numeUtilizator;
    private String numeComplet;
    private String email;
	private String parola;
	public String getNumeUtilizator() {
		return numeUtilizator;
	}
	public void setNumeUtilizator(String numeUtilizator) {
		this.numeUtilizator = numeUtilizator;
	}
	public String getNumeComplet() {
		return numeComplet;
	}
	public void setNumeComplet(String numeComplet) {
		this.numeComplet = numeComplet;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((numeComplet == null) ? 0 : numeComplet.hashCode());
		result = prime * result
				+ ((numeUtilizator == null) ? 0 : numeUtilizator.hashCode());
		result = prime * result + ((parola == null) ? 0 : parola.hashCode());
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
		Utilizator other = (Utilizator) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (numeComplet == null) {
			if (other.numeComplet != null)
				return false;
		} else if (!numeComplet.equals(other.numeComplet))
			return false;
		if (numeUtilizator == null) {
			if (other.numeUtilizator != null)
				return false;
		} else if (!numeUtilizator.equals(other.numeUtilizator))
			return false;
		if (parola == null) {
			if (other.parola != null)
				return false;
		} else if (!parola.equals(other.parola))
			return false;
		return true;
	}
	public Utilizator(String numeUtilizator, String numeComplet, String email,
			String parola) {
		super();
		this.numeUtilizator = numeUtilizator;
		this.numeComplet = numeComplet;
		this.email = email;
		this.parola = parola;
	}
	public Utilizator() {
		super();
	}
	
}
	