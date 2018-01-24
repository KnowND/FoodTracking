package DAO.impl;

import DAO.AccountDAO;
import DAO.FoodDAO;
import DTO.Account;
import DTO.Food;
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
public class FoodDAOImplTest extends BaseDAOTest {

    private FoodDAO foodDAO;
    private Food food1;
    private Food food2;
    private Food food3;
    private Food food4;
    private Food food5;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String name5;
    List<Food> foods;
    List<String> names;

    private AccountDAO accountDAO;
    private Account account0;
    int accountId;
    @Before
    public void startUp(){
        name1 = "Гречка";
        name2 = "Рис";
        name3 = "Макарони";
        name4 = "Абрикоси";
        name5 = "Кавун";
        names = new ArrayList<>();
        foods = new ArrayList<>();
        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);

        accountDAO = new AccountDAOImpl(dataSource.getDS());
        account0 = new Account(0, "Ivan", "Ivanov", "login3", "password", 34, 89, 187, 1.25, 2000, "male");
        accountDAO.addAccount(account0);
        accountId = accountDAO.findByLogin("login3").getId();

        foodDAO = new FoodDAOImpl(dataSource.getDS());
        food1 = new Food(name1, 213, 21.4,14.5,11.1,accountId);
        food2 = new Food(name2, 123, 5,11,17,accountId);
        food3 = new Food(name3, 145, 2,10,31,accountId);
        food4 = new Food(name4, 100, 0.8,0.2,14,accountId);
        food5 = new Food(name5, 90, 0.6,0.1,10,accountId);
    }

    @After
    public void tearDown() {
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate("DELETE FROM food");
            stmt.executeUpdate("DELETE FROM account");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void test_addFood(){

        assertEquals(1,foodDAO.addFood(food1));
        assertEquals(1,foodDAO.addFood(food2));
        assertEquals(1,foodDAO.addFood(food3));
        assertEquals(1,foodDAO.addFood(food4));
        assertEquals(1,foodDAO.addFood(food5));

    }

    @Test
    public void test_getFoodByName(){

        test_addFood();
        foods.addAll(foodDAO.getAllFoodByName(name1));

        assertEquals(name1,foods.get(0).getFoodName());

    }

    @Test
    public void test_getAllFood(){
//        List<Food> foods = new ArrayList<>();
        foodDAO.addFood(food1);
        foodDAO.addFood(food2);
        foodDAO.addFood(food3);
        foodDAO.addFood(food4);
        foodDAO.addFood(food5);
        foods.addAll(foodDAO.getAllFood(accountId));

        assertEquals(5,foods.size());

    }

//    @Test
//    public void test_checkNumberOfRecords(){
//        assertEquals(4,foodDAO.maxId(accountId));
//    }

}
