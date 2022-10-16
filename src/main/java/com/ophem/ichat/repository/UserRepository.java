package com.ophem.ichat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ophem.ichat.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findUserByUsername(String username);
}
