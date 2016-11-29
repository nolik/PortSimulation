package model;

import java.util.ResourceBundle;

/**
 * Class included all constants that load from properties.
 */
public class ProjectConstants {

    static ResourceBundle resourceBundle = ResourceBundle.getBundle("settings");
    public static final int COUNT_DOCK = Integer.parseInt(resourceBundle.getString("PortCreator.COUNT_DOCK"));
    public static final int COUNT_OF_PORT_CONTAINERS = Integer.parseInt(resourceBundle
            .getString("PortCreator.COUNT_OF_PORT_CONTAINERS"));
    public static final String PORT_CONTAINERS = resourceBundle.getString("PortCreator.PORT_CONTAINERS");
    public static final int PORT_CONTAINERS_LIMIT = Integer.parseInt(resourceBundle
            .getString("PortCreator.PORT_CONTAINERS_LIMIT"));
    public static final int COUNT_OF_SHIPS = Integer.parseInt(resourceBundle.getString("PortCreator.COUNT_OF_SHIPS"));
    public static final String UNDEFINED_DESCRIPTION = resourceBundle.getString("Container.UNDEFINED_DESCRIPTION");
    public static final String CONTAINER = resourceBundle.getString("Container.CONTAINER");
    public static final String ID = resourceBundle.getString("Container.ID");
    public static final String WEIGHT = resourceBundle.getString("Container.WEIGHT");
    public static final String DESCRIPTION = resourceBundle.getString("Container.DESCRIPTION");
    public static String CATCH_SEMAPHORE = resourceBundle.getString("Port.CATCH_SEMAPHORE");
    public static String SHIP = resourceBundle.getString("Ship.SHIP");

    public static String LOCK_DOCK= resourceBundle.getString("Ship.LOCK_DOCK");
    public static String DOCK_RELEASED = resourceBundle.getString("Ship.DOCK_RELEASED");
    public static String CONTAINERS=resourceBundle.getString("Ship.CONTAINERS");
    public static String LOST_DOCK = resourceBundle.getString("Ship.LOST");
    public static String  MAKES_PORT = resourceBundle.getString("Controller.MAKES_PORT");
    public static String  CREATE_SHIP = resourceBundle.getString("Controller.CREATE_SHIP");
}
