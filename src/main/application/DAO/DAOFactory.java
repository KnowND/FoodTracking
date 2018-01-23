package DAO;

import javax.sql.DataSource;

/**
 * Created by edik2 on 20.01.2018.
 */
public interface DAOFactory {

    AccountDAO createAccountDAO(DataSource dataSource);

    FoodDAO createFoodDAO(DataSource dataSource);

    FoodIntakeDAO createFoodIntakeDAO(DataSource dataSource);
}
