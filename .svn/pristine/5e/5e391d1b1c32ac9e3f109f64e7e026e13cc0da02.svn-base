package com.tce.core.model.authz;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class OrgTmplt {

	@Getter @Setter
	private String version;
	
	@Getter @Setter
	private Organization organization;
	
	@Getter @Setter
	private List<RoleTmplt> roleList;
	
	@Getter @Setter
	private List<PermissionTmplt> permList;
	
	@ToString
	static public class RoleTmplt {

		@Getter @Setter
		private String name;
		
		@Getter @Setter
		private String description;
		
		@Getter @Setter
		private String type;
		
		@Getter @Setter
		private Map<String, String> properties;
	}
	
	@ToString
	static public class PermissionTmplt {
		
		@Getter @Setter
		private String[] privilege;

		@Getter @Setter
		private String context;
		
		@Getter @Setter
		private List<RoleTmplt> roles;
		
		@Getter @Setter
		private Map<String, String> properties;
		
		@Getter @Setter
		private String pageOrder;	
		
	}
}
