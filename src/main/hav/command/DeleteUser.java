package main.hav.command;

import main.hav.dao.factory.DaoFactory;
import main.hav.pagenames.PageNameManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteUser implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DaoFactory.getUserDao().delete(id);
        request.getSession().setAttribute("users", DaoFactory.getUserDao().findAll());
        return PageNameManager.getInstance().getProperty("admin");

    }
}
