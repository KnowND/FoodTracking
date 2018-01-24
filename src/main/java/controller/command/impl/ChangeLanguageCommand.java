package controller.command.impl;

import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by edik2 on 22.01.2018.
 */
public class ChangeLanguageCommand implements Command {
    /**
     * Change language command and return to home page
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String lang = req.getParameter("lang");
        String country = req.getParameter("country");
        req.getSession().setAttribute("lang",lang);
        Locale locale = new Locale(lang,country);

        resourceManager.changeResource(locale);
//        String path = req.getRequestURI();
//        req.getRequestDispatcher("/").forward(req,resp);
        resp.sendRedirect("/");
//        resp.sendRedirect(path);
    }
}
