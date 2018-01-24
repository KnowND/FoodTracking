package DAO.impl;

import DAO.FoodIntakeDAO;
import DTO.FoodIntake;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void startUp(){
        foodIntakeDAO = new FoodIntakeDAOImpl(dataSource.getDS());
        foodIntake1 = new FoodIntake(1,2,100,123);
        foodIntake2 = new FoodIntake(1,3,120,167);
        foodIntake3 = new FoodIntake(1,4,102,300);
        foodIntake4 = new FoodIntake(1,5,232,456);
        foodIntake5 = new FoodIntake(1,6,154,267);
    }

    @Test
    public void test_addFoodIntakeTest(){
        assertEquals(1,foodIntakeDAO.addFoodIntake(foodIntake1));
        assertEquals(1,foodIntakeDAO.addFoodIntake(foodIntake2));
        assertEquals(1,foodIntakeDAO.addFoodIntake(foodIntake3));
        assertEquals(1,foodIntakeDAO.addFoodIntake(foodIntake4));
        assertEquals(1,foodIntakeDAO.addFoodIntake(foodIntake5));
    }

    @Test
    public void test_getAllFoodIntakeForDay(){
        List<FoodIntake> foodIntakes = new ArrayList<>();
        foodIntakes.addAll(foodIntakeDAO.getAllFoodIntakeForDay(1));
        assertEquals(1,foodIntakes.size());
    }

    @Test
    public void test_getTakingCaloriesByDay(){
        test_addFoodIntakeTest();
        assertEquals(1313,foodIntakeDAO.getTakingCaloriesByDay(1));
    }

}
