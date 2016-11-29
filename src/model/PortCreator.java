package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Class includes static methods  for creating port in project.
 */
public class PortCreator {

    /**
     * Method creates and return port.
     *
     * @param countOfDocks number of docks (pool of docks)
     * @param containersLimit max containers capacity in port
     * @return new port with needed parameters
     */
    public static Port getPort(final int countOfDocks, int containersLimit) {

        //create list of docks , when in port will be pool of resource
        LinkedList<Dock> listOfDocks = new LinkedList<Dock>() {
            {

                for (int i = 1; i <= countOfDocks; i++) {
                    this.add(new Dock(i));
                }
            }
        };

        //create random containers for port
        List<Container> containers = new ArrayList<Container>(ProjectConstants.COUNT_OF_PORT_CONTAINERS) {
            {
                for (int i = 1; i <= ProjectConstants.COUNT_OF_PORT_CONTAINERS; i++) {

                    this.add(new Container((1 + new Random().nextInt(5)),ProjectConstants.PORT_CONTAINERS));
                }
            }
        };

        return new Port(listOfDocks, containersLimit, containers, countOfDocks);
    }

    public static Port getPort( final int countOfDocks, int containersLimit, List<Container> containers) {


        LinkedList<Dock> listOfDocks = new LinkedList<Dock>() {
            {

                for (int i = 1; i <= countOfDocks; i++) {
                    this.add(new Dock(i));
                }
            }
        };

        return new Port(listOfDocks, containersLimit, containers, countOfDocks);
    }


}
