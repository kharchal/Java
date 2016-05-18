package main.hav.command;

import main.hav.dao.factory.DaoFactory;
import main.hav.entity.Role;
import main.hav.entity.User;
import main.hav.pagenames.PageNameManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        if (DaoFactory.getUserDao().loginIsBusy(login)) {
            request.getSession().setAttribute("login", login);
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("surname", surname);

            request.getSession().setAttribute("msg", "Login is not available. Choose another one.");
            return PageNameManager.getInstance().getProperty("reg");
        }



        User user = new User(login, password, name, surname, new Role("user"));

        DaoFactory.getUserDao().save(user);
        request.getSession().setAttribute("msg", null);
        return PageNameManager.getInstance().getProperty("login");
    }
}
