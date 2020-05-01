package mt.langtang.hotelmanagment.jpa;

import mt.langtang.hotelmanagment.room.Room;
import mt.langtang.hotelmanagment.room.RoomType;
import mt.langtang.hotelmanagment.room.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@DataJpaTest
public class RoomJpaTest {


    @Autowired
    RoomRepository repository;

    @Autowired
    TestEntityManager entityManager;
    @Test
    void testCreateRoom() {
        RoomType roomType = new RoomType("single",1,400);
        entityManager.persist(roomType);
        entityManager.flush();
        Room room = Room.of(roomType);
        room.setReserved(true);
        entityManager.persist(room);
        entityManager.flush();

        Long insertedId = entityManager.getId(room,Long.class);
        Optional<Room> result = repository.findById(insertedId);
        assertTrue(result.isPresent());
        assertThat(result.get().getType(),is(roomType));

    }
}
