package mt.langtang.hotelmanagment.integration;

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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class BookingTest{


    @Autowired
    private BookingRepository repository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testBooking() {
        Customer janeDoe = new Customer("Jane","Doe","NPL","6766","Local str","8777");

        Staff jackie = new Staff("jackie","JKI");
        RoomType doubleRm = RoomType.DOUBLE;
        Room singleRoom = new Room(doubleRm);
        entityManager.persist(singleRoom);
        entityManager.persist(doubleRm);
        entityManager.persist(jackie);
        entityManager.persist(janeDoe);
        entityManager.flush();

        Booking booking = new Booking(LocalDate.now(), LocalDate.now().plusDays(2), janeDoe, jackie, singleRoom);
        Booking saved = repository.save(booking);
        Optional<Booking> result = repository.findById(booking.getId());
        assertTrue(result.isPresent());
        assertThat(result.get().getCode(),is(booking.getCode()));
        assertThat(result.get().getCustomer(),is(janeDoe));
        assertThat(result.get().getRoom(),is(singleRoom));
        assertThat(result.get().getStaff(),is(jackie));
        assertTrue(singleRoom.isReserved());
    }
}
