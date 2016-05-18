package main.hav.command;

import main.hav.dao.factory.DaoFactory;
import main.hav.entity.Role;
import main.hav.entity.User;
import main.hav.pagenames.PageNameManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUser implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        Role role = DaoFactory.getRoleDao().findById(DaoFactory.getRoleDao().findIdByRole(request.getParameter("role")));

        User user = (User) request.getSession().getAttribute("user");
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setRole(role);
        DaoFactory.getUserDao().update(user);
        request.getSession().setAttribute("users", DaoFactory.getUserDao().findAll());
        return PageNameManager.getInstance().getProperty("admin");
    }
}
