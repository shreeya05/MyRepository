package Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import Repository.CustomerRepository;
import model.Customer;



@Service
public class CustomerServices {

	@Autowired
	CustomerRepository customerrepository;

	public Optional<Customer> fetchData(String id) {
		return customerrepository.findById(id);
	}

	public List<Customer> fetchAllData() {
		return customerrepository.findAll();
	}

	
	public Customer createEntry(Customer customer) {
		String result = "customer is empty...";
		if (customer != null) {
			customerrepository.save(customer);
			result = "Create successfully............";
		}
		return customerrepository.getOne(customer.getCustomerid());
	}

	public String updateEntry(Customer customer, String id) {
		String result = "Customer is empty....";
		List<Customer> customerList = customerrepository.findAll();
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getCustomerid().equals(id)) {
				customerrepository.delete(customerList.get(i));
				customerrepository.save(customer);
				result = "Update suceessfully....";
			} else {
				customerrepository.save(customer);
				result = "New entry create suceessfully....";
			}
		}

		return result;
	}

	public String deleteEntry(String id) {
		
		customerrepository.deleteById(id);

		String result = "delete suceessfully....";

		return result;
	}


}

