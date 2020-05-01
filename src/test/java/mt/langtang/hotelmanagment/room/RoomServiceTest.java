package mt.langtang.hotelmanagment.room;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class RoomServiceTest {


    @InjectMocks
    RoomService roomService;
    @Mock
    RoomRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldSave() {
        Room room = mock(Room.class);
        roomService.save(room);
        Mockito.verify(repository,times(1)).save(room);
        verifyNoMoreInteractions(repository);
    }
    @Test
    void shouldGet() throws RoomNotFoundException {
        Room room = mock(Room.class);
        room.setId(1l);
        when(repository.findById(1l)).thenReturn(Optional.of(room));
        Room result = roomService.getRoom(1);
        assertThat(result,is(room));
        Mockito.verify(repository,times(1)).findById(1l);
        verifyNoMoreInteractions(repository);
    }

    @Test
    void shouldGetAll() {
        List<Room> rooms = mock(List.class);
        when(rooms.size()).thenReturn(2);
        when(repository.findAll()).thenReturn(rooms);

        List<Room> result =roomService.findAll();
        assertThat(result.size(),is(rooms.size()));
        assertThat(result,is(rooms));
        Mockito.verify(repository,times(1)).findAll();
        verifyNoMoreInteractions(repository);
    }
}