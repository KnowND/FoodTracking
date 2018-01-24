package DAO.impl;

import DAO.FoodDAO;
import DTO.Food;
import org.junit.Before;
import org.junit.Test;

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
        foodDAO = new FoodDAOImpl(dataSource.getDS());
        food1 = new Food(name1, 213, 21.4,14.5,11.1,1);
        food2 = new Food(name2, 123, 5,11,17,1);
        food3 = new Food(name3, 145, 2,10,31,1);
        food4 = new Food(name4, 100, 0.8,0.2,14,1);
        food5 = new Food(name5, 90, 0.6,0.1,10,1);
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
        test_addFood();
        foods.addAll(foodDAO.getAllFood(1));


        assertEquals(names.get(0),foods.get(0).getFoodName());
        assertEquals(names.get(1),foods.get(1).getFoodName());
        assertEquals(names.get(2),foods.get(2).getFoodName());
        assertEquals(names.get(3),foods.get(3).getFoodName());
        assertEquals(names.get(4),foods.get(4).getFoodName());

    }

    @Test
    public void test_checkNumberOfRecords(){
        test_addFood();
        assertEquals(4,foodDAO.maxId(1));
    }

}
