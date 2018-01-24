package DTO;

/**
 * DTO object represent record in Food table in database
 */
public class Food {
    private int id;

    private String foodName;

    private int calories;

    private double proteins;

    private double grease;

    private double angularRods;
    private int accountId;

    public Food(int id, String foodName, int calories, double proteins, double grease, double angularRods) {
        this.id = id;
        this.foodName = foodName;
        this.calories = calories;
        this.proteins = proteins;
        this.grease = grease;
        this.angularRods = angularRods;
    }

    public Food(String foodName, int calories, double proteins, double grease, double angularRods) {

        this.foodName = foodName;
        this.calories = calories;
        this.proteins = proteins;
        this.grease = grease;
        this.angularRods = angularRods;
    }

    public Food(String foodName, int calories, double proteins, double grease, double angularRods, int accountId) {

        this.foodName = foodName;
        this.calories = calories;
        this.proteins = proteins;
        this.grease = grease;
        this.angularRods = angularRods;
        this.accountId = accountId;
    }

    public int getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getCalories() {
        return calories;
    }

    public double getProteins() {
        return proteins;
    }

    public double getGrease() {
        return grease;
    }

    public double getAngularRods() {
        return angularRods;
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", grease=" + grease +
                ", angularRods=" + angularRods +
                '}';
    }
}
