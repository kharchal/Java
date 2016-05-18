package main.hav.dao;


import main.hav.entity.Role;

import java.util.List;


public interface RoleDao {
    Role findById(int id);
    List<Role> findAll();
    int findIdByRole(String role);
}
