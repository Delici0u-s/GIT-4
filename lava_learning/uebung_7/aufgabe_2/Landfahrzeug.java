
public class Landfahrzeug implements ILandfahrzeug {
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
    System.out.println("fahren");
  }
}
