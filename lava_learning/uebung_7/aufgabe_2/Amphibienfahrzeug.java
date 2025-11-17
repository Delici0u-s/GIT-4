public class Amphibienfahrzeug implements ILandfahrzeug, IWasserfahrzeug {

  private final Landfahrzeug landModul = new Landfahrzeug();
  private final Wasserfahrzeug wasserModul = new Wasserfahrzeug();

  @Override
  public void stoppen() {
    System.out.println("Stoppen");
  }

  @Override
  public void starten() {
    System.out.println("Starten");
  }

  @Override
  public void fahren() {
    landModul.fahren();
  }

  @Override
  public void schwimmen() {
    wasserModul.schwimmen();
  }
}
