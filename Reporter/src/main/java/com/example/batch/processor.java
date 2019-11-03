package com.example.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

import com.example.model.batchUser;

public class processor implements ItemProcessor<batchUser,batchUser> {
	
	private static final Map<String,String> FIRSTNAME=new HashMap<String,String>();
	
	public processor() {
		FIRSTNAME.put("101", "shreeya");
		FIRSTNAME.put("102", "pravina");
		FIRSTNAME.put("103", "apurva");
	}

	@Override
	public batchUser process(batchUser user) throws Exception {
		String firstName=user.getFirstName();
		String firstname=FIRSTNAME.get(firstName);
		user.setFirstName(firstname);
		System.out.println(String.format("Converted form [%s] to [%s]", firstName,firstname));
		return user;
	}

}
