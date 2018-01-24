package controller.command.impl;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static controller.util.Massages.*;

/**
 * Created by edik2 on 21.01.2018.
 */
public class RegistrationGetCommand implements Command {
    /**
     * Setup required attributes for registration.jsp
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {


        Object accountId = req.getSession().getAttribute("accountId");

        if (accountId == null) {
            req.setAttribute("name", resourceManager.getString(NAME_AC));
            req.setAttribute("surname", resourceManager.getString(SURNAME));
            req.setAttribute("weight", resourceManager.getString(WEIGHT));
            req.setAttribute("weight2", resourceManager.getString(WEIGHT2));
            req.setAttribute("height", resourceManager.getString(HEIGHT));
            req.setAttribute("age", resourceManager.getString(AGE));
            req.setAttribute("wol", resourceManager.getString(WAY_OF_LIFE));
            req.setAttribute("registration", resourceManager.getString(REGISTRATION));
            req.setAttribute("login", resourceManager.getString(EMAIL));
            req.setAttribute("password", resourceManager.getString(PASSWORD));
            req.setAttribute("register", resourceManager.getString(REGISTER));
            req.setAttribute("have_enter", resourceManager.getString(HAVE_ENTER));
            req.setAttribute("wol1", resourceManager.getString(WOL1));
            req.setAttribute("wol2", resourceManager.getString(WOL2));
            req.setAttribute("wol3", resourceManager.getString(WOL3));
            req.setAttribute("wol4", resourceManager.getString(WOL4));
            req.setAttribute("wol5", resourceManager.getString(WOL5));
            req.setAttribute("details", resourceManager.getString(DETAILS));
            req.setAttribute("gender", resourceManager.getString(GENDER));
            req.setAttribute("male", resourceManager.getString(MALE));
            req.setAttribute("female", resourceManager.getString(FEMALE));

            req.getRequestDispatcher("registration.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/");
        }

    }
}
