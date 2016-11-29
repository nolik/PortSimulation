package model;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

/**
 * Class that represents Ship and makes Thread, that sent for unloading to the port. And after unloading , ship will be
 * load Containers from Port.
 *
 * @author Ihar Novik
 */

public class Ship implements Runnable {
    static Logger logger = Logger.getLogger(Ship.class);
    private String name;
    private int amountContainer;
    private int maxTransportWeight;
    private boolean moored = false; // flag that ship lock dock
    private Port port;

    private List<Container> listOfContainers = new LinkedList<>(); //transported Container's

    public Ship(String name, int amountContainer, int maxWeight, Port port, List<Container> containers) {
        this.name = name;
        this.amountContainer = amountContainer;
        this.maxTransportWeight = maxWeight;
        this.port = port;
        listOfContainers.addAll(containers);

    }

    public Ship(Port pool) {
        this.port = pool;
    }

    public void run() {
        Dock dock = null;
        try {
            dock = port.getDock(); //захватуем док
            moored = true;

            logger.info(ProjectConstants.SHIP + " #" + this.name + " " + ProjectConstants.LOCK_DOCK + " #" + dock.getDockNumber());
            //   dock.using();
            dock.unload(this, port);
            dock.upload(this, port);
        } catch (ResourсeException e) {

            logger.info(ProjectConstants.SHIP + " #" + this.name + " " + ProjectConstants.LOST_DOCK + " ->" + e.getMessage());
        } finally {
            if (dock != null) {
                moored = false;

                logger.info(ProjectConstants.SHIP + " #" + this.name + " : " + dock.getDockNumber() + "  " + ProjectConstants.DOCK_RELEASED);

                logger.info(ProjectConstants.SHIP + " #" + this.name + " " + ProjectConstants.CONTAINERS + ": " + this.getListOfContainers());

                port.returnDock(dock);
            }
        }
    }

    public List<Container> getListOfContainers() {
        return listOfContainers;
    }

    public int getAmountContainer() {
        return amountContainer;
    }

    public int getMaxTransportWeight() {
        return maxTransportWeight;
    }
}