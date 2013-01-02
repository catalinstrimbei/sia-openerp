package org.open.erp.ui.proman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;

@ManagedBean(name="formMenu")
@SessionScoped
public class FormMenu {
	private String formCurent;
	
	/* menu versiunea 1*/
	public void actionChangeForm(ActionEvent evt){
		String srcForm = evt.getComponent().getAttributes().get("srcForm").toString();
		System.out.println("V1: Action Change form request srcForm= " + srcForm);
		this.formCurent = srcForm;
		
		//javax.faces.application.ViewHandler
		//org.richfaces.application.GlobalResourcesViewHandler
	}
	
	public String changeFormCurent(){
		System.out.println("V2: Change form request: " + this.formCurent);
		return this.formCurent;
	}
	
	/* menu versiunea 2*/
	public void actionSrcChangeForm(ActionEvent evt){
		String srcForm = evt.getComponent().getAttributes().get("srcForm").toString();
		System.out.println("V2: Action Change form request srcForm= " + srcForm);
		this.formCurent = srcForm;
	}
	public String changeSrcFormCurent(){
		System.out.println("V2: Change form request: " + this.formCurent);
		return "menuv2/FormMenuV2";
	}
	public String getSrcCurentForm(){
		String urlForm = "/AppBanner.xhtml"; 
		if (this.formCurent != null)
			urlForm = "/" + this.formCurent + ".xhtml";
		System.out.println("V2/3: FINAL Curent Form Url: " + urlForm);
		return urlForm;
		
	}
	
	/* menu versiunea 3*/
	private Map<String, String> formulare = new HashMap<String, String>();
	public FormMenu(){
		formulare.put("Editare Proiecte", "FormProiecte");
		formulare.put("Editare Activitati", "FormProiecteActivitati");
		formulare.put("Editare Resposabili", "FormRsponsabili");
		formulare.put("Lista Proiecte", "RaportProiecte");		
	}
	public List<String> getFormulare() {
		System.out.println("V3: Get Formulare");
		List<String> formList = new ArrayList<String>();
		formList.addAll(this.formulare.keySet());
		return formList;
	}
	public void actionSrcGetForm(ActionEvent evt){
		UICommand uiComanda = (UICommand) evt.getComponent();
		System.out.println("V3: Generic Action Change form request: " + uiComanda.getValue());
		this.formCurent = this.formulare.get(uiComanda.getValue());
		System.out.println("V3: Generic Action Change form result: " + this.formCurent);		
	}	
	public String changeSrcGetForm(){
		System.out.println("V3: Change form request: " + this.formCurent);
		return "menuv3/FormMenuV3";
	}
	//public String getSrcCurentForm()

}

/*

<listener>
	<listener-class>com.sun.faces.config.ConfigureListener</listener-class>
	</listener>	

		<view-handler>
			org.richfaces.application.GlobalResourcesViewHandler
		</view-handler>
		
<h:inputText id="dataSfarsit" value="#{formProiecte.proiect.dataSfarsit}">
				<p:convertDateTime pattern="dd/MM/yyyy"/>
			</h:inputText>		
*/