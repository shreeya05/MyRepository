package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Services.CustomerServices;
import model.Customer;



@RestController
@RequestMapping("/customer")
public class MainController {


	@Autowired
	CustomerServices service;

	@GetMapping(value = "/fetch")
	public List<Customer> fetchEntry(Model model) {
		List<Customer> customers = service.fetchAllData();
		model.addAttribute("customer", customers);
		return customers;
	}

	@RequestMapping("/entry")
	public String entery(Model model) {
		Customer c1 = new Customer();
		c1.setCustomerid("102");
		c1.setFirstname("Shreeya");
		c1.setLastname("Bhosale");

		// String message=service.createEntry(c1);
		model.addAttribute("customer", c1);
		return "Display";
	}

	@PostMapping(value = "/load")
	public Customer load(@RequestBody final Customer customer) {

		return service.createEntry(customer);
	}
	



}
