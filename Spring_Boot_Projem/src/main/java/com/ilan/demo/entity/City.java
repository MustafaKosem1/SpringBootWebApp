package com.ilan.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "city")
    private List<Ad> ad_list;

    public City(){

    }

    public City(String name, String description, List<Ad> ad_list) {
        this.name = name;
        this.description = description;
        this.ad_list = ad_list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ad> getAd_list() {
        return ad_list;
    }

    public void setAd_list(List<Ad> ad_list) {
        this.ad_list = ad_list;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
