package com.ilan.demo.controller;

import com.ilan.demo.business.IAdService;
import com.ilan.demo.entity.Ad;
import com.ilan.demo.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ad")
public class AdController {
    private IAdService adService;


    @Autowired
    public AdController(IAdService adService) {
        this.adService = adService;
    }

    @PostMapping("/save")
    public ResponseEntity<Ad> saveAd(@RequestBody Ad ad){
        //ad.getPrice().validateValue();
        for(Image image: ad.getImage_list()){
            image.setImage_owner_ad(ad);
        }
        adService.save(ad);
        return new ResponseEntity<Ad>(ad, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Ad> findAdById(@PathVariable int id){
        Ad ad=adService.getById(id);
        return new ResponseEntity<Ad>(ad, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<List<Ad>> findAllAd(){
        List<Ad> adList=adService.getAll();
        return new ResponseEntity<List<Ad>>(adList,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Ad> updateAd(@RequestBody Ad ad){
        adService.update(ad);
        return new ResponseEntity<Ad>(ad, HttpStatus.CREATED);
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<HttpStatus> removeAd(@PathVariable int id){
        adService.delete(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}
