package com.tce.core.model.sso;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CEAuthority  implements GrantedAuthority {

	private static final long serialVersionUID = -4143938881340122045L;

	@Getter @Setter
	private Long ctxId;
	
	@Getter @Setter
	private int bitsum;
	
	@Override
	@JsonIgnore
	public String getAuthority() {
		return String.valueOf(ctxId);
	}

	public boolean hasPermission(Integer privilegeBit) {
		if ( (bitsum & privilegeBit) == privilegeBit) {
			return true;
		}
		return false;
	}
	
	public boolean equals(Long toCompare) {
		return ctxId.equals(toCompare);
	}

}
