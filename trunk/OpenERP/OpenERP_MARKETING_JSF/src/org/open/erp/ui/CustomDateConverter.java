package org.open.erp.ui;

import java.util.TimeZone;

import javax.faces.convert.DateTimeConverter;

public class CustomDateConverter extends DateTimeConverter {

public CustomDateConverter() {
 super();
 this.setTimeZone(TimeZone.getDefault());
 // here you can set your custom date pattern for your project
  this.setPattern("MM/dd/yyyy");
 }

}