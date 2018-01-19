package dao;

import model.Account;

import java.sql.*;


/**
 * Created by edik2 on 01.01.2018.
 */
public class AccountDao {

    public int addAccount(Account account) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int result = 0;
        try {

            String sql = "INSERT INTO account(first_name, second_name, login, password, height, weight, way_of_life, age, norm) VALUES (?,?,?,?,?,?,?,?,?)";
            connection = new DatabaseConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, account.getFirstName());
            preparedStatement.setString(2, account.getSecondName());
            preparedStatement.setString(3, account.getLogin());
            preparedStatement.setString(4, account.getPassword());
            preparedStatement.setInt(5, account.getHeight());
            preparedStatement.setInt(6, account.getWeight());
            preparedStatement.setInt(7, account.getWayOfLife());
            preparedStatement.setInt(8, account.getAge());
            preparedStatement.setInt(9, account.getNorma());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    public Account findByLogin(String login) throws SQLException {
        Statement Statement = null;
        Connection connection = null;

        try {

            String sql = "SELECT id, first_name, second_name, password, norm FROM account WHERE login = " + login;
            connection = new DatabaseConnection().getConnection();
            Statement = connection.createStatement();

            ResultSet resultSet = Statement.executeQuery(sql);
            resultSet.next();
            int id = Integer.parseInt(resultSet.getString(1));
            int norm = Integer.parseInt(resultSet.getString(5));
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            String password = resultSet.getString(4);
            return new Account(id, name, surname, login, password, norm);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (Statement != null) {
                Statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

//    }public Account findByLogin(String login) throws SQLException {
//        PreparedStatement preparedStatement = null;
//        Connection connection = null;
//
//        try {
//
//            String sql = "SELECT first_name, second_name, password, norm FROM account WHERE login = ?";
//            connection = new DatabaseConnection().getConnection();
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,login);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            int norm = Integer.parseInt(resultSet.getString(4));
//            String name = resultSet.getString(1);
//            String surname = resultSet.getString("second_name");
//            String password = resultSet.getString("password");
//            return new Account(name,surname,password,norm);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if (preparedStatement != null) {
//                preparedStatement.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }
//
//    }
    }
}


