package DAO.impl;

import DAO.AccountDAO;
import DTO.Account;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by edik2 on 20.01.2018.
 */
public class AccountDAOImpl implements AccountDAO {

    private static final Logger logger = Logger.getLogger(AccountDAOImpl.class.getName());
    private DataSource dataSource;


    public AccountDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Account getById(int id) {
        return null;
    }

    public void addAccount(Account account) {

        String sql = "INSERT INTO account(first_name, second_name, login, password, height, weight, way_of_life, age, norm, gender) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getSecondName());
            preparedStatement.setString(3, account.getEmail());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setInt(5, account.getHeight());
            preparedStatement.setInt(6, account.getWeight());
            preparedStatement.setDouble(7, account.getWayOfLife());
            preparedStatement.setInt(8, account.getAge());
            preparedStatement.setInt(9, account.getNorma());
            preparedStatement.setString(10, account.getGender());
            boolean result = preparedStatement.execute();

        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error adding record to Account table ", e);

        }
    }

    public Account findByLogin(String login) {

        String sql = "SELECT id, first_name, second_name, password, norm FROM account WHERE login = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ) {
            preparedStatement.setString(1,login);
            Account account = null;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString(1));
                String name= resultSet.getString(2);
                String surname = resultSet.getString(3);
                String password = resultSet.getString(4);
                int norm = Integer.parseInt(resultSet.getString(5));
//                gender = resultSet.getString(6);
                account = new Account(id, name,surname,login,password,norm);
            }

            return account;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @Override
//    public boolean checkLogin(String login) throws Exception{
//        String sql = "SELECT * FROM account WHERE login = " + login;
//
//        try (Connection connection = dataSource.getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery(sql)) {
//
//            while (!resultSet.next()){
//                return false;
//            }
//            return true;
//        } catch (SQLException e) {
//            logger.error("Check login exeption",e);
//        }
//
//        throw  new Exception("Check login exeption");
//    }
}
