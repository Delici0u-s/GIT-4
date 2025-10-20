package hsd.inflab.dice;

public class Main {
  public static void main(String[] args) {
    Shaker shaker = new Shaker();

    /* this works as this is intended usage */
    shaker.addDice(new RegularDice());
    /* this works as this is intended usage */
    shaker.addDice(new MultisidedDice(0, 40)); /* resolves to 4, 20 */
    /* this works as this is intended usage */
    shaker.addDice(new LoadedDice());
    /* this works as this is intended usage */
    shaker.addDice(new ChaosDice());

    /* This does now work, as Dice is an abstract class */
    // shaker.addDice(new Dice());

    /*
     * this does not work, both do extend the same abstact class, but LoadedDice is
     * not an extended class of RegularDice, so this dont work
     */
    // LoadedDice ld = new RegularDice();
    /* This would work if ld would exist */
    // shaker.addDice(ld);

    while (true) {
      shaker.throwDice();
    }
  }
}
