package org.open.erp.ui;

/*
<rich:calendar value="#{calendarBean.selectedDate}"
                       locale="#{calendarBean.locale}"
                       popup="#{calendarBean.popup}"
                       datePattern="#{calendarBean.pattern}"                      
                       cellWidth="24px" cellHeight="22px" style="width:200px"/>


	<listener>
		<listener-class>org.apache.myfaces.webapp.StartupServletContextListener</listener-class>
	</listener>
	
	
	<!-- Rich Faces Config -->
	<context-param>
		<param-name>org.richfaces.SKIN</param-name>
		<param-value>classic</param-value>
	</context-param>
	<context-param>
		<param-name>org.ajax4jsf.VIEW_HANDLERS</param-name>
		<param-value>com.sun.facelets.FaceletViewHandler</param-value>
	</context-param>
	<filter>
		<display-name>RichFaces Filter</display-name>
		<filter-name>richfaces</filter-name>
		<filter-class>org.ajax4jsf.Filter</filter-class>
	</filter>
	<filter-mapping>
		<filter-name>richfaces</filter-name>
		<servlet-name>Faces Servlet</servlet-name>
		<dispatcher>REQUEST</dispatcher>
		<dispatcher>FORWARD</dispatcher>
		<dispatcher>INCLUDE</dispatcher>
	</filter-mapping>	

*/

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.open.erp.services.nomgen.NomenclatoareSrv;
import org.open.erp.services.nomgen.Partener;

@ManagedBean(name="calendarBean")
@SessionScoped
public class CalendarBean {

	private List<Partener> parteneri;
	private Partener partener;
	
	@EJB(name="NomenclatoareSrv", mappedName="NomenclatoareSrv")
	private NomenclatoareSrv nomgenInstance;
	// Referinta EJB injectata este disponibila numai abia
	//in handlerul PostConstruct, si nu la nivelul constructorului
	@SuppressWarnings("unchecked")
	@PostConstruct
	private void initForm() throws Exception{
	this.parteneri = (List<Partener>) nomgenInstance.getPartener();
	if (!parteneri.isEmpty())
	this.partener = (Partener) parteneri.get(0);
	else{
	System.out.println("No project available!");
	this.partener =  new Partener();
	 partener.setId(1000);
	}
	}
	
	
	
	
   private static final String[] WEEK_DAY_LABELS = new String[] { "Sun *",
           "Mon +", "Tue +", "Wed +", "Thu +", "Fri +", "Sat *" };
   private Locale locale;

   private boolean popup;
   private boolean readonly;
   private boolean showInput;
   private boolean enableManualInput;    
   private String pattern;
   private Date currentDate;
   private Date selectedDate;
   private String jointPoint;
   private String direction;
   private String boundary;

   private boolean useCustomDayLabels;

   
   
   
   
   
 
public List<Partener> getParteneri() {
	return parteneri;
}

public void setParteneri(List<Partener> parteneri) {
	this.parteneri = parteneri;
}

public Partener getPartener() {
	return partener;
}

public void setPartener(Partener partener) {
	this.partener = partener;
}

public Locale getLocale() {
       return locale;
   }

   public void setLocale(Locale locale) {
       this.locale = locale;
   }

   public boolean isPopup() {
       return popup;
   }

   public void setPopup(boolean popup) {
       this.popup = popup;
   }

   public String getPattern() {
       return pattern;
   }

   public void setPattern(String pattern) {
       this.pattern = pattern;
   }

   public CalendarBean() {

       locale = Locale.US;
       popup = true;
       pattern = "MMM d, yyyy";
       jointPoint = "bottomleft";
       direction = "bottomright";
       readonly = true;
       enableManualInput=false;
       showInput=true;
       boundary = "inactive";
   }
   
   
   public boolean isShowInput() {
       return showInput;
   }

   public void setShowInput(boolean showInput) {
       this.showInput = showInput;
   }

   public boolean isEnableManualInput() {
       return enableManualInput;
   }

   public void setEnableManualInput(boolean enableManualInput) {
       this.enableManualInput = enableManualInput;
   }

   public boolean isReadonly() {
       return readonly;
   }

   public void setReadonly(boolean readonly) {
       this.readonly = readonly;
   }

   public void selectLocale(ValueChangeEvent event) {

       String tLocale = (String) event.getNewValue();
       if (tLocale != null) {
           String lang = tLocale.substring(0, 2);
           String country = tLocale.substring(3);
           locale = new Locale(lang, country, "");
       }
   }

   public boolean isUseCustomDayLabels() {
       return useCustomDayLabels;
   }

   public void setUseCustomDayLabels(boolean useCustomDayLabels) {
       this.useCustomDayLabels = useCustomDayLabels;
   }

   public Object getWeekDayLabelsShort() {
       if (isUseCustomDayLabels()) {
           return WEEK_DAY_LABELS;
       } else {
           return null;
       }
   }

   public String getCurrentDateAsText() {
       Date currentDate = getCurrentDate();
       if (currentDate != null) {
           return DateFormat.getDateInstance(DateFormat.FULL).format(
                   currentDate);
       }

       return null;
   }

   public Date getCurrentDate() {
       return currentDate;
   }

   public void setCurrentDate(Date currentDate) {
       this.currentDate = currentDate;
   }

   public Date getSelectedDate() {
       return selectedDate;
   }

   public void setSelectedDate(Date selectedDate) {
       this.selectedDate = selectedDate;
   }

   public String getJointPoint() {
       return jointPoint;
   }

   public void setJointPoint(String jointPoint) {
       this.jointPoint = jointPoint;
   }

   public void selectJointPoint(ValueChangeEvent event) {
       jointPoint = (String) event.getNewValue();
   }

   public String getDirection() {
       return direction;
   }

   public void setDirection(String direction) {
       this.direction = direction;
   }

   public void selectDirection(ValueChangeEvent event) {
       direction = (String) event.getNewValue();
   }

   public String getBoundary() {
       return boundary;
   }

   public void setBoundary(String boundary) {
       this.boundary = boundary;
   }

}