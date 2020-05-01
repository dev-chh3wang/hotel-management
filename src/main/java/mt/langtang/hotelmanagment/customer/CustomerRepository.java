package mt.langtang.hotelmanagment.customer;

import mt.langtang.hotelmanagment.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
