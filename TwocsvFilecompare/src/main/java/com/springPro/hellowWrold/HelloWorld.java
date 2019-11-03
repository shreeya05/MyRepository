package com.springPro.hellowWrold;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RmsCompare.fileReader;

@RestController
public class HelloWorld {
	
	/*
	 * @Autowired fileReader reader;
	 */

	@RequestMapping("/")
	public String index() {
		fileReader reader=new fileReader();
		return reader.rmsCompare();
	}
}
