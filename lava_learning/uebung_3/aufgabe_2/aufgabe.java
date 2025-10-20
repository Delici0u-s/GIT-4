public class aufgabe {
  public void methode(final int input) {
    double input = 2.0;
    /*
     * Es fällt auf, dass:
     * .\aufgabe.java:3: error: variable input is already defined in method
     * methode(int)
     * double input = 2.0;
     * ^
     * der code compiliert gar nicht, da java dies nicht erlaubt
     */
    {
      float input = 3.4;
      /* scoped geht es auch nicht */
    }
  }
}
