package controller.command.impl;

import controller.command.Command;
import utils.ResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static utils.Massages.*;

/**
 * Created by edik2 on 21.01.2018.
 */
public class FoodIntakeGetCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Object account = req.getSession().getAttribute("accountId");

        if (account != null){
            req.setAttribute("grams", resourceManager.getString(GRAMS));
            req.setAttribute("add", resourceManager.getString(ADD_FOOD));
            req.getRequestDispatcher("/foodIntake.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/");
        }


    }
}