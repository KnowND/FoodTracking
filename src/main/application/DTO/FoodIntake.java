package DTO;

import java.util.Date;

/**
 *  * DTO object represent record in FoodIntake table in database
 */
public class FoodIntake {

    private int id;

    private int accountId;

    private int foodId;

    private Date date;

    private int grams;

    private int calories;

    public FoodIntake(int id, int accountId, int foodId, int grams, int calories, Date date) {
        this.id = id;
        this.accountId = accountId;
        this.foodId = foodId;
        this.date = date;
        this.grams = grams;
        this.calories = calories;
    }

    public FoodIntake(int accountId, int foodId, int grams, int calories, Date date) {

        this.accountId = accountId;
        this.foodId = foodId;
        this.date = date;
        this.grams = grams;
        this.calories = calories;
    }

    public FoodIntake(int accountId, int foodId, int grams, int calories) {

        this.accountId = accountId;
        this.foodId = foodId;
        this.grams = grams;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getFoodId() {
        return foodId;
    }

    public Date getDate() {
        return date;
    }

    public int getGrams() {
        return grams;
    }

    public int getCalories() {
        return calories;
    }

}
