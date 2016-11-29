package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Class for creating many threads of Ship in Executor.
 */
public class ShipCreator {
    public static void  createShips(Port port,int countOfShip) {

        ExecutorService executorService = Executors.newFixedThreadPool(countOfShip);

              for (int i = 1; i <= countOfShip; i++) {
           final int amountContainer = new Random().nextInt(3) + 2;
           int maxTransportWeight = new Random().nextInt(10) + 10;

            List<Container> transportedContainers = new ArrayList<Container>(amountContainer) {
                {
                    for (int i = 1; i <= amountContainer; i++) {
                        this.add(new Container((1 + new Random().nextInt(5))));
                    }
                }
            };

            executorService.execute(new Ship(String.valueOf(i),amountContainer ,maxTransportWeight, port, transportedContainers));
        }

        executorService.shutdown();

    }
}
