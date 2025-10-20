package hsd.inflab.dice;

public class LoadedDice extends Dice {

  public LoadedDice() {
  }

  @Override
  public int roll() {
    final int min = 0;
    final int max = 6;
    if (getRandomNumber(0, 1) == 0) {
      return max;
    }
    return getRandomNumber(min, max);
  }

}
