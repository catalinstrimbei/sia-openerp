package org.open.erp.ui.proman;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.open.erp.ui.proman.reports.WebReportRunner;

@ManagedBean(name="formRichMenu")
@SessionScoped
public class FormRichProiecte {
	private String formCurent;	
	/* menu versiunea 4*/
	public void actionSrcChangeForm(ActionEvent evt){
		String srcForm = evt.getComponent().getAttributes().get("srcForm").toString();
		System.out.println("V4-1: Action Change form request srcForm= " + srcForm);
		this.formCurent = srcForm;
	}
	public String changeSrcFormCurent(){
		System.out.println("V4-2: Change form request: " + this.formCurent);
		return "menuv4/FormMenuV4";
	}
	public String getSrcCurentForm(){
		String urlForm = "/AppBanner.xhtml"; 
		if (this.formCurent != null)
			urlForm = "/" + this.formCurent + ".xhtml";
		System.out.println("V4-3: FINAL Curent Form Url: " + urlForm);
		return urlForm;
	}	
	
	/* Reporting */
	public void showReport(ActionEvent evt){
		System.out.println("Loading report ... " + "RaportProiecte.rptdesign");
//		WebReportRunner.runReport("RaportProiecte.rptdesign");
		System.out.println("END Loading report ... " + "RaportProiecte.rptdesign");
	}
}
