package DAO.impl;

import DTO.FoodIntake;
import DAO.FoodIntakeDAO;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edik2 on 20.01.2018.
 */
public class FoodIntakeDAOImpl implements FoodIntakeDAO {

    private final static Logger logger = Logger.getLogger(FoodIntakeDAOImpl.class);
    private DataSource dataSource;

    public FoodIntakeDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Add record to FoodIntake table
     *
     * @param foodIntake
     * @return int 1 if record added 0 if dont
     */
    public int addFoodIntake(FoodIntake foodIntake) {

        String sql = "INSERT INTO food_intake(food_id, account_id, grams, calories, eating_date) VALUES (?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, foodIntake.getFoodId());
            preparedStatement.setInt(2, foodIntake.getAccountId());
            preparedStatement.setInt(3, foodIntake.getGrams());
            preparedStatement.setInt(4, foodIntake.getCalories());
            preparedStatement.setDate(5, getSQLDate());
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error adding record to FoodIntake table", e);
        }
        return 0;
    }

    /**
     * Get all records from FoodIntake table
     *
     * @param accountId
     * @return List of FoodIntake
     */
    public List<FoodIntake> getAllFoodIntakeForDay(int accountId) {
        String sql = "SELECT food_id, account_id, grams, calories FROM food_intake WHERE account_id = ? AND eating_date = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            List<FoodIntake> foodList = new ArrayList<FoodIntake>();
            preparedStatement.setInt(1,accountId);
            preparedStatement.setDate(2,getSQLDate());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FoodIntake food = new FoodIntake(resultSet.getInt("food_id"), resultSet.getInt("account_id"),
                        resultSet.getShort("grams"), resultSet.getInt("calories"));
                foodList.add(food);
            }
            return foodList;
        } catch (SQLException e) {
//            e.printStackTrace();
            logger.error("Error getting record from FoodIntake table for this day", e);
        }
        return null;

    }

    /**
     * Get taking calories for day for some user
     *
     * @param accountId
     * @return int all calories taking user for day
     */
    public int getTakingCaloriesByDay(int accountId) {

        String sql = "SELECT calories FROM food_intake WHERE account_id = ? AND eating_date = ?";
        int calories = 0;
        
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,accountId);
            preparedStatement.setDate(2,getSQLDate());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                calories += resultSet.getInt("calories");
            }

        } catch (SQLException e) {
            logger.error("Error getting all record from FoodIntake table", e);
        }
        return calories;
    }

    private Date getSQLDate(){
        java.util.Date utilCurrantDate = new java.util.Date();
        return new Date(utilCurrantDate.getTime());
    }
}
