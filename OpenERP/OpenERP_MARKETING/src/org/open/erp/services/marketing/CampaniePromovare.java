package org.open.erp.services.marketing;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CampaniePromovare {

	@Id
	@GeneratedValue
	Long id;

	TipPromovare tipPromovare;

	@Temporal(TemporalType.DATE)
	Date data;

	/*@ManyToOne
	// da eroare deocamdata pentru ca modulul din care face parte entitatea nu a
	// facut adnotarile deocamdata.
	Angajat promoter;*/

	CanalDistributie canalDistributie;
	int buget; 

	@OneToMany(mappedBy = "campaniePromovare", targetEntity = Promotie.class, cascade = ALL, fetch = EAGER)
	// Trebuie vazut daca mai trebuie completat ceva.
	Set<Promotie> promotiiCampanie = new HashSet<Promotie>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipPromovare getTipPromovare() {
		return tipPromovare;
	}

	public void setTipPromovare(TipPromovare tipPromovare) {
		this.tipPromovare = tipPromovare;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

/*	public Angajat getPromoter() {
		return promoter;
	}

	public void setPromoter(Angajat promoter) {
		this.promoter = promoter;
	}*/

	public CanalDistributie getCanalDistributie() {
		return canalDistributie;
	}

	public void setCanalDistributie(CanalDistributie canalDistributie) {
		this.canalDistributie = canalDistributie;
	}

	public int getBuget() {
		return buget;
	}

	public void setBuget(int buget) {
		this.buget = buget;
	}

	public Set<Promotie> getPromotiiCampanie() {
		return promotiiCampanie;
	}

	public void setPromotiiCampanie(Set<Promotie> promotiiCampanie) {
		this.promotiiCampanie = promotiiCampanie;
	}

	public void adaugaPromotie(Promotie promotie) {
		this.promotiiCampanie.add(promotie);
	}

	public CampaniePromovare() {
	}

	public CampaniePromovare(long id, TipPromovare tipPromovare, Date data, CanalDistributie canalDistributie, int buget) {
		super();
		this.id = id;
		this.tipPromovare = tipPromovare;
		this.data = data;
		this.canalDistributie = canalDistributie;
		this.buget = buget;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CampaniePromovare other = (CampaniePromovare) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
