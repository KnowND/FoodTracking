package controller.command.impl;

import DAO.FoodDAO;
import DTO.Food;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by edik2 on 21.01.2018.
 */
public class NewFoodPostCommand implements Command {

    FoodDAO foodDAO;

    public NewFoodPostCommand(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Object account = req.getSession().getAttribute("accountId");

        if (account != null) {
            int accountId = Integer.parseInt(account.toString());
            String name = req.getParameter("name");
            int calories = Integer.parseInt(req.getParameter("calories"));
            double proteins = Double.parseDouble(req.getParameter("proteins"));
            double grease = Double.parseDouble(req.getParameter("grease"));
            double angularRodes = Double.parseDouble(req.getParameter("angularRods"));

            Food food = new Food(name, calories, proteins, grease, angularRodes);

            foodDAO.addFood(food, accountId);
            resp.sendRedirect("/selectfood");
        } else {
            resp.sendRedirect("/");
        }
    }
}
