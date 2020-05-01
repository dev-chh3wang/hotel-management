package mt.langtang.hotelmanagment.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController("/v1/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping(value =
            "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Room room){
        roomService.save(room);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<Room>> get(@PathVariable Long id){
        try {
            return new ResponseEntity(Mono.just(roomService.getRoom(id)),HttpStatus.OK);
        } catch (RoomNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
