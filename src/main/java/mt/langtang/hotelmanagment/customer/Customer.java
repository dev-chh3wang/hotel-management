package mt.langtang.hotelmanagment.customer;

import mt.langtang.hotelmanagment.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {


    private String firstName;
    private String lastName;
    private String country;
    private String zip;
    private String street;
    private String passportNo;


    Customer() {
    }

    public Customer(String firstName, String lastName, String country, String zip, String street, String passportNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.zip = zip;
        this.street = street;
        this.passportNo = passportNo;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
}
