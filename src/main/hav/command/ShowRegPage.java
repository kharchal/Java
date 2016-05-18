package main.hav.command;

import main.hav.pagenames.PageNameManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ShowRegPage implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("msg", null);
        return PageNameManager.getInstance().getProperty("reg");
    }
}
