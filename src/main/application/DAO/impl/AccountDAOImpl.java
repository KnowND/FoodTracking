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

    /**
     * Add record to Account table
     *
     * @param account
     * @return int 1 if record added 0 if dont
     */
    public int addAccount(Account account) {

        String sql = "INSERT INTO account(first_name, second_name, login, password, height, weight, way_of_life, age, norm, gender) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            String name = account.getFirstName();
            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getSecondName());
            preparedStatement.setString(3, account.getLogin());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setInt(5, account.getHeight());
            preparedStatement.setInt(6, account.getWeight());
            preparedStatement.setDouble(7, account.getWayOfLife());
            preparedStatement.setInt(8, account.getAge());
            preparedStatement.setInt(9, account.getNorma());
            preparedStatement.setString(10, account.getGender());
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error adding record to Account table ", e);

        }
        return 0;
    }

    /**
     * Get record from account table by login, cast it to Account DTO object
     *
     * @param login
     * @return Account
     */
    public Account findByLogin(String login) {

        String sql = "SELECT id, first_name, second_name, password, norm FROM account WHERE login = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
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
}
