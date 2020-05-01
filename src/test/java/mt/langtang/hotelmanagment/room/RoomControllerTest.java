package mt.langtang.hotelmanagment.room;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = {RoomController.class})
@Import(RoomService.class)
class RoomControllerTest {
    
    @Autowired
    private WebTestClient webClient;

    @MockBean
    private RoomService service;


    @Test
    void create() {

        Room room = new Room(RoomType.DOUBLE);
        webClient.post().uri("/create")
                .body(BodyInserters.fromValue(room))
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isCreated();
    }


    @Test
    void getRoomById() throws RoomNotFoundException {
        Room room = new Room(RoomType.DOUBLE);
        room.setId(1l);
        room.setReserved(true);
        room.setPrice(400);
        when(service.getRoom(1l)).thenReturn(room);
        webClient.get().uri("/{id}", 1)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(1l)
                .jsonPath("$.reserved").isEqualTo(true)
                .jsonPath("$.price").isNotEmpty()
                .jsonPath("$.type").isNotEmpty();
    }
}