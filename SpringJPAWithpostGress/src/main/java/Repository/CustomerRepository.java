package Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import model.Customer;



@Repository
@Component
public interface CustomerRepository extends JpaRepository<Customer,String>{
	

}
