import dao.AccountDao;
import dao.FoodDao;
import model.Account;
import model.Food;
import model.FoodIntake;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by edik2 on 09.01.2018.
 */
public class TestTableFood {

    Food food;

    FoodDao foodDao;
    FoodIntake foodIntake;
    AccountDao accountDao;

    @Before
    public void init() {
        foodDao = new FoodDao();
        food = new Food("Гречка", 100, 12d, 21d, 32d);
        foodIntake = new FoodIntake(1,2,112,300,new java.sql.Date(System.currentTimeMillis()));
        accountDao = new AccountDao();
    }

    @Test
    public void addFoodTest() {
        try {

            assertTrue(foodDao.addFood(food) == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void addFoodIntakeTest() {
        try {
            foodDao.addFoodIntake(foodIntake);
        //    assertTrue(foodDao.addFood(food) == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void getFoodIntakeTest() {

        try {
            List<FoodIntake> foodIntakes = foodDao.getAllFoodIntakeForDay(1);
            int i = 0;
            i++;
            System.out.println(i);
        //    assertTrue(foodDao.addFood(food) == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void getCaloriesTest() {

        try {
            int calories = foodDao.getTakingCaloriesByDay(1);
            int i = 0;
            i++;
            System.out.println(i);
        //    assertTrue(foodDao.addFood(food) == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void getFoodByNameTest() {

        try {
            Food food1 = foodDao.getFoodByName("Гречка");
            int i = 0;
        //    assertTrue(foodDao.addFood(food) == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
/*

    @Test
    public void GetAllFoodTest() {
        List<Food> foodList = new ArrayList<Food>();
        try {

            if (foodDao.addFood(food) == 1) System.out.println("+++");
           foodList.addAll(foodDao.getAllFood());
           for(Food foodIntake:foodList){
               System.out.println(foodIntake);}

            foodDao.delateFood(food);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void DeleteFoodTest() {
        food = new Food("Гречка", 100.1, 12d, 21d, 32d);
        List<Food> foodList = new ArrayList<Food>();
        try {
            if (foodDao.addFood(food) == 1) System.out.println("+++");
//           foodList.addAll(foodDao.getAllFood());
//           for(Food foodIntake:foodList){
//               System.out.println(foodIntake);}

//            foodDao.delateFood(food);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


*/
}

