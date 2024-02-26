package com.ilan.demo.repository;

import com.ilan.demo.entity.AdType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AdTypeRepository implements IAdTypeRepository{

    private EntityManager entityManager;

    public AdTypeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(AdType adType) {
        entityManager.persist(adType);
    }

    @Override
    public AdType getByName(String name) {
        TypedQuery<AdType> query=entityManager.createQuery("select a from AdType a " +
                "JOIN FETCH a.adlist " +
                "where a.name = :data",AdType.class);
        query.setParameter("data",name);
        AdType adType=query.getSingleResult();
        return adType;
    }

    @Override
    public List<AdType> getAll() {
        TypedQuery<AdType> query=entityManager.createQuery("select a from AdType a",AdType.class);
        List<AdType> adTypeList=query.getResultList();
        return adTypeList;
    }

    @Transactional
    @Override
    public void update(AdType adType) {
        entityManager.merge(adType);
    }

    @Transactional
    @Override
    public void delete(String name) {
        AdType adType=getByName(name);
        entityManager.remove(adType);
    }
}
