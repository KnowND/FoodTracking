package controller.command.impl;

import DAO.FoodDAO;
import DTO.Food;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static controller.util.Massages.NOTHING_FOUND;
import static controller.util.Massages.SEARCH;

/**
 * Created by edik2 on 21.01.2018.
 */
public class SelectFoodPostCommand implements Command {

    private FoodDAO foodDAO;

    public SelectFoodPostCommand(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    /**
     * Select Food DTO by name and show result to user
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception{

        String foodName = req.getParameter("search_food");
        List<Food> foodList = new ArrayList<>();

        foodList.addAll(foodDAO.getAllFoodByName(foodName));
        req.setAttribute("search", resourceManager.getString(SEARCH));

        if (foodList.size() != 0) {

            req.setAttribute("foodList", foodList);
            req.getRequestDispatcher("selectFood.jsp").forward(req, resp);
        } else {

            req.setAttribute("nothing_found", resourceManager.getString(NOTHING_FOUND));
            req.getRequestDispatcher("selectFood.jsp").forward(req, resp);
        }

    }
}
