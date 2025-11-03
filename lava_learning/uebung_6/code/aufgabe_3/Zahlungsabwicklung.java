public class Zahlungsabwicklung {
  protected Zahlungsart Zahlart = Zahlungsart.UNBEKANNT; /* :) */
  protected double Betrag;

  enum Zahlungsart {
    PAYPAL,
    KREDITKARTE,
    BANKUEBERWEISUNG,
    UNBEKANNT;

    static Zahlungsart fromString(String s) {
      return switch (s) {
        case "paypal" -> PAYPAL;
        case "kreditkarte" -> KREDITKARTE;
        case "bankueberweisung" -> BANKUEBERWEISUNG;
        default -> UNBEKANNT;
      };
    }
  }

  private String clean_string(String s) {
    return s.trim().toLowerCase();
  }

  public Zahlungsabwicklung(final String _Zahlungsart, final double _Betrag) {
    this.Zahlart = Zahlungsart.fromString(clean_string(_Zahlungsart));
    this.Betrag = _Betrag;
  }

  protected double calc_gebuehren() {
    switch (Zahlart) {
      case PAYPAL:
        return (this.Betrag * 0.04) + 5;
      case KREDITKARTE:
        if (this.Betrag < 100) {
          return this.Betrag * 0.05;
        } else {
          return (this.Betrag * 0.02) + 8;
        }
      default:
        return this.Betrag;
    }
  }

  public double berechneGesamtbetrag() {
    return this.Betrag + calc_gebuehren();/* why '+' bei betrag ??? */
  }

  public static void erklaereGebuehren(final String _Zahlungsart, final double _Betrag) {
    final String erklaerung = """
        protected Zahlungsart Zahlart = Zahlungsart.UNBEKANNT; /* :) */
        protected double Betrag;

        enum Zahlungsart {
          PAYPAL,
          KREDITKARTE,
          BANKUEBERWEISUNG,
          UNBEKANNT;

          static Zahlungsart fromString(String s) {
            return switch (s) {
              case "paypal" -> PAYPAL;
              case "kreditkarte" -> KREDITKARTE;
              case "bankueberweisung" -> BANKUEBERWEISUNG;
              default -> UNBEKANNT;
            };
          }
        }

        private String clean_string(String s) {
          return s.trim().toLowerCase();
        }

        public Zahlungsabwicklung(final String _Zahlungsart, final double _Betrag) {
          this.Zahlart = Zahlungsart.fromString(clean_string(_Zahlungsart));
          this.Betrag = _Betrag;
        }

        protected double calc_gebuehren() {
          switch (Zahlart) {
            case PAYPAL:
              return (this.Betrag * 0.04) + 5;
            case KREDITKARTE:
              if (this.Betrag < 100) {
                return this.Betrag * 0.05;
              } else {
                return (this.Betrag * 0.02) + 8;
              }
            default:
              return this.Betrag;
          }
        }

        public double berechneGesamtbetrag() {
          return this.Betrag + calc_gebuehren();/* why '+' bei betrag ??? */
        }
                """;

    System.out.println(erklaerung);
    System.out.format("\nIn deinem fall würde es zu %f euro evaluieren\n",
        new Zahlungsabwicklung(_Zahlungsart, _Betrag).berechneGesamtbetrag());
  }

  public static void main(String[] args) {
    /* nix gefragt */
  }
}
