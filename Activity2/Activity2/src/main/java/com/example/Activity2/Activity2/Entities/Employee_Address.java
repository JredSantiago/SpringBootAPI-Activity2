package com.example.Activity2.Activity2.Entities;

import com.example.Activity2.Activity2.Entities.Utilities.AddressType;
import com.example.Activity2.Activity2.Entities.Utilities.City;
import com.example.Activity2.Activity2.Entities.Utilities.Country;
import jakarta.persistence.*;

@Entity
@Table
public class Employee_Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )


    private Long address_id;
    private String address;
    private String zip_code;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "addressType_id", nullable = false)
    private AddressType addressType;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    public Employee_Address() {
    }

    public Employee_Address(String address, String zip_code, Employee employee, AddressType addressType, Country country, City city) {
        this.address = address;
        this.zip_code = zip_code;
        this.employee = employee;
        this.addressType = addressType;
        this.country = country;
        this.city = city;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Employee_Address{" +
                "address_id=" + address_id +
                ", address='" + address + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", employee_id=" + employee.getEmployee_id() +
                ", addressType_id=" + addressType.getAdd_type_id() +
                ", country_id=" + country.getCountry_id() +
                ", city_id=" + city.getCity_id() +
                '}';
    }
}
