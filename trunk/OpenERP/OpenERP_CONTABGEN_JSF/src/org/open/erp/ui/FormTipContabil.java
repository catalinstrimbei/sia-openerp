package org.open.erp.ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.event.ActionEvent;

import org.open.erp.services.ctbgen.ContabilizareSrv;
import org.open.erp.services.ctbgen.RegTipuriContabile;
import org.open.erp.services.ctbgen.TipContabil;

public class FormTipContabil implements Converter{
	private static org.apache.log4j.Logger logger;
	private List<TipContabil> tipuriContabile = new ArrayList<TipContabil>();
	private TipContabil tipContabilCurent;// = null;
	private RegTipuriContabile regTipuriContabile;
	
	@EJB(name = "ContabilizareSrv/local", mappedName="ContabilizareSrv/local")
	private ContabilizareSrv contabSrv;
	
	@PostConstruct
	public void init() throws Exception{
		logger = org.apache.log4j.Logger.getLogger(FormConturi.class.getName());
		logger.debug("Conturi_form - init()");
		
		regTipuriContabile = contabSrv.getRegTipuriContabile();
		tipuriContabile = regTipuriContabile.getTipuriCbt();
		if (!tipuriContabile.isEmpty())
			this.tipContabilCurent = tipuriContabile.get(0);
//		else
//			this.tipContabilCurent = new TipContabil();
//		this.tipContabilCurent.setIdTipContabil(999);
	}
	
	public List<TipContabil> getTipuriContabile() {
		return tipuriContabile;
	}
	
	public void setTipuriContabile(List<TipContabil> tipuriContabile) {
		this.tipuriContabile = tipuriContabile;
	}
		
	public Map<String, TipContabil> getSabloaneMap() {
		Map<String, TipContabil> sabloaneMap = new LinkedHashMap<String, TipContabil>();
		if (this.tipuriContabile != null && !this.tipuriContabile.isEmpty()) {
			for (TipContabil s : this.tipuriContabile) {
				sabloaneMap.put(s.getIdTipContabil().toString(), s);
			}
		}
		return sabloaneMap;
	}
	
	public TipContabil getTipContabilCurent() {
		return tipContabilCurent;
	}

	public void setTipContabilCurent(TipContabil tipContabilCurent) {
		this.tipContabilCurent = tipContabilCurent;
	}

	public String previous2() {
		Integer idCurrentItem = this.tipuriContabile.indexOf(tipuriContabile);
		if (idCurrentItem > 0)
			this.tipContabilCurent = this.tipuriContabile.get(idCurrentItem - 1);
		return "Form";
	}

	public String next2() {
		Integer idCurrentItem = this.tipuriContabile.indexOf(tipContabilCurent);
		if (idCurrentItem + 1 < this.tipuriContabile.size())
			this.tipContabilCurent = this.tipuriContabile.get(idCurrentItem + 1);
		return "Form";
	}

	public void next(ActionEvent evt) {
		next2();
	}

	public void previous(ActionEvent evt) {
		previous2();
	}

	
	public void adaugare(ActionEvent p0) {
		logger.debug("Tipuri_form - adaugare()");
		tipContabilCurent = new TipContabil();
		tipContabilCurent.setIdTipContabil(999);
		this.tipuriContabile.add(tipContabilCurent);//TODO: ???????
	}

	public void stergere(ActionEvent p0) {
		logger.debug("Tipuri_form - stergere()");
		this.tipuriContabile.remove(this.tipContabilCurent);

		 if (!this.tipuriContabile.isEmpty())
			 this.tipContabilCurent = this.tipuriContabile.get(0);
		 else
			 this.tipContabilCurent = null; //TODO: ?????
	}

	public void abandon(ActionEvent p0) {
		logger.debug("Tipuri_form - abandon()");
		//TODO: ?????

	}
		
	public void salveaza(ActionEvent p0) {
		// logger.debug("Tipuri_form - salveaza()");
		// this.rc.addCont(this.contCurent);
		// this.conturi.add(this.contCurent);

		this.tipuriContabile.remove(this.tipContabilCurent);
		this.tipContabilCurent = regTipuriContabile.addTipContabil(this.tipContabilCurent);//TODO: in loc de salveaza <<<<
		this.tipuriContabile.add(this.tipContabilCurent);
	}
		
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp,
			String uiValue) {

		if (uiComp.getId().equals("cboTipuri")) {
			TipContabil uiInregTemplate = new TipContabil();
			uiInregTemplate.setIdTipContabil(Integer.valueOf(uiValue));
			Integer idx = this.tipuriContabile.indexOf(uiInregTemplate);
			return this.tipuriContabile.get(idx);
		}
		return null;
	}
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp,
			Object uiValue) {
		if (uiComp.getId().equals("cboTipuri")) {
			TipContabil contStr = (TipContabil) uiValue;

			if (contStr.getIdTipContabil()!= null)
				return contStr.getIdTipContabil().toString();
		}
		return null;
	}

}
