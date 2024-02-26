package com.ilan.demo.business;

import com.ilan.demo.entity.City;

import java.util.List;

public interface ICityService {
    void save(City city);

    City getByName(String name);

    List<City> getAll();

    void update(City city);

    void delete(String name);
}
