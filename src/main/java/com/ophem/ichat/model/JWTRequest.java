package com.ophem.ichat.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class JWTRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -936727925706277624L;
	
	private String username, password;
}
