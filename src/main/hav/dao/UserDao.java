package main.hav.dao;

import main.hav.entity.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    List<User> findAll();
    User findById(int id);
    User login(String login, String password);
    void update(User user);
    void delete(int id);
    boolean loginIsBusy(String login);
    int count();
}
