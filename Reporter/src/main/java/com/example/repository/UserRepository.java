package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.batchUser;

public interface UserRepository extends JpaRepository<batchUser,Integer>{

	void save(List<? extends batchUser> users);

}
