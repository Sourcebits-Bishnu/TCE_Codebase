package com.tce.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class PageResponse {
	
	@Getter @Setter
	int draw;
	
	@Getter @Setter
	int recordsTotal;

	@Getter @Setter
	int recordsFiltered;
	
	@Getter @Setter
	Object data;
		
}
