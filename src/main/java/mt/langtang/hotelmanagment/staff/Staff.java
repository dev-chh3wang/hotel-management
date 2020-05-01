package mt.langtang.hotelmanagment.staff;

import mt.langtang.hotelmanagment.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "staffs")
public class Staff extends BaseEntity {
    private final String name;
    private final String code;


    Staff(){
        name="";
        code="";
    };

    public Staff(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
