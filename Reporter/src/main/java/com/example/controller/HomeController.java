package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.model.csvReader;
import com.example.model.person;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Controller
public class HomeController {
	
	Iterator<User> userIterator;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model) {
		csvReader reader=new csvReader();
		try {
			userIterator=reader.responseGenerator("C:\\Users\\Shreeya\\Downloads\\tsvfolder\\UserTsv.tsv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		ArrayList<User> userList = null;
		User user;
		userList=new ArrayList<User>();
		while(userIterator.hasNext()) {
			int count=0;
			Map<String,User> mapUser=new HashMap<>();
			
			user=userIterator.next();
			if(user.getName().equalsIgnoreCase("Shreeya")) {
				user.setStatus("pass");
			}
			userList.add(user);
			
			
			 
			
		}
		model.addAttribute("User", userList);
		return "user-data";
	}

}
