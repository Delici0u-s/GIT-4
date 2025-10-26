package hsd.inflab.dice;

import java.util.ArrayList;
import java.util.List;

public class Shaker {
    private List<Dice> cup = new ArrayList<>();
    int noOfThrows = 0;

    public void addDice(Dice dice) {
        cup.add(dice);
    }

    public void throwDice() {
        System.out.println("Throw " + ++noOfThrows + ":");
        for (int i = 0; i < cup.size(); i++) {
            System.out.print(cup.get(i).getName() + " ");
            System.out.println(cup.get(i).roll());
        }
        System.out.println("\n");
        pause();
    }

    private void pause() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }
}
