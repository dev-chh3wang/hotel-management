package mt.langtang.hotelmanagment;

import mt.langtang.hotelmanagment.room.Room;
import mt.langtang.hotelmanagment.room.RoomType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class RoomJpaRepositoryTest {


    @Test
    void testCreate() {
        Room singleRoom = Room.of(RoomType.SINGLE);
    }
}