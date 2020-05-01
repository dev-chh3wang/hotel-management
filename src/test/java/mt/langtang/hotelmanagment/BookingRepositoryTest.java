package mt.langtang.hotelmanagment;

import mt.langtang.hotelmanagment.booking.Booking;
import mt.langtang.hotelmanagment.booking.BookingRepository;
import mt.langtang.hotelmanagment.customer.Customer;
import mt.langtang.hotelmanagment.staff.*;
import mt.langtang.hotelmanagment.room.Room;
import mt.langtang.hotelmanagment.room.RoomType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@DataJpaTest
class BookingRepositoryTest {


    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    TestEntityManager entityManager;
    @Test
    void testCreate() {

        LocalDate checkin = LocalDate.now();
        LocalDate checkout = checkin.plusDays(2);
        Customer customer = new Customer("Reiner","Stein","Germany","7666","Adler str","77777");
        entityManager.persist(customer);
        Staff staff = new Staff("Jack","J887");
        entityManager.persist(staff);
        RoomType single = RoomType.SINGLE;
        entityManager.persist(single);
        Room room = Room.of(single);
        entityManager.persist(room);

        entityManager.flush();

        assertFalse(room.isReserved());
        Booking booking = Booking.create(checkin,checkout,customer,staff,room);

        entityManager.persist(booking);

        entityManager.flush();

        Optional<Booking> result = bookingRepository.findByCode(booking.getCode());

        assertTrue(result.isPresent());
        assertThat(result.get().getCode(),is(booking.getCode()));
        assertThat(result.get().getRoom().getId(),is(room.getId()));
        assertTrue(result.get().getRoom().isReserved());
        assertThat(result.get().getCheckIn(),is(checkin));
    }
}