package main.hav.dao;

import main.hav.datasource.DataSourceHolder;
import main.hav.entity.Role;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RoleDaoImpl implements RoleDao {

    private static Logger LOGGER = Logger.getLogger(RoleDaoImpl.class);
    private static String GET = "SELECT * FROM roles WHERE role_id=?";
    private static String GET_ALL = "SELECT * FROM roles";
    private static final String GET_ID = "SELECT * FROM roles WHERE role=?";

    @Override
    public Role findById(int id) {
        LOGGER.debug("start to findById...<" + id + ">");
        Role role = null;
        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                role = receiveRole(rs);
            }
        } catch (SQLException e) {
            LOGGER.warn("findById has crushed!");
            e.printStackTrace();
        }
        LOGGER.debug("findById completed.");
        return role;

    }

    @Override
    public List<Role> findAll() {
        List<Role> users = new ArrayList<Role>();
        try (Connection connection = DataSourceHolder.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL);
            while (rs.next()) {
                users.add(receiveRole(rs));
            }
        } catch (SQLException e) {
            LOGGER.warn("findAll has crushed!");
            e.printStackTrace();
        }
        LOGGER.debug("findAll completed.");
        return users;
    }

    @Override
    public int findIdByRole(String role) {
        LOGGER.debug("start to findIdByRole...<" + role + ">");
        Role r = null;
        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_ID);
            statement.setString(1, role);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                r = receiveRole(rs);
            }
        } catch (SQLException e) {
            LOGGER.warn("findIdByRole has crushed!");
            e.printStackTrace();
        }
        LOGGER.debug("findIdByRole completed.");
        return r.getId();
    }

    private Role receiveRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setRole(rs.getString("role"));
        role.setId(rs.getInt("role_id"));
        return role;
    }
}
