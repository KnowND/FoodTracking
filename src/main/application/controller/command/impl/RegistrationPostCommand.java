package controller.command.impl;

import DAO.AccountDAO;
import DTO.Account;
import controller.command.Command;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static utils.Massages.BUSY;

/**
 * Created by edik2 on 21.01.2018.
 */
public class RegistrationPostCommand implements Command {

    private static final Logger logger = Logger.getLogger(RegistrationPostCommand.class);

    AccountDAO accountDAO;

    public RegistrationPostCommand(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Object account = req.getSession().getAttribute("accountId");

        if (account == null) {


            String login = req.getParameter("login");
            if (accountDAO.findByLogin(login) != null) {
                req.getSession().setAttribute("busy", resourceManager.getString(BUSY));
//                req.getRequestDispatcher("registration.jsp").forward(req, resp);
                resp.sendRedirect("/registration");
            } else {
                req.getSession().setAttribute("busy", null);

                String name = req.getParameter("name");
                String surname = req.getParameter("surname");
                String password = req.getParameter("password");
                String gender = req.getParameter("gender");
                int age = Integer.parseInt(req.getParameter("age"));
                int weight = Integer.parseInt(req.getParameter("weight"));
                int height = Integer.parseInt(req.getParameter("height"));
                double wol = Double.parseDouble(req.getParameter("wol"));
                int norm;
                if (gender.equals("male")) {
                    norm = (int) ((88.36 + 13.4 * weight + 4.8 * height - 5.7 * age) * wol);
                } else {
                    norm = (int) ((447.6 + 9.2 * weight + 3.1 * height - 4.3 * age) * wol);
                }

                req.setAttribute("busy", null);


                Account user = new Account(name, surname, login, password, age, weight, height, wol, norm, gender);

                accountDAO.addAccount(user);
//                    logger.error("Dont add record to Account table");
//                    throw new Exception("Dont add record to Account table");

                int accountId = accountDAO.findByLogin(login).getId();
                req.getSession().setAttribute("accountId", accountId);
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("norma", norm);

                resp.sendRedirect("/");
            }
        }



//        super.doPost(req, resp);
    }
}
