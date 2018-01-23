package DAO.connection;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by edik2 on 22.01.2018.
 */
public enum DataSourcePool {

    INSTANCE;

    private Logger logger = Logger.getLogger(DataSourcePool.class);

    private BasicDataSource bds;


    DataSourcePool() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String url = resourceBundle.getString("url");
        String login = resourceBundle.getString("login");
        String password = resourceBundle.getString("password");
        bds = new BasicDataSource();
        bds.setDriverClassName("com.mysql.jdbc.Driver");
        bds.setUrl(url);
        bds.setUsername(login);
        bds.setPassword(password);

        bds.setMinIdle(10);
        bds.setMaxIdle(50);
        bds.setMaxOpenPreparedStatements(300);
        logger.info("DataSource successful configure");
    }

    /**
     * Method for getting a connection
     *
     * @return {@link Connection}
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return bds.getConnection();

    }

    public DataSource getDS() {
        return bds;
    }

}
