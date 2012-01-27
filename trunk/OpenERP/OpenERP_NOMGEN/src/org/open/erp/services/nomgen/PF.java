package org.open.erp.services.nomgen;

public interface PF {



	public abstract String getNume() ;

	/**
	 * @param nume the nume to set
	 */
	public abstract void setNume(String nume);


	/**
	 * @return the prenume
	 */
	public abstract String getPrenume() ;

	/**
	 * @param prenume the prenume to set
	 */
	public abstract void setPrenume(String prenume) ;


	/**
	 * @return the formaAdresare
	 */
	public abstract String getFormaAdresare() ;
	/**
	 * @param formaAdresare the formaAdresare to set
	 */
	public abstract void setFormaAdresare(String formaAdresare);

	/**
	 * @return the gen
	 */
	public abstract char getGen() ;
	/**
	 * @param gen the gen to set
	 */
	public abstract void setGen(char gen) ;

	/**
	 * @return the cnp
	 */
	public abstract String getCnp() ;

	/**
	 * @param cnp the cnp to set
	 */
	public abstract void setCnp(String cnp) ;

	

	

	public abstract Persoana getP() ;

	public abstract void setP(Persoana p) ;

	

	
	
	
	
}
