package hsd.inflab.dice;

public class ChaosDice extends Dice {

  int last_upper_bound;

  public ChaosDice() {
    last_upper_bound = 0;
  }

  @Override
  public int roll() {
    final int min = 4;
    final int max = 20;

    int new_upper_bound;
    do {
      new_upper_bound = getRandomNumber(min, max);
    } while (new_upper_bound == last_upper_bound);

    return getRandomNumber(min, new_upper_bound);
  }

}
