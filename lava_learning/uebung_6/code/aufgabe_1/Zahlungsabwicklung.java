public class Zahlungsabwicklung {
  protected boolean paypal = false; /* :) */
  protected double Betrag;

  private String clean_string(String s) {
    return s.trim().toLowerCase();
  }

  public Zahlungsabwicklung(final String _Zahlungsart, final double _Betrag) {
    if (clean_string(_Zahlungsart) == "paypal") {
      // if (clean_string(_Zahlungsart).compareTo("paypal") == 0) {
      this.paypal = true;
    }
    this.Betrag = _Betrag;
  }

  protected double calc_gebuehren() {
    if (paypal) {
      return (this.Betrag * 0.04) + 5;
    } else {
      if (this.Betrag < 100) {
        return this.Betrag * 0.05;
      } else {
        return (this.Betrag * 0.02) + 8;
      }
    }
  }

  public double berechneGesamtbetrag() {
    return this.Betrag + calc_gebuehren();/* why '+' ??? */
  }

  public static void main(String[] args) {
    Zahlungsabwicklung z1 = new Zahlungsabwicklung("paypal", 100);
    Zahlungsabwicklung z2 = new Zahlungsabwicklung("Kreditkarte", 100);

    System.err.println(z1.berechneGesamtbetrag());
    System.err.println(z2.berechneGesamtbetrag());

  }
}
