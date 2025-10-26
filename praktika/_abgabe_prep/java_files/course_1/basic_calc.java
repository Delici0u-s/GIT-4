import java.util.Scanner;

public class basic_calc {

  public static void main(String[] args) {
    Scanner scr = new Scanner(System.in);
    while (get_and_act_user_input(scr))
      ;

    scr.close();
  }

  private static void print_option_screen() {
    System.out.println("\nCALCULATOR - please select:");
    System.out.println("0: end program");
    System.out.println("1: add");
    System.out.println("2: subtract");
    System.out.println("3: multiply");
    System.out.println("4: divide");
    System.out.println("----------------------------");
    System.out.println("Enter your selection: ");
  }

  private static boolean get_and_act_user_input(Scanner scr) {
    /* A+ code ahead, be warned */
    print_option_screen();
    final int selection = get_int_input(scr, 0, 4);
    /* num as first input and output */
    double num = (selection != 0) ? get_double_input(scr, "Please enter your first value: ") : 0;
    switch (selection) {
      case 1:
        num = add(num, get_double_input(scr, "Please enter your second value: "));
        break;
      case 2:
        num = sub(num, get_double_input(scr, "Please enter your second value: "));
        break;
      case 3:
        num = mult(num, get_double_input(scr, "Please enter your second value: "));
        break;
      case 4:
        num = div(num, get_double_input(scr, "Please enter your second value: "));
        break;
      default:
        return false;
    }
    System.out.format("Your request evaluated to: %f\n", num);
    return true;
  }

  private static final int get_int_input(Scanner scr, final int min, final int max) {
    int out = min - 1;
    boolean first = true;
    while (!(out >= min && out <= max)) {
      if (!first) {
        System.out.format("Please enter a valid integer input[%s, %s]: ", min, max);
      }
      String line = scr.nextLine().trim();
      try {
        out = Integer.parseInt(line);
      } catch (Exception e) {
      }
      first = false;
    }

    return out;
  }

  private static final double get_double_input(Scanner scr, final String message) {
    System.out.print(message);
    double out;
    boolean first = true;
    while (true) {
      if (!first) {
        System.out.print("Please enter a valid double input: ");
      }
      String line = scr.nextLine().trim();
      try {
        out = Double.parseDouble(line);
        return out;
      } catch (Exception e) {
      }
      first = false;
    }

  }

  private static double add(final double a, final double b) {
    return a + b;
  }

  private static double sub(final double a, final double b) {
    return a - b;
  }

  private static double mult(final double a, final double b) {
    return a * b;
  }

  private static double div(final double a, final double b) {
    return a / b;
  }
}
