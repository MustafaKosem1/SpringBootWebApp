package com.ilan.demo.repository;

import com.ilan.demo.entity.AdType;

import java.util.List;


public interface IAdTypeRepository {

    void save(AdType adType);

    AdType getByName(String name);

    List<AdType> getAll();

    void update(AdType adType);

    void delete(String name);
}
