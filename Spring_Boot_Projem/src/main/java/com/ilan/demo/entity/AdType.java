package com.ilan.demo.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name")
//üstteki json'ın infite loopa girmesini önlüyor.
@Entity
@Table(name="ad_type")
public class AdType {
    @Id
    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @JsonIgnoreProperties("adtypelist")
    //@JsonBackReference
    //@JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="ad_ad_type",
            joinColumns = @JoinColumn(name="ad_type"),
            inverseJoinColumns = @JoinColumn(name="ad_id")
    )
    private List<Ad> adlist;

    public AdType(){

    }

    public AdType(String name, String description, List<Ad> adlist) {
        this.name = name;
        this.description = description;
        this.adlist = adlist;
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

    public List<Ad> getAdlist() {
        return adlist;
    }

    public void setAdlist(List<Ad> adlist) {
        this.adlist = adlist;
    }

    @Override
    public String toString() {
        return "AdType{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
