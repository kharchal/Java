package main.hav.filter;

import main.hav.entity.User;
import main.hav.pagenames.PageNameManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class Guard implements Filter{
	private final static Logger LOGGER = Logger.getLogger(Guard.class);

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {

		LOGGER.debug("filter works...");
		HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        LOGGER.debug("URL:" + request.getRequestURL());

		HttpSession session = request.getSession(false);

		LOGGER.debug("session:" + session);

		
		
		PageNameManager pnm = PageNameManager.getInstance();

		User loggeduser = (User) session.getAttribute("loggeduser");
		LOGGER.debug("Logged User: " + loggeduser);
		if (session != null && loggeduser != null) {
			LOGGER.debug("request coding before: " + request.getCharacterEncoding());
			LOGGER.debug("response coding before: " + response.getCharacterEncoding());
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			LOGGER.debug(session.getServletContext());
			LOGGER.debug("request coding after: " + request.getCharacterEncoding());
			LOGGER.debug("response coding after: " + response.getCharacterEncoding());

		} else {

			LOGGER.warn("   Session has been expired!");

			LOGGER.debug("redirect!");
			response.sendRedirect(pnm.getProperty("index"));
			return;
		}
		chain.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
