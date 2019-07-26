package com.tce.common.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateFormats {
	/** format : dd-MM-yyyy */
	TYPE1_DATE("dd-MM-yyyy"),
	/** format : dd-MM-yyyy HH:mm:ss */
	TYPE2_DATE("dd-MM-yyyy HH:mm:ss");
	
	private String value;
	
	private DateFormats(String value){
		this.value = value;
	}
	
	public String value(){
		return this.value;
	}
	
	public Date parse(String datevalue) throws ParseException{
		DateFormat parser = new SimpleDateFormat(this.value);
		return parser.parse(datevalue);
	}
	
	public String format(Date datevalue){
		DateFormat parser = new SimpleDateFormat(this.value);
		return parser.format(datevalue);
	}
	
	public String now(){		
		return format(new Date());
	}
	
	public DateFormat getParser(){
		return new SimpleDateFormat(this.value);
	}
}
