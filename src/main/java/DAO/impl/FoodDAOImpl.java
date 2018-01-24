package DAO.impl;

import DTO.Food;
import DAO.FoodDAO;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static controller.util.Massages.count;


/**
 * Created by edik2 on 20.01.2018.
 */
public class FoodDAOImpl implements FoodDAO {

    private final static Logger logger = Logger.getLogger(FoodDAOImpl.class);

    private DataSource dataSource;

    public FoodDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Add record to Food table
     *
     * @param food
     * @return int 1 if record added 0 if dont
     */
    public int addFood(Food food) {
        String sql = "INSERT INTO food( foodname, calories, proteins, grease, angularrods, account_id) VALUES (?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, food.getFoodName());
            preparedStatement.setDouble(2, food.getCalories());
            preparedStatement.setDouble(3, food.getProteins());
            preparedStatement.setDouble(4, food.getGrease());
            preparedStatement.setDouble(5, food.getAngularRods());
            preparedStatement.setDouble(6, food.getAccountId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error adding record to table Food", e);
        }
        return 0;
    }

    /**
     * Get all similar records from Food table by food name
     *
     * @param name
     * @return List of Food
     */
    public List<Food> getAllFoodByName(String name) {
        String sql = "SELECT id, foodname, calories, proteins, grease, angularrods FROM food WHERE LOWER(foodname) = LOWER(?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, name);
            List<Food> foods = new ArrayList<>();
            Food food;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                food = new  Food(resultSet.getInt("id"), resultSet.getString("foodname"), resultSet.getInt("calories"), resultSet.getDouble("proteins"), resultSet.getDouble("grease"), resultSet.getDouble("angularrods"));
                foods.add(food);

            }
            return foods;

        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error finding Food by name", e);
        }
        return null;

    }

    /**
     * Get all records from table Food
     *
     * @param accountId
     * @return List of Food
     */
    public List<Food> getAllFood(int accountId, int startPos) {
        String sql = "SELECT id, foodname, calories, proteins, grease, angularrods FROM food WHERE account_id IS NULL OR account_id = ? AND id >= ? AND id <= ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            List<Food> foodList = new ArrayList<Food>();
            preparedStatement.setInt(1,accountId);
            preparedStatement.setInt(1,startPos);
            preparedStatement.setInt(1,startPos + count);
            ResultSet resultSet = preparedStatement.executeQuery();
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

    public List<Food> getAllFood(int accountId) {
        String sql = "SELECT id, foodname, calories, proteins, grease, angularrods FROM food WHERE account_id IS NULL OR account_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            List<Food> foodList = new ArrayList<Food>();
            preparedStatement.setInt(1,accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
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

    @Override
    public int maxId(int accountId) {
        String sql = "SELECT MAX(id) FROM food WHERE account_id IS NULL OR account_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1,accountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error getting max index record from Food table", e);
        }
        return 0;
    }
}
