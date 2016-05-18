package main.hav.command;

import main.hav.dao.factory.DaoFactory;
import main.hav.entity.User;
import main.hav.pagenames.PageNameManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditUser implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = DaoFactory.getUserDao().findById(id);
        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("msg", null);
        return PageNameManager.getInstance().getProperty("useredit");
    }
}
