package org.open.erp.services.finplati.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.log4j.Logger;
//import org.open.erp.services.achizitii.Factura;
// org.open.erp.services.achizitii.PlanAprov;
import org.open.erp.services.finplati.FacturaStatus;
import org.open.erp.services.finplati.Persoana;
import org.open.erp.services.finplati.ResponsabilPlata;
import org.open.erp.services.finplati.SituatieFinanciara;
import org.open.erp.services.finplati.ChitantaPlata;
import org.open.erp.services.finplati.Contract;
import org.open.erp.services.finplati.FurnizorContract;
import org.open.erp.services.finplati.Plata;


/**
* 
* @BusinessObject(Repository)
* 
*/

public class RegistruFinPlati {
	private static Logger logger = Logger.getLogger(RegistruFinPlati.class.getName()); 

	/* set up */
	private EntityManager entityManager;
	public RegistruFinPlati(EntityManager em) {
	entityManager = em;
	}
	/* interogari */
	//SituatieFinanciara
	public SituatieFinanciara getSituatieFinanciara(Integer id){
		return entityManager.find(SituatieFinanciara.class, id);
	}
	
	//contract
	 public Contract getContract(Integer id){
		 return entityManager.find(Contract.class, id);
		 }

	 public List<Contract> getToateContractele(){
		 return entityManager.createQuery("SELECT c FROM Contract c").getResultList();
		 }
	 
	 public List<Contract> getContracteDupaFurnizor(Integer idFurnizor){
		 return entityManager
		 .createQuery("SELECT c FROM Contract c WHERE f.furnizor.idFurnizor=:idFurnizor")
		 .setParameter("idFurnizor", idFurnizor)
		 .getResultList();
		 }
	 
	 public List<Contract> getContracteDupaPlata(Integer idPlata){
		 return entityManager
		 .createQuery("SELECT c FROM Contract c WHERE p.plata.idplata=:idplata")
		 .setParameter("numeFurnizor", idPlata)
		 .getResultList();
		 }
		
	//persoana
	 public Persoana getPersoana(Integer id){
		 return entityManager.find(Persoana.class, id);
		 }
	 
	 public List<Persoana> getToatePersoanele(){
		 return entityManager.createQuery("SELECT pp FROM Persoana pp").getResultList();
		 } 

		 public List<Persoana> getPersoanaDupaResponsabilPlata(Integer idPersoana){
		 return entityManager
		 .createQuery("SELECT pp FROM Persoana pp WHERE pp.persoana.idPersoana=:idPersoana")
		 .setParameter("idPersoana", idPersoana)
		 .getResultList();
		 }
	 
	//FacturaStatus
		
		
		public FacturaStatus getFacturaStatus(Integer id){
			return entityManager.find(FacturaStatus.class, id);
		}
		public List<FacturaStatus> getToateFacturile(){
			return entityManager.createQuery("SELECT p FROM FacturaStatus p").getResultList();
		}
		
		public List<FacturaStatus> getFacuraDupaIdFurnizor(Integer idFurnizor){
			return entityManager
					.createQuery("SELECT p FROM FacturaStatus p WHERE p.furnizor.idFurnizor=:idFurnizor")
					.setParameter("idFurnizor", idFurnizor)
					.getResultList();
		}
		
		public List<FacturaStatus> getFacturaDupaNumeFurnizor(String nume){
			return entityManager
					.createQuery("SELECT p FROM Factura p WHERE p.funrizor.numeFurnizor=:numeFurnizor")
					.setParameter("numeFurnizor", nume)
					.getResultList();
		}
		
	//plata	
		public Plata getPlata(Integer id){
			return entityManager.find(Plata.class, id);
		}
		
		public List<Plata> getToatePlatile(){
			return entityManager.createQuery("SELECT pl FROM Plata pl").getResultList();
			}
		
			public List<Plata> getPlataDupaValoarePlata(Double valoare){
			return entityManager
			.createQuery("SELECT pl FROM Plata pl WHERE pl.valoareplata.valoarePlata=:valoarePlata")
			.setParameter("valoarePlata", valoare)
			.getResultList();
			}
		
		
		//furnizorcontract
		public FurnizorContract getFurnizorContract(Integer id){
			return entityManager.find(FurnizorContract.class, id);
		}
		
		 public List<FurnizorContract> getToateContracteleFurnizate(){
			 return entityManager.createQuery("SELECT f FROM FurnizorContract f").getResultList();
			 }
		 
		public List<FurnizorContract> getFurnizorContractDupaNumeFurnizor(String nume){
			 return entityManager
			 .createQuery("SELECT f FROM FurnizorContract f WHERE f.furnizor.numeFurnizor=:numeFurnizor")
			 .setParameter("numeFurnizor", nume)
			 .getResultList();
			 }
		
		
		//responsabilplata
		public ResponsabilPlata getResponsabilPlata(Integer id){
			return entityManager.find(ResponsabilPlata.class, id);
		}
		public List<ResponsabilPlata> getTotiResponsabilPlata(){
			return entityManager.createQuery("SELECT r FROM ResponsabilPlata r").getResultList();
			}
			public List<ResponsabilPlata> getResponsabilPlataDupaPlata(Integer idPlata){
			return entityManager
			.createQuery("SELECT r FROM ResponsabilPlata r WHERE r.ResponsabilPlata.idPlata=:idPlata")
			.setParameter("idPlata", idPlata)
			.getResultList();
			}
			
			
		//chitantaplata
		
		public ChitantaPlata getChitantaPlata(Integer id){
			return entityManager.find(ChitantaPlata.class, id);
		}
		
		
		
		/* persistenta */
	
		
		
		// contract
		public Contract salveazaContract(Contract contract) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (contract.getIdContract() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(contract.getClass(), contract.getIdContract()) == null)
					entityManager.persist(contract);
				else
					entityManager.merge(contract);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return contract;
		}
		
		public void stergeContract(Contract contract){
			entityManager.remove(contract);
		}
		
		
//furnizor contract
		
			public FurnizorContract salveazaFurnizorContract(FurnizorContract furnizorcontract) throws Exception{
				try{
					
					//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
					if (furnizorcontract.getIdFurnizor() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
						entityManager.find(furnizorcontract.getClass(), furnizorcontract.getIdFurnizor()) == null)
						entityManager.persist(furnizorcontract);
					else
						entityManager.merge(furnizorcontract);
					
				}catch(Exception ex){
					logger.info("EROARE PERSISTENTA ***** ");
					ex.printStackTrace();
					throw ex;
				}
				return furnizorcontract;
			}
			
			public void stergeFurnizorContract(FurnizorContract furnizorcontract){
				entityManager.remove(furnizorcontract);
			}
			public void refreshFurnizorContract(FurnizorContract furnizorcontract){
				entityManager.refresh(furnizorcontract);
			}
		
		
		//FacturaStatus
		public FacturaStatus salveazaFacturaStatus(FacturaStatus factura) throws Exception{
			try{
				
				//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (factura.getNrFactura() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
					entityManager.find(factura.getClass(), factura.getNrFactura()) == null)
					entityManager.persist(factura);
				else
					entityManager.merge(factura);
				
			}catch(Exception ex){
				logger.info("EROARE PERSISTENTA ***** ");
				ex.printStackTrace();
				throw ex;
			}
			return factura;
		}
		
		public void stergeFacturaStatus(FacturaStatus factura){
			entityManager.remove(factura);
		}
		public void refreshFacturaStatus(FacturaStatus factura){
			entityManager.refresh(factura);
		}
		
		
		
		//persoana
				public Persoana salveazaPersoana(Persoana persoana) throws Exception{
					try{
						
						//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
						if (persoana.getIdPersoana() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
							entityManager.find(persoana.getClass(), persoana.getIdPersoana()) == null)
							entityManager.persist(persoana);
						else
							entityManager.merge(persoana);
						
					}catch(Exception ex){
						logger.info("EROARE PERSISTENTA ***** ");
						ex.printStackTrace();
						throw ex;
					}
					return persoana;
				}
				
				public void stergePersoana(Persoana factura){
					entityManager.remove(factura);
				}
				public void refreshPersoana(Persoana factura){
					entityManager.refresh(factura);
				}
				
				
				
		//responsabil plata
				
		public ResponsabilPlata salveazaResponsabilPlata(ResponsabilPlata responsabil) throws Exception{
			try{
						
			//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
	if (responsabil.getidResponsabil() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
				entityManager.find(responsabil.getClass(), responsabil.getidResponsabil()) == null)
					entityManager.persist(responsabil);
						else
							entityManager.merge(responsabil);
						
					}catch(Exception ex){
						logger.info("EROARE PERSISTENTA ***** ");
						ex.printStackTrace();
						throw ex;
					}
					return responsabil;
				}
				
				public void stergeResponsabilPlata(ResponsabilPlata responsabil){
					entityManager.remove(responsabil);
				}
				public void refreshResponsabilPlata(ResponsabilPlata responsabil){
					entityManager.refresh(responsabil);
				}
	
	
				
	//chitantaplata 
				
	public ChitantaPlata salveazaChitantaPlata(ChitantaPlata chitantaplata) throws Exception{
					try{
								
					//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
			if (chitantaplata.getidChitanta() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
						entityManager.find(chitantaplata.getClass(), chitantaplata.getidChitanta()) == null)
							entityManager.persist(chitantaplata);
								else
									entityManager.merge(chitantaplata);
								
							}catch(Exception ex){
								logger.info("EROARE PERSISTENTA ***** ");
								ex.printStackTrace();
								throw ex;
							}
							return chitantaplata;
						}
						
						public void stergeChitantaPlata(ChitantaPlata chitantaplata){
							entityManager.remove(chitantaplata);
						}
						public void refreshChitantaPlata(ChitantaPlata chitantaplata){
							entityManager.refresh(chitantaplata);
						}
	
			//chitantaplata 
			
			public Plata salveazaPlata(Plata plata) throws Exception{
							try{
										
							//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
					if (plata.getId() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
								entityManager.find(plata.getClass(), plata.getId()) == null)
									entityManager.persist(plata);
										else
											entityManager.merge(plata);
										
									}catch(Exception ex){
										logger.info("EROARE PERSISTENTA ***** ");
										ex.printStackTrace();
										throw ex;
									}
									return plata;
								}
								
								public void stergePlata(Plata plata){
									entityManager.remove(plata);
								}
								public void refreshPlata(Plata plata){
									entityManager.refresh(plata);
								}
						
						
	//SituatieFinanciara
	public SituatieFinanciara salveazaSituatieFinanciara(SituatieFinanciara SitFit) throws Exception{
				try{
								
								//if (!entityManager.contains(proiect)) /* o posibilitate de verificare */
				if (SitFit.getIdSitFit() == null || /* proiect.getIdProiect() pentru proiect cu id generat*/
						entityManager.find(SitFit.getClass(), SitFit.getIdSitFit()) == null)
						entityManager.persist(SitFit);
								else
						entityManager.merge(SitFit);}
								
					catch(Exception ex){
								logger.info("EROARE PERSISTENTA ***** ");
								ex.printStackTrace();
								throw ex;
							}
							return SitFit;
						}
						
						public void stergeSituatieFinanciara(SituatieFinanciara SitFit){
							entityManager.remove(SitFit);
						}
						
	}


