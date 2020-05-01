package mt.langtang.hotelmanagment.room;

import mt.langtang.hotelmanagment.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "room_types")
public class RoomType extends BaseEntity {

    public static final RoomType SINGLE = new RoomType("single",1,200);
    public static final RoomType DOUBLE = new RoomType("double", 2, 300);

    private String type;
    private int noOfBed = -1;
    private double pricePerNight = 0d;

    RoomType() {
    }

    public RoomType(String type, int noOfBed, double basePrice) {
        this.type = type;
        this.noOfBed = noOfBed;
        this.pricePerNight = basePrice;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setBasePricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNoOfBed() {
        return noOfBed;
    }

    public void setNoOfBed(int noOfBed) {
        this.noOfBed = noOfBed;
    }
}
