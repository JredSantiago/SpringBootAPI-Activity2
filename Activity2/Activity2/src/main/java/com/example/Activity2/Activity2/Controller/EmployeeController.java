package com.example.Activity2.Activity2.Controller;

import com.example.Activity2.Activity2.Entities.Employee;
import com.example.Activity2.Activity2.Entities.Employee_Address;
import com.example.Activity2.Activity2.Projection.EmployeeAddressProjection;
import com.example.Activity2.Activity2.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> GetEmployees(){
        return employeeService.GetEmployees();
    }

    @PostMapping
    public void PostEmployees(@RequestBody List<Employee> employee){
        employeeService.PostEmployees(employee);
    }

    @DeleteMapping(path = "{employeeId}")
    public void DeleteEmployee(@PathVariable("employeeId") Long EmployeeId) {

        employeeService.DeleteEmployee(EmployeeId);
    }

    @PostMapping(path = "{employeeId}")
    public void UpdateEmployee(@PathVariable("employeeId") Long EmployeeId, @RequestBody Employee employee) {

        employeeService.UpdateEmployee(EmployeeId, employee);
    }


    //Employee address

    @GetMapping(path = "/Address")
    public List<EmployeeAddressProjection> GetEmployeesAddress(){
        return employeeService.GetEmployeesAddress();
    }

    @PostMapping(path = "/Address")
    public void PostEmployeesAddress(@RequestBody Employee_Address employeeAddress){
        employeeService.PostEmployeesAddress(employeeAddress);
    }

    @DeleteMapping(path = "/Address/{addressId}")
    public void DeleteStudent(@PathVariable("addressId") Long AddressId) {

        employeeService.DeleteEmployeeAddress(AddressId);
    }

    @PostMapping(path = "/Address/{addressId}")
    public void UpdateEmployeeAddress(@PathVariable("addressId") Long AddressId, @RequestBody Employee_Address employeeAddress){
        employeeService.UpdateEmployeesAddress(AddressId, employeeAddress);
    }

}
