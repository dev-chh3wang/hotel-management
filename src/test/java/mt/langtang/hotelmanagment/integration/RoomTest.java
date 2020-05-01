package mt.langtang.hotelmanagment.integration;

import mt.langtang.hotelmanagment.room.Room;
import mt.langtang.hotelmanagment.room.RoomType;
import mt.langtang.hotelmanagment.room.RoomRepository;
import mt.langtang.hotelmanagment.room.RoomTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RoomTest extends AbstractIntegrationTest {


    @Autowired
    private RoomRepository repository;
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Test
    void testSaveRoom() {
        RoomType doubleRoomType = roomTypeRepository.save(new RoomType("Double", 2, 600));
        RoomType roomTypeD = roomTypeRepository.getOne(doubleRoomType.getId());
        Room room = new Room(roomTypeD);
        Room save = repository.save(room);
        assertFalse(save.isReserved());
        assertThat(save.getId(),is(room.getId()));
    }
}
