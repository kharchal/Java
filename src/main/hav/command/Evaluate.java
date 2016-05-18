package main.hav.command;

import main.hav.dao.factory.DaoFactory;
import main.hav.entity.Expression;
import main.hav.entity.User;
import main.hav.pagenames.PageNameManager;
import main.hav.parser.ParserException;
import main.hav.parser.RecursiveParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Evaluate implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expr = request.getParameter("expr");
        if (expr == null) {
            request.getSession().setAttribute("msg", "Enter your expression!");
        } else {
            request.getSession().setAttribute("msg", null);
            RecursiveParser parser = new RecursiveParser();
            Double res = null;
            try {
                res = parser.evaluate(expr);
            } catch (ParserException e) {
//                e.printStackTrace();
                request.getSession().setAttribute("msg", "Expression is incorrect!");
            }
            if (res != null) {
                User user = (User)request.getSession().getAttribute("loggeduser");
                Expression expression = new Expression();
                expression.setExpression(expr);
                expression.setResult(res);
                expression.setUser(user);
                DaoFactory.getExpressionDAO().save(expression);
                request.getSession().setAttribute("exprs", DaoFactory.getExpressionDAO().findByUser(user));
            }
        }
        return PageNameManager.getInstance().getProperty("guest");
    }
}
