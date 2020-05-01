package mt.langtang.hotelmanagment.integration;

import mt.langtang.hotelmanagment.staff.Staff;
import mt.langtang.hotelmanagment.staff.StaffRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StaffTest extends AbstractIntegrationTest{


    @Autowired
    private StaffRepository repository;

    @Test
    void saveStaff() {
        Staff save = repository.save(new Staff("Jakie", "JKL"));

        Optional<Staff> staff = repository.findById(save.getId());
        assertTrue(staff.isPresent());
        assertThat(staff.get().getCode(),is(save.getCode()));
        assertThat(staff.get().getName(),is(save.getName()));
    }
}
