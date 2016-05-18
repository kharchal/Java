package main.hav.controller;

import main.hav.command.ICommand;
import main.hav.command.factory.CommandFactory;
import main.hav.pagenames.PageNameManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class Controller extends javax.servlet.http.HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(Controller.class);
    private String prevUrl = PageNameManager.getInstance().getProperty("index");

    public void init(ServletConfig config) throws ServletException {

        ServletContext context = config.getServletContext();
        String root = context.getRealPath("/");
        String log4jConfigFile = context.getInitParameter("log4j-config-location");
        String fullPath = root + File.separator + log4jConfigFile;
        PropertyConfigurator.configure(fullPath);
        LOGGER.info("Servlet inits");

    }


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICommand c = CommandFactory.getCommand(request);
        String url = c.execute(request, response);
        LOGGER.debug("prev URL:" + prevUrl + " current URL:" + url);
        if (url == null) {
            url = prevUrl;
        }
        prevUrl = url;
        LOGGER.debug("forward to:" + url);
        request.getRequestDispatcher(url).forward(request, response);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
