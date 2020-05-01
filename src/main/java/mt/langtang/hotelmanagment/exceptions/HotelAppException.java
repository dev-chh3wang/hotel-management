package mt.langtang.hotelmanagment.exceptions;

public class HotelAppException extends Throwable{

    public HotelAppException() {
    }

    public HotelAppException(String message) {
        super(message);
    }

    public HotelAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public HotelAppException(Throwable cause) {
        super(cause);
    }

    public HotelAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
