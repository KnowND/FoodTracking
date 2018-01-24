package controller.command.impl;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static utils.Massages.*;

/**
 * Created by edik2 on 21.01.2018.
 */
public class LoginGetCommand implements Command {

    /**
     * Set text attributes for login.jsp and return it,
     * if user doesnt log in yet redirect to home page
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        Object account = req.getSession().getAttribute("accountId");

        if (account == null){
            req.setAttribute("login_page", resourceManager.getString(LOGIN_PAGE));
            req.setAttribute("login", resourceManager.getString(EMAIL));
            req.setAttribute("password", resourceManager.getString(PASSWORD));
            req.setAttribute("enter", resourceManager.getString(ENTER));
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else {
            resp.sendRedirect("/");
        }

    }
}
