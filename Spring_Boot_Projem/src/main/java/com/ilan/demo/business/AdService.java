package com.ilan.demo.business;

import com.ilan.demo.entity.Ad;
import com.ilan.demo.repository.IAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdService implements IAdService{
    private IAdRepository adRepository;

    @Autowired
    public AdService(IAdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public void save(Ad ad) {

        adRepository.save(ad);
    }

    @Override
    public Ad getById(int id) {
        return adRepository.getById(id);
    }

    @Override
    public List<Ad> getAll() {
        return adRepository.getAll();
    }

    @Override
    public void update(Ad ad) {
        adRepository.update(ad);
    }

    @Override
    public void delete(int id) {
        adRepository.delete(id);
    }
}
