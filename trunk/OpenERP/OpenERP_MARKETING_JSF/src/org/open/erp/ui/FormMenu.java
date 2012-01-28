package org.open.erp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.open.erp.ui.reports.WebReportRunner;


@ManagedBean(name="formMenu")
@SessionScoped
public class FormMenu {
	private static Logger logger = Logger.getLogger(FormMenu.class.getPackage().getName());
	
	private String formCurent;
	
	/* menu versiunea 1*/
	public void actionChangeForm(ActionEvent evt){
		String srcForm = evt.getComponent().getAttributes().get("srcForm").toString();
		logger.debug("V1: Action Change form request srcForm= " + srcForm);
		this.formCurent = srcForm;
	}
	
	public String changeFormCurent(){
		logger.debug("V2: Change form request: " + this.formCurent);
		return this.formCurent;
	}
	
	/* menu versiunea 2*/
	public void actionSrcChangeForm(ActionEvent evt){
		String srcForm = evt.getComponent().getAttributes().get("srcForm").toString();
		logger.debug("V2/4-1: Action Change form request srcForm= " + srcForm);
		this.formCurent = srcForm;
	}
	public String changeSrcFormCurent(){
		logger.debug("V2-2: Change form request: " + this.formCurent);
		return "menuv2/FormMenuV2";
	}
	public String getSrcCurentForm(){
		String urlForm = "/AppBanner.xhtml"; 
		if (this.formCurent != null)
			urlForm = "/" + this.formCurent + ".xhtml";
		logger.debug("V2/3/4-3: FINAL Curent Form Url: " + urlForm);
		return urlForm;
		
	}
	
	/* menu versiunea 3*/
	private Map<String, String> formulare = new HashMap<String, String>();
	public FormMenu(){
		formulare.put("Editare Form1", "Form1");
		formulare.put("Editare Form2", "Form2");
		formulare.put("Lista Raport1", "FormRaport");	
		formulare.put("Lista Promotii" , "ListaPromotiiImpl");
	}
	public List<String> getFormulare() {
		logger.debug("V3: Get Formulare");
		List<String> formList = new ArrayList<String>();
		formList.addAll(this.formulare.keySet());
		return formList;
	}
	public void actionSrcGetForm(ActionEvent evt){
		UICommand uiComanda = (UICommand) evt.getComponent();
		logger.debug("V3: Generic Action Change form request: " + uiComanda.getValue());
		this.formCurent = this.formulare.get(uiComanda.getValue());
		logger.debug("V3: Generic Action Change form result: " + this.formCurent);		
	}	
	public String changeSrcGetForm(){
		logger.debug("V3: Change form request: " + this.formCurent);
		return "menuv3/FormMenuV3";
	}
	// Versiunea 4 a meniului implica si metoda: public String getSrcCurentForm()
	
	/* menu versiunea 4
	public void actionRichSrcChangeForm(ActionEvent evt){
		String srcForm = evt.getComponent().getAttributes().get("srcForm").toString();
		logger.debug("V4-1: Action Change form request srcForm= " + srcForm);
		this.formCurent = srcForm;
	}
	public String getRichSrcCurentForm(){
		String urlForm = "/AppBanner.xhtml"; 
		if (this.formCurent != null)
			urlForm = "/" + this.formCurent + ".xhtml";
		logger.debug("V4-3: FINAL Curent Form Url: " + urlForm);
		return urlForm;
	}		
	*/
	public String changeRichSrcFormCurent(){
		logger.debug("V4-2: Change form request: " + this.formCurent);
		return "menuv4/FormMenuV4";
	}	

	
	/* Reporting */
	public void showRaport(ActionEvent evt){
		String srcRaport = evt.getComponent().getAttributes().get("srcRaport").toString();
		logger.debug("START Loading report ... " + srcRaport);
		WebReportRunner.runReport(srcRaport + ".rptdesign");
		logger.debug("END Loading report ... " + srcRaport);
	}	

}