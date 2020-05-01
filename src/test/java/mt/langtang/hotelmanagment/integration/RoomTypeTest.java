package mt.langtang.hotelmanagment.integration;

import mt.langtang.hotelmanagment.room.RoomType;
import mt.langtang.hotelmanagment.room.RoomTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Optional;

public class RoomTypeTest extends AbstractIntegrationTest{


    @Autowired
    private RoomTypeRepository repository;

    @Test
    void saveAndFetchTest() {
        RoomType doubleBed = repository.save(new RoomType("DoubleBed", 2, 300));
        repository.save(new RoomType("DoubleBed1", 2, 300));
        Optional<RoomType> result = repository.findById(doubleBed.getId());
        assertTrue(result.isPresent());
        assertThat(result.get().getPricePerNight(),is(300d));
        List<RoomType> all = repository.findAll();
    }
}
