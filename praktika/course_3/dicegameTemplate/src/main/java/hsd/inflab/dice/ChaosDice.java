package hsd.inflab.dice;

public class ChaosDice extends Dice {

  int lowerBound;
  int upperBound;

  public ChaosDice() {
    this.lowerBound = 0;
    this.upperBound = 20;
  }

  @Override
  public int roll() {
    final int min = 0;
    final int max = 20;

    int out = getRandomNumber(this.lowerBound, this.upperBound);
    this.lowerBound = getRandomNumber(min, max);
    this.upperBound = getRandomNumber(this.lowerBound, max);
    return out;
  }

}
