package com.ilan.demo.repository;

import com.ilan.demo.entity.Ad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AdRepository implements IAdRepository{

    private EntityManager entityManager;

    @Autowired
    public AdRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Ad ad) {
        entityManager.persist(ad);
    }

    @Override
    public Ad getById(int id) {
        //TypedQuery<Ad> theQuery = entityManager.createQuery("select a from Ad a " +
        //        "JOIN FETCH a.adtypelist " +
        //        "where a.id = :data", Ad.class);
        //theQuery.setParameter("data", id);
        //Ad ad=theQuery.getSingleResult();
        Ad ad=entityManager.find(Ad.class, id);
        return ad;
    }

    @Override
    public List<Ad> getAll(){
        TypedQuery<Ad> theQuery = entityManager.createQuery("select a from Ad a",Ad.class);
        List<Ad> adList=theQuery.getResultList();
        return adList;
    }

    @Transactional
    @Override
    public void update(Ad ad) {
        entityManager.merge(ad);
    }

    @Transactional
    @Override
    public void delete(int id) {
        Ad ad = entityManager.find(Ad.class,id);
        //ad.getCity().getAd_list().remove(ad);
        //ad.getAdowner().getUser_ad_list().remove(ad); //userdan silmeyince ad silinmiyor? çünkü user tarafında cascade vardı
        entityManager.remove(ad);
    }
}
