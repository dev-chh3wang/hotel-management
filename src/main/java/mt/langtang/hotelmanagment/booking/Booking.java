package mt.langtang.hotelmanagment.booking;

import mt.langtang.hotelmanagment.BaseEntity;
import mt.langtang.hotelmanagment.customer.Customer;
import mt.langtang.hotelmanagment.staff.Staff;
import mt.langtang.hotelmanagment.room.Room;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {

    private String code;
    private LocalDate checkIn;
    private LocalDate checkOut;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    private Staff staff;
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
    private LocalDateTime timestamp;


    public Booking(LocalDate checkIn, LocalDate checkOut, Customer customer, Staff staff, Room room) {
        this.code = generateBookingCode(checkIn, customer);
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.customer = customer;
        this.staff = staff;
        this.room = room;
        this.room.setReserved(true);
        this.timestamp = LocalDateTime.now();
    }

    public static Booking create(LocalDate checkIn, LocalDate checkOut, Customer customer, Staff staff, Room room) {
        return new Booking(checkIn,checkOut,customer,staff,room);
    }

    private String generateBookingCode(LocalDate checkIn, Customer customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(customer.getFirstName().charAt(0)).append(customer.getLastName().charAt(0))
        .append(checkIn.getDayOfMonth()).append(checkIn.getMonthValue()).append(checkIn.getYear());
        return sb.toString().toUpperCase();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }


    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }



    @Override
    public String toString() {
        return "Booking{" +
                "code='" + code + '\'' +
                ", customer=" + customer +
                ", room=" + room +
                ", timestamp=" + timestamp +
                '}';
    }
}
