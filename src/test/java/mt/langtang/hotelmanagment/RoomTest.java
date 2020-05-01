package mt.langtang.hotelmanagment;

import mt.langtang.hotelmanagment.room.Room;
import mt.langtang.hotelmanagment.room.RoomType;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomTest {


    @Test
    void createRoomTest() {
        Room room = Room.of(RoomType.SINGLE);
        assertThat(room.getPrice(),is(200d));
        assertThat(room.getType(),is(RoomType.SINGLE));
        assertFalse(room.isReserved());
        Room doubleRoom = Room.of(RoomType.DOUBLE);
        doubleRoom.setReserved(true);
        assertThat(doubleRoom.getType(),is(RoomType.DOUBLE));
        assertTrue(doubleRoom.isReserved());

    }


}