package servlets;

import dao.AccountDao;
import dao.FoodDao;
import model.Food;
import utils.ResourceManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static utils.Massages.*;

/**
 * Created by edik2 on 09.01.2018.
 */
public class NewFoodServlet extends HttpServlet {

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
        req.setAttribute("name", resourceManager.getString(NAME_FOOD));
        req.setAttribute("calories", resourceManager.getString(CALORIES));
        req.setAttribute("grease", resourceManager.getString(GREASE));
        req.setAttribute("proteins", resourceManager.getString(PROTEINS));
        req.setAttribute("angularrods", resourceManager.getString(ANGULAR_RODS));
        req.setAttribute("addfood", resourceManager.getString(ADD_FOOD));
        req.getRequestDispatcher("newFood.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int calories = Integer.parseInt(req.getParameter("calories"));
        double proteins = Double.parseDouble(req.getParameter("proteins"));
        double grease = Double.parseDouble(req.getParameter("grease"));
        double angularRodes = Double.parseDouble(req.getParameter("angularRods"));

        Food food = new Food(name, calories, proteins, grease, angularRodes);

        try {
            foodDao.addFood(food);
//            req.getRequestDispatcher("/selectFood").forward(req,resp);
            resp.sendRedirect("/selectFood");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
