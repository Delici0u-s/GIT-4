import java.util.ArrayList;

public class benoter {

  // Klassenvariable: Liste von Studenten
  static ArrayList<Student> students = new ArrayList<>();

  public final char punktzahl_zu_note(final int _punktzahl) {
    if (_punktzahl >= 90)
      return 'A';
    if (_punktzahl >= 80)
      return 'B';
    if (_punktzahl >= 70)
      return 'C';
    if (_punktzahl >= 60)
      return 'D';
    return 'F';
  }

  public static void main(String[] args) throws Exception {
    // Einen Student hinzufügen
    students.add(new Student("Anna", 85));
    students.add(new Student("Bob", 72));
    students.add(new Student("Charlie", 45));
    students.add(new Student("Lisa", 92));

    benoter b = new benoter();

    // Ausgabe des Namens des ersten Students
    for (int i = 0; i < students.size(); ++i) {
      Student s = students.get(i);
      System.out.format("Student %d: %-10s -Punktzahl: %3d, Note: %c\n", i, s.get_name(), s.get_punkte(),
          b.punktzahl_zu_note(s.get_punkte()));
    }
  }
}
