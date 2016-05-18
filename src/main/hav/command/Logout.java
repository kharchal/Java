package main.hav.command;

import main.hav.pagenames.PageNameManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Logout implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration attrs = request.getSession().getAttributeNames();
        System.out.println("---------------------");
        while (attrs.hasMoreElements()) {
            System.out.println("attrs.nextElement() = " + attrs.nextElement().toString());
        }
        System.out.println("---------------------");

        request.getSession().setAttribute("loggeduser", null);
        request.getSession().setAttribute("users", null);
        request.getSession().setAttribute("exprs", null);
        request.getSession().setAttribute("roles", null);
        request.getSession().setAttribute("msg", null);

        request.getSession().invalidate();
        return PageNameManager.getInstance().getProperty("index");
    }
}
