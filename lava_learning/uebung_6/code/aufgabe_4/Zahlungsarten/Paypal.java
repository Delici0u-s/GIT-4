package Zahlungsarten;

public class Paypal extends Zahlungsart {
  public void erklaereGebuehren(final double _Betrag) {
    final String erklaerung = """
        public double berechneGesamtbetrag(final double _Betrag) {
          return _Betrag + (_Betrag * 0.04) + 5;
        }
              """;

    System.out.println(erklaerung);
    System.out.format("In deinem fall würde es zu %f euro evaluieren\n\n",
        new Paypal().berechneGesamtbetrag(_Betrag));
  }

  public double berechneGesamtbetrag(final double _Betrag) {
    return _Betrag + (_Betrag * 0.04) + 5;
  }
}
