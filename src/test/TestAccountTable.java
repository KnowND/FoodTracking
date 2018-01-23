import DAO.AccountDAO;
import DAO.connection.DataSourcePool;
import DAO.impl.AccountDAOImpl;
import DTO.Account;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

/**
 * Created by edik2 on 23.01.2018.
 */
public class TestAccountTable {

    Account account;

    AccountDAO accountDao;
    DataSource dataSource;

    @Before
    public void init() {
        DataSource dataSource = DataSourcePool.INSTANCE.getDS();
        account = new Account("Ivan", "Ivanov", "login3", "password", 34, 89,187,3,2000,"male");
        accountDao = new AccountDAOImpl(dataSource);
    }

    @Test
    public void addAccountTest() {
//        account = new Account("Ivan", "Ivanov", "login", "password", 34, 89,187,3,2000);

//        assertTrue(accountDao.addAccount(account));

    }
}
