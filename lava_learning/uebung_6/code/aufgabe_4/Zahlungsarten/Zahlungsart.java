package Zahlungsarten;

public abstract class Zahlungsart {
  /*
   * ungewünscht?
   * protected double Betrag;
   * 
   * public Zahlungsart(double _Betrag) {
   * this.Betrag = _Betrag;
   * }
   */

  public abstract void erklaereGebuehren(final double _Betrag);

  public abstract double berechneGesamtbetrag(final double _Betrag);
}
