package com.ilan.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "file_location")
    private String file_location;

    @JsonIgnoreProperties("image_list")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_owner_ad")
    private Ad image_owner_ad;

    public Image(){

    }

    public Image(String file_location, Ad image_owner) {
        this.file_location = file_location;
        this.image_owner_ad = image_owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFile_location() {
        return file_location;
    }

    public void setFile_location(String file_location) {
        this.file_location = file_location;
    }

    public Ad getImage_owner_ad() {
        return image_owner_ad;
    }

    public void setImage_owner_ad(Ad image_owner) {
        this.image_owner_ad = image_owner;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", file_location='" + file_location + '\'' +
                '}';
    }
}
