package com.tce.common.model;

public class SystemConstants {
	
	public static final String CHAR_SET = "UTF-8";
	
	public static final  String LIKE_FORMAT = "%%%1s%%";
	
	public static final  String CLASSEDGE_V1_ENCRYPTION_KEY = "!ni@EDUCti0nDGE@";
	public static final  String CLASSEDGE_V2_ENCRYPTION_KEY = "!nDi@EDUC@ti0nE@";
	
	public static enum Status {
		INACTIVE("inactive",0),ACTIVE("active",1),
		HIDE("hide",0),SHOW("show",1),
		FALSE("FALSE",0),TRUE("TRUE",1),
		FAILURE("failure",0),SUCCESS("success",1);
		
		private String text;
		private int value;
		
		private Status(String text,int value) {
			this.text = text;
			this.value = value;
		}
		
		public int value(){
			return this.value;
		}
		
		public String text(){
			return this.text;
		}
		
		public boolean equalsText(String mode){
			if(text.equals(mode)){
				return true;
			}

			return false;
		}
	}

	public static final class DEFAULT_ORG {
		
		public static final String NAME = "ClassEdge";
		public static final String ID = "classedge-in";
		
		private DEFAULT_ORG() {}
	}
	
	private SystemConstants() {}
}
