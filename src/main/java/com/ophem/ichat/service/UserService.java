package com.ophem.ichat.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.ophem.ichat.model.UserModel;

public interface UserService extends UserDetailsService{

	UserModel createUser(UserModel userModel);
	
}
