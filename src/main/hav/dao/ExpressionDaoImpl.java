package main.hav.dao;

import main.hav.dao.factory.DaoFactory;
import main.hav.datasource.DataSourceHolder;
import main.hav.entity.Expression;
import main.hav.entity.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpressionDaoImpl implements ExpressionDao {

    private static final Logger LOGGER = Logger.getLogger(ExpressionDaoImpl.class);
    private static final String GET_ALL = "SELECT * FROM expressions";
    private static final String GET_BY_USER = "SELECT * FROM expressions WHERE user=?";
    private static final String ADD = "INSERT INTO expressions (expression, result, user) VALUES (?, ?, ?)";
    private static final String COUNT = "SELECT COUNT(DISTINCT expression) FROM expressions";

    @Override
    public List<Expression> findAll() {
        List<Expression> exprs = new ArrayList<Expression>();
        try (Connection connection = DataSourceHolder.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(GET_ALL);
            while (rs.next()) {
                exprs.add(receiveExpression(rs));
            }
        } catch (SQLException e) {
            LOGGER.warn("findAll has crushed!");
            e.printStackTrace();
        }
        LOGGER.debug("findAll completed.");
        return exprs;
    }

    private Expression receiveExpression(ResultSet rs) throws SQLException {
        LOGGER.debug("receiving expression from result set");
        Expression expr = new Expression();
        expr.setId(rs.getInt("expr_id"));
        expr.setExpression(rs.getString("expression"));
        expr.setResult(rs.getDouble("result"));
        User user = DaoFactory.getUserDao().findById(rs.getInt("user"));
        expr.setTimestamp(rs.getString("timestamp"));
        expr.setUser(user);

        LOGGER.debug("received expression from result set");
        return expr;
    }

    @Override
    public List<Expression> findByUser(User user) {
        List<Expression> exprs = new ArrayList<Expression>();
        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_BY_USER);
            statement.setInt(1, user.getId());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                exprs.add(receiveExpression(rs));
            }
        } catch (SQLException e) {
            LOGGER.warn("findByUser has crushed!");
            e.printStackTrace();
        }
        LOGGER.debug("findByUser completed.");
        return exprs;
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

    @Override
    public void save(Expression expression) {
        try (Connection connection = DataSourceHolder.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD);
            statement.setString(1, expression.getExpression());
            statement.setDouble(2, expression.getResult());
            statement.setInt(3, expression.getUser().getId());
            int n = statement.executeUpdate();
            if (n == 1) {
                ResultSet rs = statement.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                expression.setId(id);
            }
            LOGGER.debug("save received id: " + expression.getId());

        } catch (SQLException e) {
            LOGGER.warn("save has crushed!");
            e.printStackTrace();
        }

    }
}
