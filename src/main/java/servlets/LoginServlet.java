package servlets;

import dao.AccountDao;
import model.Account;
import model.Food;
import utils.ResourceManager;
import static utils.Massages.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edik2 on 14.01.2018.
 */
public class LoginServlet extends HttpServlet {

    AccountDao accountDao;
    ResourceManager resourceManager;

    @Override
    public void init() throws ServletException {
        accountDao = new AccountDao();
        resourceManager = ResourceManager.INSTANCE;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("login_page", resourceManager.getString(LOGIN_PAGE));
        req.setAttribute("login", resourceManager.getString(LOGIN));
        req.setAttribute("password", resourceManager.getString(PASSWORD));
        req.setAttribute("enter", resourceManager.getString(ENTER));
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");

        String password = req.getParameter("password");
        try {

            Account account = accountDao.findByLogin(login);
            if (account != null && account.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("login", login);
                session.setAttribute("login_id", account.getId());
                session.setAttribute("norma", account.getNorma());
                resp.sendRedirect("/");

            } else {
                req.setAttribute("error_login", resourceManager.getString(INCORRECT_LOGIN));
//                req.getRequestDispatcher("/login").forward(req,resp);
//                resp.sendRedirect("/login");
                doGet(req,resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
