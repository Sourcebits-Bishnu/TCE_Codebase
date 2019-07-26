package com.tce.core.model.authz;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class PrivilegeTmplt {

	@Getter @Setter
	private String version;
	
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private List<ContextTmplt> ctxlist;
	
	

	@ToString
	static public class ContextTmplt {

		@Getter @Setter
		private Long id;
		
		@Getter @Setter
		private String name;
		
		@Getter @Setter
		private String description;
		
		@Getter @Setter
		private List<Privilege> privlist;

		public Context convert() {
			Context h = new Context();
			h.setCtxId(this.id);
			h.setName(this.name);
			
			return h;
		}
	}
}
