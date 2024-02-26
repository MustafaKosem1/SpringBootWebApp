package com.ilan.demo.dto;


import com.ilan.demo.entity.Ad;
import com.ilan.demo.entity.AdType;
import com.ilan.demo.entity.City;
import com.ilan.demo.entity.User;
import com.ilan.demo.valueObject.Money;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AdDto {

    private LocalDate date;

    private User adowner;

    private City city;

    private String description;

    private String header;

    private Money price;

    private AdType adtype1;

    private AdType adtype2;
    private AdType adtype3;
    private AdType adtype4;

    public AdDto(){

    }

    public AdDto(LocalDate date, User adowner, City city, String description, String header, Money price, AdType adtype1, AdType adtype2, AdType adtype3, AdType adtype4) {
        this.date = date;
        this.adowner = adowner;
        this.city = city;
        this.description = description;
        this.header = header;
        this.price = price;
        this.adtype1 = adtype1;
        this.adtype2 = adtype2;
        this.adtype3 = adtype3;
        this.adtype4 = adtype4;
    }

    public Ad convertToAd(Ad ad, int user_id){

        User adowner = new User();
        adowner.setId(user_id);
        ad.setAdowner(adowner);
        ad.setDate(LocalDate.now());

        City city=new City();
        city.setName(this.getCity().getName());
        ad.setCity(city);

        ad.setDescription(this.getDescription());

        ad.setHeader(this.getHeader());

        Money price=new Money();
        price.setValue(this.getPrice().getValue());
        ad.setPrice(price);

        List<AdType> adTypeList=new ArrayList<>();
        ad.setAdtypelist(adTypeList);

        if(this.getAdtype1().getName()!=null){
            ad.getAdtypelist().add(this.getAdtype1());
        }
        if(this.getAdtype2().getName()!=null){
            ad.getAdtypelist().add(this.getAdtype2());
        }
        if(this.getAdtype3().getName()!=null){
            ad.getAdtypelist().add(this.getAdtype3());
        }
        if(this.getAdtype4().getName()!=null){
            ad.getAdtypelist().add(this.getAdtype4());
        }
        return ad;
    }

    public void convertToAdDto(Ad ad){
        this.setDate(ad.getDate());
        this.setCity(ad.getCity());
        this.setDescription(ad.getDescription());
        this.setPrice(ad.getPrice());
        this.setHeader(ad.getDescription());
        for(AdType adType: ad.getAdtypelist()){
            if(adType.getName()=="Day"){
                this.setAdtype1(adType);
            }
            if(adType.getName()=="Night"){
                this.setAdtype2(adType);
            }
            if(adType.getName()=="Tour"){
                this.setAdtype3(adType);
            }
            else{
                this.setAdtype4(adType);
            }
        }
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getAdowner() {
        return adowner;
    }

    public void setAdowner(User adowner) {
        this.adowner = adowner;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public AdType getAdtype1() {
        return adtype1;
    }

    public void setAdtype1(AdType adtype1) {
        this.adtype1 = adtype1;
    }

    public AdType getAdtype2() {
        return adtype2;
    }

    public void setAdtype2(AdType adtype2) {
        this.adtype2 = adtype2;
    }

    public AdType getAdtype3() {
        return adtype3;
    }

    public void setAdtype3(AdType adtype3) {
        this.adtype3 = adtype3;
    }

    public AdType getAdtype4() {
        return adtype4;
    }

    public void setAdtype4(AdType adtype4) {
        this.adtype4 = adtype4;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
