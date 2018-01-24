package controller.command.impl;

import DAO.FoodIntakeDAO;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static controller.util.Massages.*;

/**
 * Created by edik2 on 21.01.2018.
 */
public class IndexGetCommand implements Command {

    private FoodIntakeDAO foodIntakeDAO;

    public IndexGetCommand(FoodIntakeDAO foodIntakeDAO) {
        this.foodIntakeDAO = foodIntakeDAO;
    }

    /**
     * Return amount of calorie taking by user today
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("welcome1", resourceManager.getString(WELCOME1));
        req.setAttribute("welcome2", resourceManager.getString(WELCOME2));
        req.setAttribute("login_page", resourceManager.getString(LOGIN_PAGE));
        req.setAttribute("registration", resourceManager.getString(REGISTRATION));
        req.setAttribute("food_list", resourceManager.getString(FOOD_LIST));
        req.setAttribute("language", resourceManager.getString(LANGUAGE));
        req.setAttribute("exit", resourceManager.getString(EXIT));
        req.setAttribute("enter", resourceManager.getString(ENTER));
        req.setAttribute("registration", resourceManager.getString(REGISTRATION));

        req.getSession().setAttribute("lang","ua");

        Object norma = req.getSession().getAttribute("norma");
        if (norma != null) {

            int caloriesNorma = Integer.parseInt(norma.toString());
            int accountId = Integer.parseInt(req.getSession().getAttribute("accountId").toString());
            int takingCalories = foodIntakeDAO.getTakingCaloriesByDay(accountId);
            req.setAttribute("taking_calories", takingCalories);

            if (takingCalories > caloriesNorma) {
                req.setAttribute("massage", resourceManager.getString(MUCH_CALORIES));
            } else {
                req.setAttribute("massage", resourceManager.getString(NORM_CALORIES));
            }

        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
