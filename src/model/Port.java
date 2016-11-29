package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

/**
 * Class represented port logic in project. And gives work all ships(such thread) with docks (recourse),for this
 * used semaphore and pool of recourse (docks).
 *
 * @author Ihar Novik
 * @see java.util.concurrent.Semaphore
 */
public class Port {
    private int maxContainerCapacity;
    private final Semaphore semaphore;  //count of semaphore = count of docks and initialize in constructor
    private final Queue<Dock> docks = new LinkedList<>(); //queue in our case from DOCKs // pool of resource

    //list of Containers /think about change to concurrent Queue
    private List<Container> containers = new CopyOnWriteArrayList<>();


    //old constructor when create dock before port
    public Port(Queue<Dock> source, int maxCapacity, List<Container> containers) {
        docks.addAll(source);
        this.containers.addAll(containers);
        semaphore = new Semaphore(source.size(), true);
        maxContainerCapacity = maxCapacity;
    }

    public Port(Queue<Dock> source, int maxCapacity, List<Container> containers, int countOfDocks) {
        docks.addAll(source);
        semaphore = new Semaphore(countOfDocks, true);
        maxContainerCapacity = maxCapacity;
        this.containers.addAll(containers);
    }

    public Dock getDock() throws ResourсeException {
        try {

            semaphore.acquire(); //lock semaphore
            Dock dock = docks.poll(); //take docks from pool of resource
            return dock;

        } catch (InterruptedException e) {
            throw new ResourсeException(e);
        }

    }

    public void returnDock(Dock dock) {
        docks.add(dock); // return instance to pool of Docks
        semaphore.release(); //release semaphore for next sheep
    }

    public List<Container> getContainers() {
        return containers;
    }


    public void addDocks(List<Dock> dock) {
        docks.addAll(dock);
    }

    public void addContainer(Container container) {
        containers.add(container);
    }

    public void addContainers(List<Container> container) {
        containers.addAll(container);
    }

    public int getMaxContainerCapacity() {
        return maxContainerCapacity;
    }
}
