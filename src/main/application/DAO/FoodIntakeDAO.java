package DAO;

import DTO.FoodIntake;

import java.util.List;

/**
 * Created by edik2 on 17.01.2018.
 */
public interface FoodIntakeDAO extends GenericDAO {

    boolean addFoodIntake(FoodIntake foodIntake);

    List<FoodIntake> getAllFoodIntakeForDay(int accountId);

    int getTakingCaloriesByDay(int accountId);



}
