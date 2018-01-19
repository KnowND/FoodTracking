package servlets;

import dao.AccountDao;
import model.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by edik2 on 07.01.2018.
 */

public class RegistrationServlet extends HttpServlet {

    AccountDao accountDao;

    @Override
    public void init() throws ServletException {
        accountDao = new AccountDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("newAccount.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        int height = Integer.parseInt(req.getParameter("height"));
        int wol = Integer.parseInt(req.getParameter("wol"));
        int norm = weight * height;

        Account account = new Account(name, surname, login, password, age, weight, height, wol, norm);
        try {
            accountDao.addAccount(account);

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        RequestDispatcher rd = req.getRequestDispatcher("newFood.jsp");
//        rd.forward(req,resp);
        resp.sendRedirect("/newFood.jsp");

//        super.doPost(req, resp);
    }
}
