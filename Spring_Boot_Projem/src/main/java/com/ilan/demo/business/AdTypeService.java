package com.ilan.demo.business;

import com.ilan.demo.entity.AdType;
import com.ilan.demo.repository.IAdTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdTypeService implements IAdTypeService{
    private IAdTypeRepository adTypeRepository;

    @Autowired
    public AdTypeService(IAdTypeRepository adTypeRepository) {
        this.adTypeRepository = adTypeRepository;
    }

    @Override
    public void save(AdType adType) {
        adTypeRepository.save(adType);
    }

    @Override
    public AdType getByName(String name) {
        return adTypeRepository.getByName(name);
    }

    @Override
    public List<AdType> getAll() {
        return adTypeRepository.getAll();
    }

    @Override
    public void update(AdType adType) {
        adTypeRepository.update(adType);
    }

    @Override
    public void delete(String name) {
        adTypeRepository.delete(name);
    }
}
