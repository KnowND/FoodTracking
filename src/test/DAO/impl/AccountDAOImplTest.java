package DAO.impl;

import DAO.AccountDAO;
import DTO.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by edik2 on 23.01.2018.
 */
public class AccountDAOImplTest extends BaseDAOTest {

    private AccountDAO accountDAO;
    private Account account0;

    @Before
    public void startUp(){
        accountDAO = new AccountDAOImpl(dataSource.getDS());
        account0 = new Account(1,"Ivan", "Ivanov", "login3", "password", 34, 89,187,1.25,2000,"male");
    }

    @Test
    public void test_addAccount() {
//        Account account0 = null;
        assertEquals(1,accountDAO.addAccount(account0));
    }

    @Test
    public void test_findByLogin(){
        assertEquals(0,accountDAO.findByLogin("login3").getId());
    }



}
