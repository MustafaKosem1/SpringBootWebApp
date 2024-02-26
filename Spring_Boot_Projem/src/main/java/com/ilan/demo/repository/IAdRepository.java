package com.ilan.demo.repository;

import com.ilan.demo.entity.Ad;

import java.util.List;


public interface IAdRepository {
    void save(Ad ad);

    Ad getById(int id);

    List<Ad> getAll();

    void update(Ad ad);

    void delete(int id);
}
