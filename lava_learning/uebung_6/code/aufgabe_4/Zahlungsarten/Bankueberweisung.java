package Zahlungsarten;

public class Bankueberweisung extends Zahlungsart {
  public void erklaereGebuehren(final double _Betrag) {
    final String erklaerung = """
        public double berechneGesamtbetrag(final double _Betrag) {
           return _Betrag;
         }
        """;

    System.out.println(erklaerung);
    System.out.format("In deinem fall würde es zu %f euro evaluieren\n\n" + //
        "",
        new Bankueberweisung().berechneGesamtbetrag(_Betrag));
  }

  public double berechneGesamtbetrag(final double _Betrag) {
    return _Betrag;
  }
}
