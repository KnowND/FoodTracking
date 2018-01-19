package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by edik2 on 01.01.2018.
 */
public class DatabaseConnection {

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
            String url = resourceBundle.getString("url");
            String login = resourceBundle.getString("login");
            String password = resourceBundle.getString("password");
            return DriverManager.getConnection(url,login,password);

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
