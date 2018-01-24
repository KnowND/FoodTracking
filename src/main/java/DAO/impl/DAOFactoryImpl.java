package DAO.impl;

import DAO.AccountDAO;
import DAO.DAOFactory;
import DAO.FoodDAO;
import DAO.FoodIntakeDAO;
import DTO.FoodIntake;

import javax.sql.DataSource;

/**
 * Created by edik2 on 22.01.2018.
 */
public enum DAOFactoryImpl implements DAOFactory{

    INSTANCE;


    public AccountDAO createAccountDAO(DataSource dataSource) {
        return new AccountDAOImpl(dataSource);
    }


    public FoodDAO createFoodDAO(DataSource dataSource) {
        return new FoodDAOImpl(dataSource);
    }


    public FoodIntakeDAO createFoodIntakeDAO(DataSource dataSource) {
        return new FoodIntakeDAOImpl(dataSource);
    }
}
