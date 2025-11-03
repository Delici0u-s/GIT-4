
public class Zug extends Transportmittel {

  void meldenVerstaetung() {
    System.out.println("Wir bitten die Verspätung zu entschuldigen.");
  }

  public static void main(String[] args) {
    Zug meinZug = new Zug();
    meinZug.durchfuehrenWartung();
    meinZug.meldenVerstaetung();

    Transportmittel mainTransport = new Zug();

    mainTransport.durchfuehrenWartung();

    /*
     * mainTransport.meldenVerstaetung();
     *
     * .\Zug.java:18: error: cannot find symbol
     * mainTransport.meldenVerstaetung();
     *               ^
     * symbol: method meldenVerstaetung()
     * location: variable mainTransport of type Transportmittel
     * 1 error
     */
  }
}
