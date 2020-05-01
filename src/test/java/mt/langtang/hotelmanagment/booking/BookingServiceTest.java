package mt.langtang.hotelmanagment.booking;

import mt.langtang.hotelmanagment.customer.Customer;
import mt.langtang.hotelmanagment.staff.*;
import mt.langtang.hotelmanagment.room.Room;
import mt.langtang.hotelmanagment.room.RoomType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class BookingServiceTest {



    @Mock
    BookingRepository repository;
    @InjectMocks
    BookingService bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldCreateBooking() {

        Customer customer = new Customer("John","doe","Spain","8878","st.paul","90909");
        Staff staff = new Staff("Jackie","JA");
        Room room = new Room(RoomType.DOUBLE);
        Booking booking = new Booking(LocalDate.now(), LocalDate.now().plusDays(2), customer, staff, room);
        bookingService.save(booking);
        verify(repository,times(1)).save(booking);
    }

}