package com.example.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.batchUser;
import com.example.repository.UserRepository;

@Component
public class DBWriter implements ItemWriter<batchUser>{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void write(List<? extends batchUser> users) throws Exception {
		
		System.out.println("Data saved for  users: "+users);
		userRepository.save(users);
	}

}
