package DAO;

import DTO.Food;

import java.util.List;

/**
 * Created by edik2 on 17.01.2018.
 */
public interface FoodDAO extends GenericDAO {

    boolean addFood(Food food, int accountId);

    Food getFoodByName(String name);

    List<Food> getAllFood(int accountId);

}
