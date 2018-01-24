package DAO;

import DTO.FoodIntake;

import java.util.List;

/**
 * Created by edik2 on 17.01.2018.
 */
public interface FoodIntakeDAO{
    /**
     * Add record to FoodIntake table
     *
     * @param foodIntake
     * @return int 1 if record added 0 if dont
     */
    int addFoodIntake(FoodIntake foodIntake);
    /**
     * Get all records from FoodIntake table
     *
     * @param accountId
     * @return List of FoodIntake
     */
    List<FoodIntake> getAllFoodIntakeForDay(int accountId);
    /**
     * Get taking calories for day for some user
     *
     * @param accountId
     * @return int all calories taking user for day
     */
    int getTakingCaloriesByDay(int accountId);
}
