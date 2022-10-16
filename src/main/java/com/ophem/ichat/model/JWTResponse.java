package com.ophem.ichat.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class JWTResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7145834769261745706L;
	
	private String JWTToken;
}
