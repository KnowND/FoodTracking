package controller.command.impl;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by edik2 on 23.01.2018.
 */
public class ExitCommand implements Command {
    /**
     * Clean session attribute when client log out
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getSession().setAttribute("accountId", null);
        req.getSession().setAttribute("login", null);
        req.getSession().setAttribute("norma", null);
        resp.sendRedirect("/");
    }
}
