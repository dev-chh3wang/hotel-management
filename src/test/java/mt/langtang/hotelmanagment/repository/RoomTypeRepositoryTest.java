package mt.langtang.hotelmanagment.repository;

import mt.langtang.hotelmanagment.room.RoomType;
import mt.langtang.hotelmanagment.room.RoomTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class RoomTypeRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    RoomTypeRepository repository;

    @Test
    void testCreate() {
        RoomType single = new RoomType("Suit",4,1500);
        entityManager.persist(single);
        entityManager.flush();
        Long id = (Long) entityManager.getId(single);
        Optional<RoomType> roomType = repository.findById(id);
        assertTrue(roomType.isPresent());
        assertThat(roomType.get().getType(),is("Suit"));
    }


}