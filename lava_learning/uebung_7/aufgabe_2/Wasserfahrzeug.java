
public class Wasserfahrzeug implements IWasserfahrzeug {
  @Override
  public void stoppen() {
    System.out.println("Stoppen");
  }

  @Override
  public void starten() {
    System.out.println("Starten");
  }

  @Override
  public void schwimmen() {
    System.out.println("schwimmen");
  }
}
