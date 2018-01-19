package dao;

import model.Account;
import model.Food;
import model.FoodIntake;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by edik2 on 01.01.2018.
 */
public class FoodDao {

    public int addFood(Food food) throws SQLException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int result = 0;
        try {

            String sql = "INSERT INTO food( foodname, calories, proteins, grease, angularrods) VALUES (?,?,?,?,?)";
            connection = new DatabaseConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, food.getFoodName());
            preparedStatement.setDouble(2, food.getCalories());
            preparedStatement.setDouble(3, food.getProteins());
            preparedStatement.setDouble(4, food.getGrease());
            preparedStatement.setDouble(5, food.getAngularRods());
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

    public Food getFoodById(int id) throws SQLException {
        String sql = "SELECT id, foodname, calories, proteins, grease, angularrods FROM food WHERE id = " + id ;
        Connection connection = new DatabaseConnection().getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            return new Food(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getDouble(4), resultSet.getDouble(5), resultSet.getDouble(6));
        }
        return null;
    }

    public Food getFoodByName(String name) throws SQLException {
        String sql = "SELECT id, foodname, calories, proteins, grease, angularrods FROM food WHERE foodname = ?";
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return new Food(resultSet.getInt("id"), resultSet.getString("foodname"), resultSet.getInt("calories"), resultSet.getDouble("proteins"), resultSet.getDouble("grease"), resultSet.getDouble("angularrods"));
        }
        return null;
    }


    public int delateFood(Food food) throws SQLException {
        String sql = "DELETE FROM food WHERE id = " + food.getId();
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        return preparedStatement.executeUpdate();
    }

    public List<Food> getAllFood() throws SQLException {
        String sql = "SELECT id, foodname, calories, proteins, grease, angularrods FROM food";
        Connection connection = new DatabaseConnection().getConnection();
        Statement statement = connection.createStatement();
        List<Food> foodList = new ArrayList<Food>();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Food food = new Food(resultSet.getInt("id"), resultSet.getString("foodname"), resultSet.getInt("calories"), resultSet.getDouble("proteins"), resultSet.getDouble("grease"), resultSet.getDouble("angularrods"));
            foodList.add(food);
        }
        return foodList;
    }

    public int addFoodIntake(FoodIntake food) throws SQLException {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        int result = 0;
        try {
            java.util.Date utilStartDate = new java.util.Date();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
            String sql = "INSERT INTO food_intake(food_id, account_id, grams, calories, eating_date) VALUES (?,?,?,?,?)";
            connection = new DatabaseConnection().getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, food.getFoodId());
            preparedStatement.setInt(2, food.getAccountId());
            preparedStatement.setInt(3, food.getGrams());
            preparedStatement.setInt(4, food.getCalories());
            preparedStatement.setDate(5, sqlStartDate);
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

    public List<FoodIntake> getAllFoodIntakeForDay(int accountId) throws SQLException {
        java.util.Date utilStartDate = new java.util.Date();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        String sql = "SELECT food_id, account_id, grams, calories FROM food_intake WHERE account_id = ? AND eating_date = ?";
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        List<FoodIntake> foodList = new ArrayList<FoodIntake>();
        preparedStatement.setInt(1,accountId);
        preparedStatement.setDate(2,sqlStartDate);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            FoodIntake food = new FoodIntake(resultSet.getInt("food_id"), resultSet.getInt("account_id"),
                    resultSet.getShort("grams"), resultSet.getInt("calories"));
            foodList.add(food);
        }
        return foodList;

    }

    public int getTakingCaloriesByDay(int accountId) throws SQLException {
        java.util.Date utilStartDate = new java.util.Date();
        java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());
        String sql = "SELECT calories FROM food_intake WHERE account_id = ? AND eating_date = ?";
        Connection connection = new DatabaseConnection().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,accountId);
        preparedStatement.setDate(2,sqlStartDate);
        ResultSet resultSet = preparedStatement.executeQuery();
        int calories = 0;
        while (resultSet.next()) {
            calories += resultSet.getInt("calories");
        }
            return calories;

    }

    public boolean checkDayNorma(Account account, List<FoodIntake> foods) {

        int numberOfCalories = 0;
        for (FoodIntake food : foods) {
            numberOfCalories += food.getCalories();
        }
        return account.getNorma() > numberOfCalories;
    }
}
