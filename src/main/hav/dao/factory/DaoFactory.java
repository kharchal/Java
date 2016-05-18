package main.hav.dao.factory;

import main.hav.dao.*;
import org.apache.log4j.Logger;

public class DaoFactory {

    private static final Logger LOGGER = Logger.getLogger(DaoFactory.class);

    public static UserDao getUserDao() {
        LOGGER.info(" userDao is ready to use.");
        return new UserDaoImpl();
    }

    public static RoleDao getRoleDao() {
        LOGGER.info(" RoleDao is ready to use.");
        return new RoleDaoImpl();
    }

    public static ExpressionDao getExpressionDAO() {
        LOGGER.info(" ExpressionDao is ready to use.");
        return new ExpressionDaoImpl();
    }

}
