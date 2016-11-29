package controller;


import model.Port;
import model.PortCreator;
import model.ProjectConstants;
import model.ShipCreator;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;

/**
 * Class controller.
 *
 * @author Ihar Novik
 */
public class Controller {

    private static ResourceBundle bundle = ResourceBundle.getBundle("settings");
    static Logger logger = null;

    public static void main(String[] args) {
        logger = Logger.getLogger(Controller.class);

        logger.info(ProjectConstants.MAKES_PORT);
        Port port = PortCreator.getPort(ProjectConstants.COUNT_DOCK, ProjectConstants.PORT_CONTAINERS_LIMIT);

        logger.info(ProjectConstants.CREATE_SHIP);
        ShipCreator.createShips(port, ProjectConstants.COUNT_OF_SHIPS);


    }
}
