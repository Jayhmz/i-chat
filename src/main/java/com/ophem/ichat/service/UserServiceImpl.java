package com.ophem.ichat.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ophem.ichat.entity.RoleEntity;
import com.ophem.ichat.entity.UserEntity;
import com.ophem.ichat.model.UserModel;
import com.ophem.ichat.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity userEntity = userRepository.findUserByUsername(username);
		
		if(userEntity == null) {
			throw new UsernameNotFoundException("INCORRECT USER DETAILS");
		}
		
		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority role = new SimpleGrantedAuthority(userEntity.getRole().toString());
		roles.add(role);
		
		return new User(userEntity.getUsername(), userEntity.getPassword(), roles);
	}

	@Override
	public UserModel createUser(UserModel user) {
		
		UserEntity entity = new UserEntity(user.getName(), user.getUsername(),
				user.getEmail(), user.getPassword(), Arrays.asList(new RoleEntity("ROLE_USER")));
		
		 if (entity != null) {
			userRepository.save(entity);
			return user;
		}
		 
		return null;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	
}
