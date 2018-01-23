package controller;

import DAO.AccountDAO;
import DAO.DAOFactory;
import DAO.FoodDAO;
import DAO.FoodIntakeDAO;
import DAO.connection.DataSourcePool;
import DAO.impl.DAOFactoryImpl;
import controller.command.Command;
import controller.command.impl.*;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by edik2 on 17.01.2018.
 */
//@WebServlet(urlPatterns = "/")
public class MainController extends HttpServlet {
    private static final Logger logger = Logger.getLogger(MainController.class);

    Map<String, Command> commandMap;

//    DataSourcePool dataSourcePool;
    DataSource dataSource;
    Command command;

    @Override
    public void init() {

        DAOFactory daoFactory = DAOFactoryImpl.INSTANCE;
//        dataSourcePool = DataSourcePool.INSTANCE;
        dataSource = DataSourcePool.INSTANCE.getDS();

        FoodDAO foodDAO = daoFactory.createFoodDAO(dataSource);
        FoodIntakeDAO foodIntakeDAO = daoFactory.createFoodIntakeDAO(dataSource);
        AccountDAO accountDAO = daoFactory.createAccountDAO(dataSource);

        commandMap = new HashMap<>();
        commandMap.put("/registration_get", new RegistrationGetCommand());
        commandMap.put("/registration_post", new RegistrationPostCommand(accountDAO));
        commandMap.put("/newfood_get", new NewFoodGetCommand());
        commandMap.put("/newfood_post", new NewFoodPostCommand(foodDAO));
        commandMap.put("/login_get", new LoginGetCommand());
        commandMap.put("/login_post", new LoginPostCommand(accountDAO));
        commandMap.put("/foodintake_get", new FoodIntakeGetCommand());
        commandMap.put("/foodintake_post", new FoodIntakePostCommand(foodIntakeDAO));
        commandMap.put("/_get", new IndexGetCommand(foodIntakeDAO));
        commandMap.put("/error_get", new ErrorCommand());
        commandMap.put("/exit_get", new ExitCommand());
        commandMap.put("/selectfood_get", new SelectFoodGetCommand(foodDAO));
        commandMap.put("/selectfood_post", new SelectFoodPostCommand(foodDAO));
        commandMap.put("/changelanguage_get", new ChangeLanguageCommand());


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        String uri = req.getRequestURI();
        command = commandMap.get(uri + "_get");


        try {
            executeCommand(req, resp, command);
        } catch (Exception e) {
            logger.error("Error executing command " + command.getClass().getName(),e);
            resp.sendRedirect("/error");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);

        String uri = req.getRequestURI();
        command = commandMap.get(uri + "_post");
//        try {
//            command.execute(req, resp);
//        } catch (Exception e) {
//            logger.error("Error executing command " + command.getClass().getName(),e);
//            resp.sendRedirect("/error");
//        }
        try {
            executeCommand(req, resp, command);
        } catch (Exception e) {
            logger.error("Error executing command " + command!=null?command.getClass().getName():"Command doesnt exist",e);
            resp.sendRedirect("/error");
        }

    }

    private void executeCommand(HttpServletRequest req, HttpServletResponse resp, Command command) throws Exception {
        if (command != null) {
            command.execute(req, resp);
        } else {
            throw new Exception("Command doesnt exist");
        }
    }


}
