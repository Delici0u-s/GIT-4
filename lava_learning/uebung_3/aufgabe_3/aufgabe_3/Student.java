public class Student {
  public final String name;
  public int punktzahl;

  public Student(String _name) {
    this.name = _name;
    this.punktzahl = 0;
  }

  public Student(String _name, int _punktzahl) {
    this.name = _name;
    this.punktzahl = _punktzahl;
  }

  public final int get_punkte() {
    return this.punktzahl;
  }

  public final String get_name() {
    return this.name;
  }

  public final void set_punkte(int _punktzahl) {
    this.punktzahl = _punktzahl;
  }
}
