package controller.command.impl;

import DAO.FoodIntakeDAO;
import DTO.FoodIntake;
import controller.command.Command;
import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FoodIntakeListGetCommand implements Command {

    private FoodIntakeDAO foodIntakeDAO;
    public FoodIntakeListGetCommand(FoodIntakeDAO foodIntakeDAO){
        this.foodIntakeDAO = foodIntakeDAO;
    }
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Object account = req.getSession().getAttribute("accountId");
        DateTime dateTime = new DateTime();
        if (account != null){
            int accountId = Integer.parseInt(account.toString());
            List<FoodIntake> foodIntakes = new ArrayList<>();
            foodIntakes.addAll(foodIntakeDAO.getAllFoodIntakeForDay(accountId));
            req.setAttribute("foodintakes", foodIntakes);
            req.getRequestDispatcher("foodintakes.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/");
        }
    }
}
