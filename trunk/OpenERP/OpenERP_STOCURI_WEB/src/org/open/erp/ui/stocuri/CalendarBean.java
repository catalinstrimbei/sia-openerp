package org.open.erp.ui.stocuri;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




@ManagedBean(name="calendarBean")
@SessionScoped
public class CalendarBean {

	public Date getDataCurenta(){
		return new Date();
	}
}
