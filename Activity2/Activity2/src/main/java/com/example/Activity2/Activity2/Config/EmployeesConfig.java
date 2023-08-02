package com.example.Activity2.Activity2.Config;

import com.example.Activity2.Activity2.Entities.Employee;
import com.example.Activity2.Activity2.Repository.EmployeeRepository;
import com.example.Activity2.Activity2.Repository.Employee_AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class EmployeesConfig {
    @Bean
    CommandLineRunner EmployeeCommandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee Employee1 = new Employee(
                    "employee1",
                    "example",
                    "",
                    LocalDate.of(1999, Month.OCTOBER, 5),
                    "normal",
                    "Normal",
                    "Filipino"

            );

            Employee Employee2 = new Employee(
                    "employee2",
                    "example",
                    "",
                    LocalDate.of(1999, Month.OCTOBER, 5),
                    "normal",
                    "Normal",
                    "Filipino"
            );

            Employee Employee3 = new Employee(
                    "employee3",
                    "example",
                    "",
                    LocalDate.of(1999, Month.OCTOBER, 5),
                    "normal",
                    "Normal",
                    "Filipino"
            );

            employeeRepository.saveAll(
                    List.of(Employee1, Employee2, Employee3)
            );

        };
    }
}
