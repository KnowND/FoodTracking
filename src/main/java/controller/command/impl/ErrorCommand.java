package controller.command.impl;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static controller.util.Massages.*;

/**
 * Created by edik2 on 22.01.2018.
 */
public class ErrorCommand implements Command {

    /**
     * Do trivial error processing
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.setAttribute("error", resourceManager.getString(ERROR));
        req.getRequestDispatcher("error.jsp").forward(req,resp);
    }
}
