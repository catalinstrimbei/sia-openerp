package org.app.forms;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class TestBean implements Serializable{
	public String getTestMessage(){
		return "Google JSF Started!";
	}
}
