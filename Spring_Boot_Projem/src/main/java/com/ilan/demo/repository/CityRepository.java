package com.ilan.demo.repository;

import com.ilan.demo.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class CityRepository implements ICityRepository{

    private EntityManager entityManager;

    public CityRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(City city) {
        entityManager.persist(city);
    }

    @Override
    public City getByName(String name) {
        return entityManager.find(City.class, name);
    }

    @Override
    public List<City> getAll() {
        TypedQuery<City> query=entityManager.createQuery("select c from City c",City.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void update(City city) {
        entityManager.merge(city);
    }

    @Transactional
    @Override
    public void delete(String name) {
        City city=getByName(name);
        entityManager.remove(city);
    }
}
