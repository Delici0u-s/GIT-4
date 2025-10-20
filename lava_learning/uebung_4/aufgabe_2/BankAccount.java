
public class BankAccount {
  private double kontostand;

  public BankAccount() {
    this.kontostand = 0;
  }

  public final double einzahlen(double _num) {
    return kontostand += _num;
  }

  public final double abheben(double _num) {
    return kontostand -= _num;
  }
}
