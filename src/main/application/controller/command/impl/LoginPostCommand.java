package controller.command.impl;

import DAO.AccountDAO;
import DTO.Account;
import controller.command.Command;
import utils.ResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static utils.Massages.*;

/**
 * Created by edik2 on 21.01.2018.
 */
public class LoginPostCommand implements Command {

    AccountDAO accountDAO;

    public LoginPostCommand(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    /**
     * Get request parameters from login.jsp, parse them,
     * try find users login in table Account if found compare passwords
     * if passwords equals set session attributes "login", "accountId", "norma",
     * else return to previous page with error massage
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Object accountId = req.getSession().getAttribute("accountId");

        if (accountId == null) {

            String login = req.getParameter("login");
            String password = req.getParameter("password");

            Account account = accountDAO.findByLogin(login);

            if (account != null && account.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("login", login);
                session.setAttribute("accountId", account.getId());
                session.setAttribute("norma", account.getNorma());
                req.getSession().setAttribute("error_login", null);
                resp.sendRedirect("/");
//            session.setAttribute("entered","yes");

            } else {

                req.getSession().setAttribute("error_login", resourceManager.getString(INCORRECT_LOGIN));
                resp.sendRedirect("/login");
            }
        }else {
            resp.sendRedirect("/");
        }

    }
}
