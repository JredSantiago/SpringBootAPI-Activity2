package com.example.Activity2.Activity2.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long employee_id;
    private String first_name;
    private String last_name;
    private String extension_name;
    private LocalDate birth_date;
    private String civil_status;
    private String religion;
    private String nationality;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.MERGE)
    private Set<Employee_Address> employeeAddress;

    public Employee() {
    }

    public Employee(String first_name, String last_name, String extension_name, LocalDate birth_date, String civil_status, String religion, String nationality) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.extension_name = extension_name;
        this.birth_date = birth_date;
        this.civil_status = civil_status;
        this.religion = religion;
        this.nationality = nationality;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getExtension_name() {
        return extension_name;
    }

    public void setExtension_name(String extension_name) {
        this.extension_name = extension_name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getCivil_status() {
        return civil_status;
    }

    public void setCivil_status(String civil_status) {
        this.civil_status = civil_status;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", extension_name='" + extension_name + '\'' +
                ", birth_date=" + birth_date +
                ", civil_status='" + civil_status + '\'' +
                ", religion='" + religion + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
