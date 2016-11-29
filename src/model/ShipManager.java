package model;

/**
 *  Class-manager for working with ship.
 */
public class ShipManager {

    /**
     * Method for calculating current weight that ship transported.
     * @param ship - ship where we calculate weight.
     * @return transported weight.
     */
    public static int calculateCurrentWeight(Ship ship) {
        int totalWeight = 0;

        for (Container x : ship.getListOfContainers()) {
            totalWeight += x.getWeight();
        }

        return totalWeight;
    }
}
