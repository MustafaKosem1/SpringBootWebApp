package com.ilan.demo.controller;

import com.ilan.demo.business.ICityService;
import com.ilan.demo.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityContoller {

    private ICityService cityService;

    @Autowired
    public CityContoller(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/find")
    public ResponseEntity<List<City>> findAllCity(){
        List<City> cityList=cityService.getAll();
        return new ResponseEntity<List<City>>(cityList, HttpStatus.OK);
    }
}
