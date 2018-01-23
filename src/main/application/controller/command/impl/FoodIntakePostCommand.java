package controller.command.impl;

import DAO.FoodIntakeDAO;
import DTO.FoodIntake;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by edik2 on 21.01.2018.
 */
public class FoodIntakePostCommand implements Command {

    private FoodIntakeDAO foodIntakeDAO;

    public FoodIntakePostCommand(FoodIntakeDAO foodIntakeDAO) {
        this.foodIntakeDAO = foodIntakeDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Object account = req.getSession().getAttribute("accountId");

        if (account != null) {
            int loginId = Integer.parseInt(req.getSession().getAttribute("accountId").toString());
            int norma = Integer.parseInt(req.getSession().getAttribute("norma").toString());

            int foodId = Integer.parseInt(req.getParameter("id"));
            int grams = Integer.parseInt(req.getParameter("grams"));
            int calories = Integer.parseInt(req.getParameter("calories"));
            calories = calories / 100 * grams;

            FoodIntake foodIntake = new FoodIntake(loginId, foodId, grams, calories);
            foodIntakeDAO.addFoodIntake(foodIntake);
            int caloriesForNow = foodIntakeDAO.getTakingCaloriesByDay(loginId);
            req.getSession().setAttribute("moreNorma", norma - caloriesForNow);

            resp.sendRedirect("/selectfood");
        } else {
            resp.sendRedirect("/");
        }
    }
}
