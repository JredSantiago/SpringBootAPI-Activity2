package com.example.Activity2.Activity2.Config;

import com.example.Activity2.Activity2.Entities.Utilities.AddressType;
import com.example.Activity2.Activity2.Entities.Utilities.City;
import com.example.Activity2.Activity2.Entities.Utilities.Country;
import com.example.Activity2.Activity2.Repository.Utilities.AddressTypeRepository;
import com.example.Activity2.Activity2.Repository.Utilities.CityRepository;
import com.example.Activity2.Activity2.Repository.Utilities.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UtilitiesConfig {

    @Bean
    CommandLineRunner commandLineRunner(CountryRepository countryRepository, CityRepository cityRepository, AddressTypeRepository addressTypeRepository) {
        return args -> {
            Country Phil = new Country(
                    "fil",
                    "Philippines"

            );

            Country Aus = new Country(
                    "aus",
                    "Australia"

            );

            Country US = new Country(
                    "us",
                    "America"

            );

            countryRepository.saveAll(
                    List.of(Phil, Aus, US)
            );

            City Man = new City(
                    "man",
                    "Manila"

            );

            City Can = new City(
                    "can",
                    "Canberra"

            );

            City Wash = new City(
                    "wash",
                    "Washington"

            );

            cityRepository.saveAll(
                    List.of(Man, Can, Wash)
            );

            AddressType Permanent = new AddressType(
                    "Permanent"
            );

            AddressType Present = new AddressType(
                    "Present"
            );

            addressTypeRepository.saveAll(
                    List.of(Permanent, Present)
            );

        };
    }
}
