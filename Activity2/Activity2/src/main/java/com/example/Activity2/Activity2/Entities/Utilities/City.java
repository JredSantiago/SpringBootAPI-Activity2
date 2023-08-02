package com.example.Activity2.Activity2.Entities.Utilities;

import com.example.Activity2.Activity2.Entities.Employee_Address;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table
public class City {
    @Id
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "city_sequence"
    )

    private Long city_id;
    private String city_code;
    private String city_name ;

    @OneToMany(mappedBy = "city", cascade = CascadeType.MERGE)
    private Set<Employee_Address> employeeAddress;

    public City(String code, String name) {
        this.city_code = code;
        this.city_name = name;
    }

    public City() {
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    @Override
    public String toString() {
        return "City{" +
                "city_id=" + city_id +
                ", city_code='" + city_code + '\'' +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
