package DTO;

/**
 * DTO object represent record in Account table in database
 *
 */
public class Account {

    private int id;

    private String firstName;

    private String secondName;

    private String login;

    private String password;

    private String gender;

    private int age;

    private int weight;

    private int height;

    private double wayOfLife;

    private int norma;

    public Account(int id, String firstName, String secondName, String login, String password,
                   int age, int weight, int height, double wayOfLife, int norma, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.wayOfLife = wayOfLife;
        this.norma = norma;
        this.gender = gender;
    }

    public Account(String firstName, String secondName, String login, String password, int norma){
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.norma = norma;
    }

    public Account(int id, String firstName, String secondName, String login, String password, int norma){
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.norma = norma;
    }

    public Account(String firstName, String secondName, String login, String password,
                   int age, int weight, int height, double wayOfLife, int norma, String gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.wayOfLife = wayOfLife;
        this.norma = norma;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public double getWayOfLife() {
        return wayOfLife;
    }

    public int getNorma() {
        return norma;
    }
}
