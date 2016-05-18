package main.hav.command;

import main.hav.pagenames.PageNameManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCommand implements ICommand {
    private static final Logger LOGGER = Logger.getLogger(NoCommand.class);
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("loggeduser", null);
        request.getSession().setAttribute("users", null);
        request.getSession().setAttribute("exprs", null);
        request.getSession().setAttribute("roles", null);
        request.getSession().setAttribute("msg", null);

        request.getSession().invalidate();
        LOGGER.info("NO COMMAND");
        return PageNameManager.getInstance().getProperty("index");
    }

}

