public class aufgabe_2 {

  public static void foo() throws Exception {
    throw new Exception("\"im an error lol\"");
  }

  public static void bar() {
    try {
      foo();
    } catch (Exception e) {
      System.out.format("foo threw: %s\n", e.toString());
    }
  }

  public static void main(String[] args) {
    int a = 0 / 0;
    bar();
  }
}
