package mt.langtang.hotelmanagment.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository repository;

    public void save(Room room){
        repository.save(room);
    }

    public Room getRoom(long id) throws RoomNotFoundException {
        Optional<Room> room = repository.findById(id);
        if(room.isPresent()){
             return room.get();
        }
        throw new RoomNotFoundException("Room not found with ID : "+id);
    }

    public List<Room> findAll() {
        return repository.findAll();
    }
}
