import java.util.Stack;

public class StapelVerteiler {
  public void verteileZahlen(
      Stack<Integer> stapel1,
      Stack<Integer> stapel2,
      Stack<Integer> stapel3) {
    if (stapel1.isEmpty()) {
      return;
    }

    int tmp = stapel1.pop();

    if (tmp % 2 == 0) {
      stapel2.push(tmp);
    } else {
      stapel3.push(tmp);
    }

    verteileZahlen(stapel1, stapel3, stapel3);
  }

  public static void main(String[] args) {
    Stack<Integer> stapel1 = new Stack<>();
    Stack<Integer> stapel2 = new Stack<>();
    Stack<Integer> stapel3 = new Stack<>();
    // Hier Beispielwerte in Stapel 1 hinzufügen
    // ...
    for (int i = 1; i <= 8; i++) {
      stapel1.push(i);
    }

    StapelVerteiler verteiler = new StapelVerteiler();
    verteiler.verteileZahlen(stapel1, stapel2, stapel3);
    System.out.println("Gerade Zahlen: " + stapel2);
    System.out.println("Ungerade Zahlen: " + stapel3);
  }

}