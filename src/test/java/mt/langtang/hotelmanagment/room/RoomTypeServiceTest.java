package mt.langtang.hotelmanagment.room;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;


class RoomTypeServiceTest {


    @InjectMocks
    RoomTypeService roomTypeService;

    @Mock
    RoomTypeRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldSave() {
        RoomType roomType = mock(RoomType.class);
        roomTypeService.save(roomType);
        Mockito.verify(repository,times(1)).save(roomType);
    }

    @Test
    void shouldGetAll() {
        List<RoomType> roomTypeList = mock(ArrayList.class);
        when(roomTypeList.size()).thenReturn(2);
        when(repository.findAll()).thenReturn(roomTypeList);
        List<RoomType> roomTypes =roomTypeService.getAll();
        Mockito.verify(repository,times(1)).findAll();
        assertThat(roomTypes.size(),is(roomTypeList.size()));
    }
}