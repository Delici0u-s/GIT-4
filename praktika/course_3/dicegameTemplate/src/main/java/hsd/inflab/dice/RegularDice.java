package hsd.inflab.dice;

public class RegularDice extends Dice {

  public RegularDice() {
  }

  @Override
  public int roll() {
    final int min = 1;
    final int max = 6;
    return getRandomNumber(min, max);
  }

}
