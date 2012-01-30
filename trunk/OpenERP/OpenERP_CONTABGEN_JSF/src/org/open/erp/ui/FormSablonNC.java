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
import org.open.erp.services.ctbgen.RegSablonNC;
import org.open.erp.services.ctbgen.SablonNC;


public class FormSablonNC implements Converter {
	private static org.apache.log4j.Logger logger;

	private List<SablonNC> sabloane = new ArrayList<SablonNC>();
	private SablonNC sablonCurent;// = null;
	private RegSablonNC regSablon;

	@EJB(name = "ContabilizareSrv/local", mappedName = "ContabilizareSrv/local")
	private ContabilizareSrv contabSrv;

	@PostConstruct
	public void init() throws Exception {
		logger = org.apache.log4j.Logger
				.getLogger(FormSablonNC.class.getName());
		logger.debug("Conturi_form - init()");

		regSablon = contabSrv.getRegSablonNC();
		sabloane = regSablon.getSabloane();
		if (!sabloane.isEmpty())
			this.sablonCurent = sabloane.get(0);
//		else {
//			this.sablonCurent = new SablonNC();
//			this.sablonCurent.setIdSablon(999);
//		}
	}

	public List<SablonNC> getSabloane() {
		return sabloane;
	}

	public void setSabloane(List<SablonNC> sabloane) {
		this.sabloane = sabloane;
	}

	public Map<String, SablonNC> getSabloaneMap() {
		Map<String, SablonNC> sabloaneMap = new LinkedHashMap<String, SablonNC>();
		if (this.sabloane != null && !this.sabloane.isEmpty()) {
			for (SablonNC s : this.sabloane) {
				sabloaneMap.put(s.getNrSablon().toString(), s);
			}
		}
		return sabloaneMap;
	}

	public SablonNC getSablonCurent() {
		return sablonCurent;
	}

	public void setSablonCurent(SablonNC sablonCurent) {
		this.sablonCurent = sablonCurent;
	}

	public String previous2() {
		Integer idCurrentItem = this.sabloane.indexOf(sablonCurent);
		if (idCurrentItem > 0)
			this.sablonCurent = this.sabloane.get(idCurrentItem - 1);
		return "Form";
	}

	public String next2() {
		Integer idCurrentItem = this.sabloane.indexOf(sablonCurent);
		if (idCurrentItem + 1 < this.sabloane.size())
			this.sablonCurent = this.sabloane.get(idCurrentItem + 1);
		return "Form";
	}

	public void next(ActionEvent evt) {
		next2();
	}

	public void previous(ActionEvent evt) {
		previous2();
	}

	public void adaugare(ActionEvent p0) {
		logger.debug("Conturi_form - adaugare()");
		sablonCurent = new SablonNC();
		sablonCurent.setIdSablon(999);
		this.sabloane.add(sablonCurent);//TODO: ???????
	}

	public void stergere(ActionEvent p0) {
		logger.debug("Conturi_form - stergere()");
		this.sabloane.remove(this.sablonCurent);

		 if (!this.sabloane.isEmpty())
			 this.sablonCurent = this.sabloane.get(0);
		 else
			 this.sablonCurent = null; //TODO: ?????
	}

	public void abandon(ActionEvent p0) {
		logger.debug("Conturi_form - abandon()");
		//TODO: ?????

	}

	public void salveaza(ActionEvent p0) {
		// logger.debug("Conturi_form - salveaza()");
		// this.rc.addCont(this.contCurent);
		// this.conturi.add(this.contCurent);

		this.sabloane.remove(this.sablonCurent);
		this.sablonCurent = contabSrv.getRegSablonNC().addSablon(this.sablonCurent);//TODO: in loc de salveaza <<<<
		this.sabloane.add(this.sablonCurent);
	}

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent uiComp,
			String uiValue) {

		if (uiComp.getId().equals("cboSabloane")) {
			SablonNC uiInregTemplate = new SablonNC();
			uiInregTemplate.setIdSablon(Integer.valueOf(uiValue));
			Integer idx = this.sabloane.indexOf(uiInregTemplate);
			return this.sabloane.get(idx);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent uiComp,
			Object uiValue) {
		if (uiComp.getId().equals("cboSabloane")) {
			SablonNC contStr = (SablonNC) uiValue;

			if (contStr.getIdSablon() != null)
				return contStr.getIdSablon().toString();
		}
		return null;
	}
}
