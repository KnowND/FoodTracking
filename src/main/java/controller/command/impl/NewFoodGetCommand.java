package controller.command.impl;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static controller.util.Massages.*;


/**
 * Created by edik2 on 21.01.2018.
 */
public class NewFoodGetCommand implements Command {
    /**
     * Setup required attributes for newFood.jsp
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Object account = req.getSession().getAttribute("accountId");

        if (account != null) {

            req.setAttribute("name", resourceManager.getString(NAME_FOOD));
            req.setAttribute("calories", resourceManager.getString(CALORIES));
            req.setAttribute("grease", resourceManager.getString(GREASE));
            req.setAttribute("proteins", resourceManager.getString(PROTEINS));
            req.setAttribute("angularrods", resourceManager.getString(ANGULAR_RODS));
            req.setAttribute("addfood", resourceManager.getString(ADD_FOOD));
            req.getRequestDispatcher("newFood.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/");
        }

    }

}
