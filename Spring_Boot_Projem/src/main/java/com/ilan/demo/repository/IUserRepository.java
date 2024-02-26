package com.ilan.demo.repository;

import com.ilan.demo.entity.User;

import java.util.List;

public interface IUserRepository {
    void save(User user);

    User getById(int id);

    List<User> getAll();

    void update(User user);

    void delete(int id);

    User getByUserName(String userName);
}
