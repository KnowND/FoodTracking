package servlets;

import dao.FoodDao;
import utils.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static utils.Massages.*;

/**
 * Created by edik2 on 16.01.2018.
 */
public class IndexServlet extends HttpServlet{

    FoodDao foodDao;
    ResourceManager resourceManager;

    @Override
    public void init() throws ServletException {

        foodDao = new FoodDao();
        resourceManager = ResourceManager.INSTANCE;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("welcome1", resourceManager.getString(WELCOME1));
        req.setAttribute("welcome2", resourceManager.getString(WELCOME2));
        req.setAttribute("login_page", resourceManager.getString(LOGIN_PAGE));
        req.setAttribute("registration", resourceManager.getString(REGISTRATION));
        req.setAttribute("food_list", resourceManager.getString(FOOD_LIST));

        Object norma = req.getSession().getAttribute("norma");
        if (norma != null){
            int caloriesNorma = Integer.parseInt(norma.toString());
            int accountId = Integer.parseInt(req.getSession().getAttribute("login_id").toString());
            try {
                int takingCalories = foodDao.getTakingCaloriesByDay(accountId);
                req.setAttribute("taking_calories", takingCalories);
                if (takingCalories > caloriesNorma){
                    req.setAttribute("massage", resourceManager.getString(MUCH_CALORIES));
                }else {
                    req.setAttribute("massage", resourceManager.getString(NORM_CALORIES));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        req.getRequestDispatcher("index2.jsp").forward(req,resp);

    }
}
