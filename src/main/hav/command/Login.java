package main.hav.command;

import main.hav.dao.factory.DaoFactory;
import main.hav.entity.Role;
import main.hav.entity.User;
import main.hav.pagenames.PageNameManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Login implements ICommand {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login == null || password == null) {
            request.getSession().setAttribute("msg", "Fill the form please!");
            return PageNameManager.getInstance().getProperty("login");
        }
        User user = DaoFactory.getUserDao().login(login, password);
        if (user == null) {
            request.getSession().setAttribute("msg", "You are not authorized!");
            return PageNameManager.getInstance().getProperty("login");
        }
        user.setPassword("");//secure password
        request.getSession().setAttribute("loggeduser", user);
        request.getSession().setAttribute("msg", null);
        if (user.getRole().getId() == Role.USER) {
            request.getSession().setAttribute("exprs", DaoFactory.getExpressionDAO().findByUser(user));
            return PageNameManager.getInstance().getProperty("guest");
        } else if (user.getRole().getId() == Role.ADMIN) {
            request.getSession().setAttribute("users", DaoFactory.getUserDao().findAll());
            request.getSession().setAttribute("roles", DaoFactory.getRoleDao().findAll());
            request.getSession().setAttribute("exprs", DaoFactory.getExpressionDAO().findAll());
            request.getSession().setAttribute("exprcount", DaoFactory.getExpressionDAO().count());
            request.getSession().setAttribute("userscount", DaoFactory.getUserDao().count());
            return PageNameManager.getInstance().getProperty("admin");
        }
        request.getSession().setAttribute("loggeduser", null);
        return PageNameManager.getInstance().getProperty("login");
    }
}
