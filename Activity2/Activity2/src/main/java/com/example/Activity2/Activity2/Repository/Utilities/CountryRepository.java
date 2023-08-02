package com.example.Activity2.Activity2.Repository.Utilities;

import com.example.Activity2.Activity2.Entities.Utilities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
