package main.hav.dao;

import main.hav.entity.Expression;
import main.hav.entity.User;

import java.util.List;


public interface ExpressionDao {
    List<Expression> findAll();
    List<Expression> findByUser(User user);
    int count();
    void save(Expression expression);
}
