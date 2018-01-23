package controller.command;

import utils.ResourceManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Eduard Kulyk
 * @version 1.0
 */
public interface Command {

    ResourceManager resourceManager = ResourceManager.INSTANCE;


    /**
     *
     * @param req {@link HttpServletRequest}
     * @param resp {@link HttpServletResponse}
     * @return path to page {@link String}
     * @throws Exception
     */
    void execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;


}
