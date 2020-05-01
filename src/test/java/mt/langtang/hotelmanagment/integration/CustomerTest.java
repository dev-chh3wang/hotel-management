package mt.langtang.hotelmanagment.integration;

import mt.langtang.hotelmanagment.customer.Customer;
import mt.langtang.hotelmanagment.customer.CustomerRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CustomerTest extends AbstractIntegrationTest{

    private CustomerRepository repository;

    @Test
    void testSave() {
        Customer savedCustomer = repository.save(new Customer("Jane", "Doe", "NPL", "8878", "JK 56", "887837"));

        Optional<Customer> result = repository.findById(savedCustomer.getId());
        assertThat(result.get().getId(),is(savedCustomer.getId()));
        assertThat(result.get().getFirstName(),is(savedCustomer.getFirstName()));
        assertThat(result.get().getLastName(),is(savedCustomer.getLastName()));
        assertThat(result.get().getCountry(),is(savedCustomer.getCountry()));
        assertThat(result.get().getZip(),is(savedCustomer.getZip()));
        assertThat(result.get().getStreet(),is(savedCustomer.getStreet()));
        assertThat(result.get().getPassportNo(),is(savedCustomer.getPassportNo()));
    }
}
