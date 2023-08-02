package com.example.Activity2.Activity2.Entities.Utilities;

import com.example.Activity2.Activity2.Entities.Employee;
import com.example.Activity2.Activity2.Entities.Employee_Address;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table
public class Country {
    @Id
    @SequenceGenerator(
            name = "country_sequence",
            sequenceName = "country_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "country_sequence"
    )

    private Long country_id;
    private String country_code;
    private String country_name ;

    @OneToMany(mappedBy = "country", cascade = CascadeType.MERGE)
    private Set<Employee_Address> employeeAddress;

    public Country(String code, String name) {
        this.country_code = code;
        this.country_name = name;
    }

    public Country() {

    }

    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }


    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + country_id +
                ", country_code='" + country_code + '\'' +
                ", country_name='" + country_name + '\'' +
                '}';
    }
}
