public class Smartphone {
  int speicherkapazität;
  String farbe;

  static int anzahlSmartphones;
  static {
    anzahlSmartphones = 0;
  }

  public Smartphone(int _speicherkapazität) {
    this.speicherkapazität = _speicherkapazität;
    this.farbe = "";
    ++anzahlSmartphones;
  }

  public void print() {
    System.out.format("%d, %s, Total_amount: %d\n", this.speicherkapazität, this.farbe, anzahlSmartphones);
  }

  public static void main(String args[]) {
    Smartphone smartphone1 = new Smartphone(64);
    Smartphone smartphone2 = new Smartphone(128);
    
    smartphone1.print();
    smartphone2.print();

    Smartphone smartphone3 = new Smartphone(256);
    smartphone3.print();
  }
}
