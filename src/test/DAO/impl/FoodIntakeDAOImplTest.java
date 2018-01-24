package DAO.impl;

import DAO.AccountDAO;
import DAO.FoodDAO;
import DAO.FoodIntakeDAO;
import DTO.Account;
import DTO.Food;
import DTO.FoodIntake;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by edik2 on 24.01.2018.
 */
public class FoodIntakeDAOImplTest extends BaseDAOTest {

    FoodIntake foodIntake1;
    FoodIntake foodIntake2;
    FoodIntake foodIntake3;
    FoodIntake foodIntake4;
    FoodIntake foodIntake5;
    FoodIntakeDAO foodIntakeDAO;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    private FoodDAO foodDAO;
    private Food food1;
    private Food food2;
    private Food food3;
    private Food food4;
    private Food food5;
    private AccountDAO accountDAO;
    private Account account0;
    int accountId;

    @Before
    public void startUp() {
        name1 = "Гречка";
        name2 = "Рис";
        name3 = "Макарони";
        name4 = "Абрикоси";
        name5 = "Кавун";

        accountDAO = new AccountDAOImpl(dataSource.getDS());
        account0 = new Account(00, "Ivan", "Ivanov", "login3", "password", 34, 89, 187, 1.25, 2000, "male");
        accountDAO.addAccount(account0);
        accountId = accountDAO.findByLogin("login3").getId();
        foodDAO = new FoodDAOImpl(dataSource.getDS());
        food1 = new Food(name1, 213, 21.4, 14.5, 11.1,accountId );
        food2 = new Food(name2, 123, 5, 11, 17, accountId);
        food3 = new Food(name3, 145, 2, 10, 31, accountId);
        food4 = new Food(name4, 100, 0.8, 0.2, 14, accountId);
        food5 = new Food(name5, 90, 0.6, 0.1, 10, accountId);

        foodDAO.addFood(food1);
        foodDAO.addFood(food2);
        foodDAO.addFood(food3);
        foodDAO.addFood(food4);
        foodDAO.addFood(food5);

        foodIntakeDAO = new FoodIntakeDAOImpl(dataSource.getDS());
        foodIntake1 = new FoodIntake(accountId, foodDAO.getAllFoodByName(name1).get(0).getId(), 100, 123);
        foodIntake2 = new FoodIntake(accountId, foodDAO.getAllFoodByName(name2).get(0).getId(), 120, 167);
        foodIntake3 = new FoodIntake(accountId, foodDAO.getAllFoodByName(name3).get(0).getId(), 102, 300);
        foodIntake4 = new FoodIntake(accountId, foodDAO.getAllFoodByName(name4).get(0).getId(), 232, 456);
        foodIntake5 = new FoodIntake(accountId, foodDAO.getAllFoodByName(name5).get(0).getId(), 154, 267);




    }

    @After
    public void tearDown() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate("DELETE FROM food_intake");
            stmt.executeUpdate("DELETE FROM food");
            stmt.executeUpdate("DELETE FROM account");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test_addFoodIntakeTest() {
//         new AccountDAOImplTest().test_addAccount();

        assertEquals(1, foodIntakeDAO.addFoodIntake(foodIntake1));
        assertEquals(1, foodIntakeDAO.addFoodIntake(foodIntake2));
        assertEquals(1, foodIntakeDAO.addFoodIntake(foodIntake3));
        assertEquals(1, foodIntakeDAO.addFoodIntake(foodIntake4));
        assertEquals(1, foodIntakeDAO.addFoodIntake(foodIntake5));
    }

    @Test
    public void test_getAllFoodIntakeForDay() {
        foodIntakeDAO.addFoodIntake(foodIntake1);
        foodIntakeDAO.addFoodIntake(foodIntake2);
        foodIntakeDAO.addFoodIntake(foodIntake3);
        foodIntakeDAO.addFoodIntake(foodIntake4);
        foodIntakeDAO.addFoodIntake(foodIntake5);
        List<FoodIntake> foodIntakes = new ArrayList<>();
        foodIntakes.addAll(foodIntakeDAO.getAllFoodIntakeForDay(accountId));
        assertEquals(5, foodIntakes.size());
    }

    @Test
    public void test_getTakingCaloriesByDay() {
        foodIntakeDAO.addFoodIntake(foodIntake1);
        foodIntakeDAO.addFoodIntake(foodIntake2);
        foodIntakeDAO.addFoodIntake(foodIntake3);
        foodIntakeDAO.addFoodIntake(foodIntake4);
        foodIntakeDAO.addFoodIntake(foodIntake5);
        assertEquals(1313, foodIntakeDAO.getTakingCaloriesByDay(accountId));
    }

}
