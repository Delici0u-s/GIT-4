import java.util.ArrayList;
import Zahlungsarten.*;

public class ZahlungsabwicklungOOP {
  public static void main(String[] args) {
    ArrayList<Zahlungsart> Zahlarten = new ArrayList<Zahlungsart>();
    Zahlarten.add(new Paypal());
    Zahlarten.add(new Kreditkarte());
    Zahlarten.add(new Bankueberweisung());

    for (Zahlungsart Zahlart : Zahlarten) {
      Zahlart.erklaereGebuehren(100); /* prints berechneGesamtbetrag result, so unnecessary here */
    }
  }
}
