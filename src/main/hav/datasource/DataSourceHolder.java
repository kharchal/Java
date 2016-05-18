package main.hav.datasource;

import main.hav.dao.factory.DaoFactory;
import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceHolder {
	private static final Logger LOGGER = Logger.getLogger(DaoFactory.class);
	private static DataSource dataSource;
	
	static {
		
		InitialContext ic;
		try {
			ic = new InitialContext();
			dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/dbexpr");
			LOGGER.info("Data source initiated successfuly.");
		} catch (NamingException e) {
			e.printStackTrace();
			LOGGER.fatal("Data source initiation has failed.");
			System.exit(0);
		}
	}
	
	public static Connection getConnection() {
		Connection c = null;
		try {
			c = dataSource.getConnection();
		} catch (SQLException e) {
			LOGGER.warn("Connection is not obtained!");
			e.printStackTrace();
		}
		if (c == null) {
			LOGGER.warn("Connection is not settled!");
			System.exit(0);
		}
		return c;
	}

}
