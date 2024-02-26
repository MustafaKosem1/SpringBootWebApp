package com.ilan.demo.business;

import com.ilan.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void save(User user);

    User getById(int id);

    List<User> getAll();

    void update(User user);

    void delete(int id);
}
