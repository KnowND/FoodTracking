package DAO;

import DTO.Food;

import java.util.List;

/**
 * Created by edik2 on 17.01.2018.
 */
public interface FoodDAO{
    /**
     * Add record to Food table
     *
     * @param food
     * @return int 1 if record added 0 if dont
     */
    int addFood(Food food);
    /**
     * Get all similar records from Food table by food name
     *
     * @param name
     * @return List of Food
     */
    List<Food> getAllFoodByName(String name);
    /**
     * Get all records from table Food
     *
     * @param accountId
     * @return List of Food
     */
    List<Food> getAllFood(int accountId, int startPos);
    List<Food> getAllFood(int accountId);

    int maxId(int accountId);

}
