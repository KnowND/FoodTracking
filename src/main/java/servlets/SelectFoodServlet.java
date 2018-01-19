package servlets;

import dao.AccountDao;
import dao.FoodDao;
import model.Food;
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
import java.util.Properties;

import static utils.Massages.*;

/**
 * Created by edik2 on 15.01.2018.
 */
public class SelectFoodServlet extends HttpServlet {

    FoodDao foodDao;
    ResourceManager resourceManager;

    @Override
    public void init() throws ServletException {

        foodDao = new FoodDao();
        resourceManager = ResourceManager.INSTANCE;


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Food> foodList = new ArrayList<Food>();
        try {
            foodList.addAll(foodDao.getAllFood());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("name", resourceManager.getString(NAME_FOOD));
        req.setAttribute("calories", resourceManager.getString(CALORIES));
        req.setAttribute("grease", resourceManager.getString(GREASE));
        req.setAttribute("angular_rods", resourceManager.getString(ANGULAR_RODS));
        req.setAttribute("proteins", resourceManager.getString(PROTEINS));
        req.setAttribute("search", resourceManager.getString(SEARCH));
        req.setAttribute("foodList", foodList);
//        req.setAttribute("search", null);


        RequestDispatcher requestDispatcher = req.getRequestDispatcher("selectFood.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String foodName = req.getParameter("search_food");
        try {
            Food searchFood = foodDao.getFoodByName(foodName);
            if (searchFood != null){
                List<Food> foodList = new ArrayList<Food>();
                foodList.add(searchFood);

                req.setAttribute("foodList", foodList);
//                req.setAttribute("search", " ");
                req.getRequestDispatcher("selectFood.jsp").forward(req,resp);
//                resp.sendRedirect("/selectFood");
            }else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
