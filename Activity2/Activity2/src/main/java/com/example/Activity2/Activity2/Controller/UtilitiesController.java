package com.example.Activity2.Activity2.Controller;

import com.example.Activity2.Activity2.Entities.Utilities.AddressType;
import com.example.Activity2.Activity2.Entities.Utilities.City;
import com.example.Activity2.Activity2.Entities.Utilities.Country;
import com.example.Activity2.Activity2.Service.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Utilities")
public class UtilitiesController {
    private final UtilitiesService utilitiesService;

    @Autowired
    public UtilitiesController(UtilitiesService utilitiesService) {
        this.utilitiesService = utilitiesService;
    }

    @GetMapping(path = "/AddressType")
    public List<AddressType> GetAddressType(){
        return utilitiesService.GetAddressType();
    }

    @GetMapping(path = "/Countries")
    public List<Country> GetCountry(){
        return utilitiesService.GetCountries();
    }

    @GetMapping(path = "/Cities")
    public List<City> GetCities(){
        return utilitiesService.GetCities();
    }


}
