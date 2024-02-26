package com.ilan.demo.business;

import com.ilan.demo.entity.City;
import com.ilan.demo.repository.ICityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService{

    private ICityRepository cityRepository;

    public CityService(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public City getByName(String name) {
        return cityRepository.getByName(name);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.getAll();
    }

    @Override
    public void update(City city) {
        cityRepository.update(city);
    }

    @Override
    public void delete(String name) {
        cityRepository.delete(name);
    }
}
