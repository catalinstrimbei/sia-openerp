package org.open.erp.services.marketing;

public class RaspunsIntrebare {
	long id;
	String text;

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

	public RaspunsIntrebare() {

	}

	public RaspunsIntrebare(long id, String text) {
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
		RaspunsIntrebare other = (RaspunsIntrebare) obj;
		if (id != other.id)
			return false;
		return true;
	}

}