package com.example.Activity2.Activity2.Repository.Utilities;

import com.example.Activity2.Activity2.Entities.Utilities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
