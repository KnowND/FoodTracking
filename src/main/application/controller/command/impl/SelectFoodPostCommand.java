package controller.command.impl;

import DAO.FoodDAO;
import DTO.Food;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Massages.NOTHING_FOUND;
import static utils.Massages.SEARCH;

/**
 * Created by edik2 on 21.01.2018.
 */
public class SelectFoodPostCommand implements Command {

    FoodDAO foodDAO;

    public SelectFoodPostCommand(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception, SQLException {

        String foodName = req.getParameter("search_food");
        Food searchFood = foodDAO.getFoodByName(foodName);
        req.setAttribute("search", resourceManager.getString(SEARCH));

        if (searchFood != null) {
            List<Food> foodList = new ArrayList<>();
            foodList.add(searchFood);

            req.setAttribute("foodList", foodList);

//                req.setAttribute("search", " ");

            req.getRequestDispatcher("selectFood.jsp").forward(req, resp);
//                resp.sendRedirect("/selectFood");
        } else {

            req.setAttribute("nothing_found", resourceManager.getString(NOTHING_FOUND));
            req.getRequestDispatcher("selectFood.jsp").forward(req, resp);
        }

    }
}
