package mt.langtang.hotelmanagment.room;

import mt.langtang.hotelmanagment.exceptions.HotelAppException;

public class RoomNotFoundException extends HotelAppException {
    public RoomNotFoundException(String s) {
        super(s);
    }
}
