package Zahlungsarten;

public class Kreditkarte extends Zahlungsart {
  public void erklaereGebuehren(final double _Betrag) {
    final String erklaerung = """
        public double berechneGesamtbetrag(final double _Betrag) {
          if (_Betrag < 100) {
            return _Betrag + _Betrag * 0.05;
          } else {
            return _Betrag + (_Betrag * 0.02) + 8;
          }
        }
                  """;

    System.out.println(erklaerung);
    System.out.format("In deinem fall würde es zu %f euro evaluieren\n\n" + //
        "",
        new Kreditkarte().berechneGesamtbetrag(_Betrag));
  }

  public double berechneGesamtbetrag(final double _Betrag) {
    if (_Betrag < 100) {
      return _Betrag + _Betrag * 0.05;
    } else {
      return _Betrag + (_Betrag * 0.02) + 8;
    }
  }
}
