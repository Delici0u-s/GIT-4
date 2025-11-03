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
    return this.Betrag + calc_gebuehren();/* why '+' bei betrag ??? */
  }

  public static void erklaereGebuehren(final String _Zahlungsart, final double _Betrag) {
    final String erklaerung = """
        public Zahlungsabwicklung(final String _Zahlungsart, final double _Betrag) {
          if (clean_string(_Zahlungsart) == "paypal") {
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
          """;

    System.out.println(erklaerung);
    System.out.format("\nIn deinem fall würde es zu %f euro evaluieren\n",
        new Zahlungsabwicklung(_Zahlungsart, _Betrag).berechneGesamtbetrag());
  }

  public static void main(String[] args) {
    erklaereGebuehren("Paypal", 100.001);
    erklaereGebuehren("Kreditkarte", 100.001);
  }
}
