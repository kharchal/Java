package main.hav.dao;

import main.hav.dao.factory.DaoFactory;
import main.hav.datasource.DataSourceHolder;
import main.hav.entity.Role;
import main.hav.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDaoImpl implements UserDao {
    private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private static final String GET_BY_ID = "SELECT * FROM users WHERE user_id=?";
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String IS_BUSY = "SELECT login FROM users WHERE login=?";
    private static final String ADD = "INSERT INTO users (login, password, name, surname, role) VALUES (?, ?, ?, ?, ?)";
    private static final String LOGIN = "SELECT * FROM users WHERE login=? AND password=?";
    private static final String REMOVE = "DELETE FROM users WHERE user_id=?";
    private static final String UPDATE = "UPDATE users SET login=?, password=?, name=?, surname=?, role=? WHERE user_id=? LIMIT 1";
    private static final String COUNT = "SELECT COUNT(DISTINCT login) FROM users";

    public void save(User user) {
        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setInt(5, DaoFactory.getRoleDao().findIdByRole(user.getRole().getRole()));

            int n = statement.executeUpdate();
            if (n == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                user.setId(id);
            }
            LOGGER.debug("add received id: " + user.getId());

        } catch (SQLException e) {
            LOGGER.warn("findAll has crushed!");
            e.printStackTrace();
        }

    }

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        try (Connection connection = DataSourceHolder.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL);
            while (rs.next()) {
                users.add(receiveUser(rs));
            }
        } catch (SQLException e) {
            LOGGER.warn("findAll has crushed!");
            e.printStackTrace();
        }
        LOGGER.debug("findAll completed.");
        return users;
    }

    private User receiveUser(ResultSet rs) throws SQLException {
        LOGGER.debug("receiving user from result set");
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        Role role = DaoFactory.getRoleDao().findById(rs.getInt("role"));
        user.setRole(role);

        LOGGER.debug("received user from result set");
        return user;

    }

    public User findById(int id) {
        User user = null;
        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = receiveUser(rs);
            }
        } catch (SQLException e) {
            LOGGER.warn("findAll has crushed!");
            e.printStackTrace();
        }
        return user;
    }

    public User login(String login, String password) {
        User user = null;
        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(LOGIN);
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = receiveUser(rs);
            }
        } catch (SQLException e) {
            LOGGER.warn("login has crushed!");
            e.printStackTrace();
        }
        return user;// null if User wasn't found
    }

    public void update(User user) {
        LOGGER.debug("start to update user <" + user.getLogin() + ">...");
        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getSurname());
            statement.setInt(5, user.getRole().getId());
            statement.setInt(6, user.getId());
            statement.executeUpdate();
            LOGGER.debug("update completed.");
        } catch (SQLException e) {
            LOGGER.warn("update crushed!");
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        LOGGER.debug("start to deleteById...");
        try (Connection connection = DataSourceHolder.getConnection()) {
            if (id <= 0) {
                throw new IllegalArgumentException();
            }
                PreparedStatement statement = connection.prepareStatement(REMOVE);
                statement.setInt(1, id);
                statement.executeUpdate();

            LOGGER.debug("deleteById completed.");
        } catch (SQLException e) {
            LOGGER.warn("deleteById crushed!");
            e.printStackTrace();
        }

    }

    @Override
    public boolean loginIsBusy(String login) {

        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(IS_BUSY);
            statement.setString(1, login);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            LOGGER.warn("loginIsBusy has crushed!");
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public int count() {
        int count = 0;
        try (Connection connection = DataSourceHolder.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(COUNT);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.warn("count has crushed!");
            e.printStackTrace();
        }
        LOGGER.debug("count completed.");
        return count;
    }
}
