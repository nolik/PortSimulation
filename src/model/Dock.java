package model;

import java.util.List;

/**
 * Class represented dock, that can service 1 ship in 1 time.
 * Included method for unload and upload containers from/to ship.
 *
 * @author Ihar Novik
 */
public class Dock {


    private int numberOfDock;

    public Dock(int id) {
        super();
        numberOfDock = id;

    }

    public int getDockNumber() {
        return numberOfDock;

    }

    //empty method for simulation work
 /*   public void using() {
        try {
            // использование дока
            Thread.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Method for unload ship in port.
     *
     * @param ship current moored ship
     * @param port current port when located ship
     */
    public void unload(Ship ship, Port port) {
        //gives available port containers
        List<Container> portContainers = port.getContainers();

        int availableContainersPlace = port.getMaxContainerCapacity() - port.getContainers().size();
        int countOfShipCont = ship.getListOfContainers().size();

        //if have enough place we unload all containers fully
        if (availableContainersPlace >= countOfShipCont) {
            portContainers.addAll(ship.getListOfContainers());
            ship.getListOfContainers().clear();
        } else {
            //else we unload one at a time
            while (availableContainersPlace > 0) {
                Container container = ship.getListOfContainers().remove(0);
                port.getContainers().add(container);
                availableContainersPlace--;
            }
        }
    }

    /**
     * Method for upload containers to ship.
     *
     * @param ship current moored ship
     * @param port current port when located ship
     */
    public void upload(Ship ship, Port port) {
        int limitOfContainers = ship.getAmountContainer() - ship.getListOfContainers().size();
        int transportedWeight = ship.getMaxTransportWeight();
        int currentWeight = ShipManager.calculateCurrentWeight(ship);
        int availableWeight = transportedWeight - currentWeight;

        //break upload -> containers warehouse in port is empty
        if (port.getContainers().size() == 0) return;

        for (int i = 0; i < limitOfContainers; i++) {
            //take random Container from port containers
            if (port.getContainers().size() == 0) return; //break upload -> containers warehouse in port is empty

            Container container = port.getContainers().get(0);
            int weightOfCurrentContainer = container.getWeight();
            //load container to ship
            if (weightOfCurrentContainer <= availableWeight) {//have weight for anyone container?
                availableWeight -= weightOfCurrentContainer;
                port.getContainers().remove(container);
                ship.getListOfContainers().add(container);
            } else break;
        }
    }


}