package com.tce.core.model.authz;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Menu {
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private String url;
	
	@Getter @Setter
	private Permission permission;
	
	@Getter @Setter
	private List<Menu> submenu;
	
	@ToString
	static public class Permission {
		
		@Getter @Setter
		private String context;
		
		@Getter @Setter
		private String privilege;
	}
	
}
