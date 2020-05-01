package mt.langtang.hotelmanagment.room;

import mt.langtang.hotelmanagment.room.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {

}
