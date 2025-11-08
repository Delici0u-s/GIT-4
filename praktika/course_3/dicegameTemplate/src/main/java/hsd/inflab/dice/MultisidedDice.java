package hsd.inflab.dice;

import java.lang.Math;

public class MultisidedDice extends Dice {
  final protected int upperBound;

  public MultisidedDice(int _upperBound) {
    final int min = 4;
    final int max = 20;
    this.upperBound = Math.min(Math.max(min, _upperBound), max);
  }

  @Override
  public int roll() {
    final int min = 1;
    return getRandomNumber(min, this.upperBound);
  }

}
