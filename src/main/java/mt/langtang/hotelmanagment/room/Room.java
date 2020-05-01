package mt.langtang.hotelmanagment.room;

import mt.langtang.hotelmanagment.BaseEntity;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name ="rooms")
@DynamicUpdate
public class Room extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private RoomType type;

    private boolean reserved = false;

    @Transient
    private final Object lock = new Object();


    public Room() {
    }

    public Room(RoomType roomType) {
        this.type = roomType;
    }


    public static Room of(RoomType roomType) {
        return new Room(roomType);
    }


    public double getPrice() {
        return type.getPricePerNight();
    }

    public void setPrice(double price) {
        type.setBasePricePerNight(price);
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        synchronized (lock){
            this.reserved = reserved;
        }
    }
}
