package com.ophem.ichat.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ophem.ichat.entity.RoleEntity;
import com.ophem.ichat.entity.UserEntity;
import com.ophem.ichat.model.UserModel;
import com.ophem.ichat.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;
	
	@Mock
	RoleEntity role;
	
//	@BeforeEach
//	public void setUp() {
//		System.out.println("inside the setup method");
//		
//		userServiceImpl = new UserServiceImpl();
//		userServiceImpl.setUserRepository(userRepository);
//		
//	}

	@Test
	void testLoadUserByUsername() {

		System.out.println("not yet tested");
	}

	@Test
	void testCreateUser() {
		System.out.println("inside the testCreateUser method");
		
		UserModel user = new UserModel("james", "jayhmz", "j@mail.com", "1234");
		
		UserModel createUser = userServiceImpl.createUser(user);
		
		assertNotNull(createUser);
		
	}
	@Test
	void testCreateUser_WithNullParamValue() {
		
		UserModel user = new UserModel("james", "jayhmz", "j@mail.com", "1234");
		
		UserEntity entity = null;
		
//		when(userRepository.save(entity)).thenReturn(null);
		
		assertNull(userRepository.save(entity));
	}

}
