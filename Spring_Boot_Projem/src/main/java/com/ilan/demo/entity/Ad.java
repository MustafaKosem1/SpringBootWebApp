package com.ilan.demo.entity;

import com.fasterxml.jackson.annotation.*;
import com.ilan.demo.valueObject.Money;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//üstteki json'ın infite loopa girmesini önlüyor.
@Entity
@Table(name="ad")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name="date")
    private LocalDate date;

    @JsonIgnoreProperties("user_ad_list")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_owner")
    private User adowner;

    @JsonIgnoreProperties("ad_list")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_name")
    private City city;

    @Column(name="description")
    private String description;

    @Column(name="header")
    private String header;

    @Column(name="price")
    @Embedded
    @AttributeOverrides({@AttributeOverride(name="value", column = @Column(name = "price"))})
    private Money price;

    @JsonIgnoreProperties("adlist")
    //@JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="ad_ad_type",
            joinColumns = @JoinColumn(name="ad_id"),
            inverseJoinColumns = @JoinColumn(name="ad_type")
    )
    private List<AdType> adtypelist;


    @JsonIgnoreProperties("image_owner_ad")
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "image_owner_ad")
    private List<Image> image_list;



    public Ad(){

    }

    public Ad(LocalDate date, User adowner, City city, String description, String header, Money price, List<AdType> adtypelist, List<Image> image_list) {
        this.date = date;
        this.adowner = adowner;
        this.city = city;
        this.description = description;
        this.header = header;
        this.price = price;
        this.adtypelist = adtypelist;
        this.image_list = image_list;
    }

    public void addImageToImageList(Image image){
        if(image_list==null){
           image_list=new ArrayList<>();
        }
        image_list.add(image);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<AdType> getAdtypelist() {
        return adtypelist;
    }

    public void setAdtypelist(List<AdType> adtypelist) {
        this.adtypelist = adtypelist;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Image> getImage_list() {
        return image_list;
    }

    public void setImage_list(List<Image> image_list) {
        this.image_list = image_list;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", date=" + date +
                ", adowner=" + adowner +
                ", city=" + city +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", adtypelist=" + adtypelist +
                ", image_list=" + image_list +
                '}';
    }
}
