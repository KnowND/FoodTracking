package DAO;

import DTO.Account;

/**
 * Created by edik2 on 17.01.2018.
 */
public interface AccountDAO{
    /**
     * Add record to Account table
     *
     * @param account
     * @return int 1 if record added 0 if dont
     */
    int addAccount(Account account);
    /**
     * Get record from account table by login, cast it to Account DTO object
     *
     * @param login
     * @return Account
     */
    Account findByLogin(String login);

//    boolean checkLogin(String login) throws Exception;



}
