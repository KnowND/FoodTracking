package DAO;

import DTO.Account;

/**
 * Created by edik2 on 17.01.2018.
 */
public interface AccountDAO extends GenericDAO {

    void addAccount(Account account);

    Account findByLogin(String login);

//    boolean checkLogin(String login) throws Exception;



}
