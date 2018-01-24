package controller.command.impl;

import DAO.FoodDAO;
import DTO.Food;
import controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static utils.Massages.*;

/**
 * Created by edik2 on 21.01.2018.
 */
public class SelectFoodGetCommand implements Command {

    private FoodDAO foodDAO;

    public SelectFoodGetCommand(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    /**
     * Set text attributes for selectFood.jsp and return it
     *
     * @param req  {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @throws Exception
     */
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Food> foodList = new ArrayList<>();
        int accountId = 0;

        Object account = req.getSession().getAttribute("accountId");

        if (account != null) {
            accountId = Integer.parseInt(account.toString());
        }

        int maxRecordId = foodDAO.maxId(accountId) + 1;

        String page = req.getParameter("page");

        int startPos;

        if (page != null){
            startPos = Integer.parseInt(page);
        }else {
            startPos = 0;
        }
        req.setAttribute("page", maxRecordId/count);
        foodList.addAll(foodDAO.getAllFood(accountId, startPos * count));
        req.setAttribute("name", resourceManager.getString(NAME_FOOD));
        req.setAttribute("calories", resourceManager.getString(CALORIES));
        req.setAttribute("grease", resourceManager.getString(GREASE));
        req.setAttribute("angular_rods", resourceManager.getString(ANGULAR_RODS));
        req.setAttribute("proteins", resourceManager.getString(PROTEINS));
        req.setAttribute("search", resourceManager.getString(SEARCH));
        req.setAttribute("foodList", foodList);
        req.setAttribute("nothing_found", null);

//        String i = req.getSession().getAttribute("entered").toString();
//        req.setAttribute("search", null);


        req.getRequestDispatcher("selectFood.jsp").forward(req, resp);


    }
}
