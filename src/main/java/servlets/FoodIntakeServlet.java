package servlets;

import dao.AccountDao;
import dao.FoodDao;
import model.Account;
import model.Food;
import model.FoodIntake;
import utils.ResourceManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.Massages.*;

/**
 * Created by edik2 on 14.01.2018.
 */
public class FoodIntakeServlet extends HttpServlet {

    AccountDao accountDao;
    FoodDao foodDao;
    ResourceManager resourceManager;

    @Override
    public void init() throws ServletException {
        accountDao = new AccountDao();
        foodDao = new FoodDao();
        resourceManager = ResourceManager.INSTANCE;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        String name = req.getParameter("name");
//        String calories = req.getParameter("calories");
//
//        req.setAttribute("id", id);
//        req.setAttribute("name", name);
//        req.setAttribute("calories",calories);
        req.setAttribute("grams", resourceManager.getString(GRAMS));
        req.setAttribute("enter", resourceManager.getString(ENTER));
        req.getRequestDispatcher("/foodIntake.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int loginId = Integer.parseInt(req.getSession().getAttribute("login_id").toString());
        int norma = Integer.parseInt(req.getSession().getAttribute("norma").toString());

        int foodId = Integer.parseInt(req.getParameter("id"));
        int grams = Integer.parseInt(req.getParameter("grams"));
        int calories = Integer.parseInt(req.getParameter("calories"));
        calories = calories / 100 * grams;

        FoodIntake foodIntake = new FoodIntake(loginId,foodId,grams,calories);
        try {
            foodDao.addFoodIntake(foodIntake);
            int caloriesForNow = foodDao.getTakingCaloriesByDay(loginId);
            req.getSession().setAttribute("moreNorma", norma - caloriesForNow);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/selectFood");


    }
}
