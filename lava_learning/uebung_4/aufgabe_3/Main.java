
public class Main {
  public static boolean istPalindromRekursiv(String text) {
    // Entfernen von Leerzeichen und
    // Umwandeln in Kleinbuchstaben
    // z.B., aus " Otto " wird "otto"
    text = text.replaceAll("\\s", "").toLowerCase();
    // Hier weiter mit Ihrer Lösung
    if (text.length() < 2) {
      return true;
    }
    char arr[] = text.toCharArray();
    if (arr[0] == arr[arr.length - 1]) {
      return istPalindromRekursiv(text.substring(1, text.length() - 1));
    }
    return false;
  }

  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("Usage: java Main <SomeWord>");
      return;
    }

    System.out.format("The word you provided is %sa palindrome\n", istPalindromRekursiv(args[0]) ? "" : "not ");
    return;
  }
}
