package com.example.Activity2.Activity2.Repository;

import com.example.Activity2.Activity2.Entities.Employee_Address;
import com.example.Activity2.Activity2.Projection.EmployeeAddressProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Employee_AddressRepository extends JpaRepository<Employee_Address, Long> {
    @Query("SELECT Emp.address_id as addressId, Emp.employee.employee_id as employeeId, Emp.address as addressValue, Emp.addressType.add_type_id as addressTypeId, Emp.city.city_id as cityId, Emp.country.country_id as countryId, Emp.zip_code as zipCode FROM Employee_Address Emp")
    List<EmployeeAddressProjection> GetAllAddress();
}
