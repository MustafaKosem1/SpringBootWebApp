package com.ilan.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "age")
    private int age;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "adowner")//buraya cascade all ekleyince ad silme işlemi yapılamıyor.
    private List<Ad> user_ad_list; //çözüm ise userda bulunan bu listeden ilgili ad'i kaldırmak.

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role")
    private Role role;


    public User(){

    }

    public User(String username, String password, String name, String surname, String phone, String mail, int age, boolean enabled, List<Ad> user_ad_list, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.mail = mail;
        this.age = age;
        this.enabled = enabled;
        this.user_ad_list = user_ad_list;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Ad> getUser_ad_list() {
        return user_ad_list;
    }

    public void setUser_ad_list(List<Ad> user_ad_list) {
        this.user_ad_list = user_ad_list;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role=" + role +
                '}';
    }
}
