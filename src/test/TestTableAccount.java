import dao.AccountDao;
import model.Account;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by edik2 on 09.01.2018.
 */
public class TestTableAccount {
    Account account;

    AccountDao accountDao;

    @Before
    public void init() {
        account = new Account("Ivan", "Ivanov", "login", "password", 34, 89,187,3,2000);
        accountDao = new AccountDao();
    }

    @Test
    public void addAccountTest() {
        account = new Account("Ivan", "Ivanov", "login", "password", 34, 89,187,3,2000);
        try {

            assertTrue(accountDao.addAccount(account) == 1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByLoginTest(){
        try {
            Account account1 = accountDao.findByLogin("login");
            assertEquals(" ","login",account1.getLogin());

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
