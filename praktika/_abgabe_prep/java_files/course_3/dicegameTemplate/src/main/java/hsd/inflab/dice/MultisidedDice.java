package hsd.inflab.dice;

import java.lang.Math;

public class MultisidedDice extends Dice {
  final protected int lowerBound;
  final protected int upperBound;

  public MultisidedDice(int _lowerBound, int _upperBound) {
    final int min = 4;
    final int max = 20;
    this.lowerBound = Math.min(Math.max(min, _lowerBound), max);
    this.upperBound = Math.min(Math.max(this.lowerBound, _upperBound), max);
  }

  @Override
  public int roll() {
    return getRandomNumber(this.lowerBound, this.upperBound);
  }

}
