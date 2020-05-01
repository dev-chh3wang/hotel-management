package mt.langtang.hotelmanagment.room;

import java.util.List;

public class RoomTypeService {

    RoomTypeRepository repository;


    public void save(RoomType roomType) {
        repository.save(roomType);
    }

    public List<RoomType> getAll() {
        return repository.findAll();
    }
}
