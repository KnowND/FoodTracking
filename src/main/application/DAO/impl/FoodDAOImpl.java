package DAO.impl;

import DTO.Food;
import DAO.FoodDAO;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by edik2 on 20.01.2018.
 */
public class FoodDAOImpl implements FoodDAO {

    private final static Logger logger = Logger.getLogger(FoodDAOImpl.class);

    private DataSource dataSource;

    public FoodDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Food getById(int id) {
        return null;
    }

    public boolean addFood(Food food, int accountId) {
        String sql = "INSERT INTO food( foodname, calories, proteins, grease, angularrods, account_id) VALUES (?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, food.getFoodName());
            preparedStatement.setDouble(2, food.getCalories());
            preparedStatement.setDouble(3, food.getProteins());
            preparedStatement.setDouble(4, food.getGrease());
            preparedStatement.setDouble(5, food.getAngularRods());
            preparedStatement.setDouble(6, accountId);
            return preparedStatement.execute();
        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error adding record to table Food", e);
        }

        return false;

    }

    public Food getFoodByName(String name) {
        String sql = "SELECT id, foodname, calories, proteins, grease, angularrods FROM food WHERE foodname = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Food(resultSet.getInt("id"), resultSet.getString("foodname"), resultSet.getInt("calories"), resultSet.getDouble("proteins"), resultSet.getDouble("grease"), resultSet.getDouble("angularrods"));
            }
            return null;

        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error finding Food by name", e);
        }
        return null;

    }

    public List<Food> getAllFood(int accountId) {
        String sql = "SELECT id, foodname, calories, proteins, grease, angularrods FROM food WHERE account_id IS NULL OR account_id = " + accountId;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
        ) {
            List<Food> foodList = new ArrayList<Food>();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Food food = new Food(resultSet.getInt("id"), resultSet.getString("foodname"), resultSet.getInt("calories"), resultSet.getDouble("proteins"), resultSet.getDouble("grease"), resultSet.getDouble("angularrods"));
                foodList.add(food);
            }
            return foodList;
        } catch (SQLException e) {
//            e.printStackTrace();
                logger.error("Error getting all records from Food table", e);
        }
        return null;
    }
}
