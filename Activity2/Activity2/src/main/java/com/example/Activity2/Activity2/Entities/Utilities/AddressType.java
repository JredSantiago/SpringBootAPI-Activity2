package com.example.Activity2.Activity2.Entities.Utilities;

import com.example.Activity2.Activity2.Entities.Employee;
import com.example.Activity2.Activity2.Entities.Employee_Address;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table
public class AddressType {
    @Id
    @SequenceGenerator(
            name = "address_type_sequence",
            sequenceName = "address_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_type_sequence"
    )

    private Long add_type_id;
    private String type;

    @OneToMany(mappedBy = "addressType", cascade = CascadeType.MERGE)
    private Set<Employee_Address> employeeAddress;


    public AddressType() {
    }

    public AddressType(String type) {
        this.type = type;
    }

    public Long getAdd_type_id() {
        return add_type_id;
    }

    public void setAdd_type_id(Long add_type_id) {
        this.add_type_id = add_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "add_type_id=" + add_type_id +
                ", type='" + type + '\'' +
                '}';
    }
}
