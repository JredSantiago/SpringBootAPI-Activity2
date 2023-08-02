package com.example.Activity2.Activity2.Service;

import com.example.Activity2.Activity2.Entities.Utilities.AddressType;
import com.example.Activity2.Activity2.Entities.Utilities.City;
import com.example.Activity2.Activity2.Entities.Utilities.Country;
import com.example.Activity2.Activity2.Repository.Utilities.AddressTypeRepository;
import com.example.Activity2.Activity2.Repository.Utilities.CityRepository;
import com.example.Activity2.Activity2.Repository.Utilities.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilitiesService {

    private final AddressTypeRepository addressTypeRepository;
    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    @Autowired
    public UtilitiesService(AddressTypeRepository addressTypeRepository, CountryRepository countryRepository, CityRepository cityRepository) {
        this.addressTypeRepository = addressTypeRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    public List<AddressType> GetAddressType() {
        return addressTypeRepository.findAll();
    }
    public List<Country> GetCountries() {
        return countryRepository.findAll();
    }
    public List<City> GetCities() {
        return cityRepository.findAll();
    }
}
