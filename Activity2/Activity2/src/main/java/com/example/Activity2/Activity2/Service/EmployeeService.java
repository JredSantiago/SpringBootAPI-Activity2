package com.example.Activity2.Activity2.Service;

import com.example.Activity2.Activity2.Entities.Employee;
import com.example.Activity2.Activity2.Entities.Employee_Address;
import com.example.Activity2.Activity2.Entities.Utilities.AddressType;
import com.example.Activity2.Activity2.Entities.Utilities.City;
import com.example.Activity2.Activity2.Entities.Utilities.Country;
import com.example.Activity2.Activity2.Projection.EmployeeAddressProjection;
import com.example.Activity2.Activity2.Repository.EmployeeRepository;
import com.example.Activity2.Activity2.Repository.Employee_AddressRepository;
import com.example.Activity2.Activity2.Repository.Utilities.AddressTypeRepository;
import com.example.Activity2.Activity2.Repository.Utilities.CityRepository;
import com.example.Activity2.Activity2.Repository.Utilities.CountryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Employee_AddressRepository emp_addRepository;
    private final AddressTypeRepository addressTypeRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, Employee_AddressRepository emp_addRepository, AddressTypeRepository addressTypeRepository, CountryRepository countryRepository, CityRepository cityRepository) {
        this.employeeRepository = employeeRepository;
        this.emp_addRepository = emp_addRepository;
        this.addressTypeRepository = addressTypeRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public List<Employee> GetEmployees() {
        return employeeRepository.findAll();
    }

    public void PostEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    public void DeleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists) {
            throw new IllegalStateException(
                    "Employee with id #" + employeeId + " does not exists!"
            );
        }

        employeeRepository.deleteById(employeeId);

    }

    @Transactional
    public void UpdateEmployee(Long employeeId, Employee newEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                 .orElseThrow(() -> new IllegalStateException(
                         "Employee with id #" + employeeId + " does not exists!"));

        employee.setFirst_name(newEmployee.getFirst_name());
        employee.setLast_name(newEmployee.getLast_name());
        employee.setExtension_name(newEmployee.getExtension_name());
        employee.setBirth_date(newEmployee.getBirth_date());
        employee.setCivil_status(newEmployee.getCivil_status());
        employee.setReligion(newEmployee.getReligion());
        employee.setNationality(newEmployee.getNationality());
     }

     //Employee Address

    private Employee_Address GetExistingForeignKey(Employee_Address employeeAddress){
        Employee employee = employeeRepository.findById(employeeAddress.getEmployee().getEmployee_id())
                .orElseThrow(() -> new IllegalStateException(
                        "Employee Id does not exists!"));

        AddressType addType = addressTypeRepository.findById(employeeAddress.getAddressType().getAdd_type_id())
                .orElseThrow(() -> new IllegalStateException(
                        "Employee address type Id does not exists!"));

        Country country = countryRepository.findById(employeeAddress.getCountry().getCountry_id())
                .orElseThrow(() -> new IllegalStateException(
                        "Country Id does not exists!"));

        City city = cityRepository.findById(employeeAddress.getCity().getCity_id())
                .orElseThrow(() -> new IllegalStateException(
                        "City Id does not exists!"));

        employeeAddress.setEmployee(employee);
        employeeAddress.setAddressType(addType);
        employeeAddress.setCountry(country);
        employeeAddress.setCity(city);

        return employeeAddress;
    }

    public List<EmployeeAddressProjection> GetEmployeesAddress() {

        return emp_addRepository.GetAllAddress();
    }

    public void PostEmployeesAddress(Employee_Address employeeAddress) {

        employeeAddress = GetExistingForeignKey(employeeAddress);

        emp_addRepository.save(employeeAddress);
    }

    public void DeleteEmployeeAddress(Long AddressId){

        boolean exists = emp_addRepository.existsById(AddressId);
        if(!exists) {
            throw new IllegalStateException(
                    "Employee address with id #" + AddressId + " does not exists!"
            );
        }

        emp_addRepository.deleteById(AddressId);
    }


    @Transactional
    public void UpdateEmployeesAddress(Long EmpAdd_id,Employee_Address newEmployeeAddress) {

        Employee_Address employeeAddress = emp_addRepository.findById(EmpAdd_id)
                .orElseThrow(() -> new IllegalStateException(
                        "Employee address with id #" + EmpAdd_id + " does not exists!"));

        newEmployeeAddress = GetExistingForeignKey(newEmployeeAddress);

        employeeAddress.setAddress(newEmployeeAddress.getAddress());
        employeeAddress.setZip_code(newEmployeeAddress.getZip_code());

        emp_addRepository.save(employeeAddress);
    }


}
