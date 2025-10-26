import java.util.Scanner;
import java.lang.Math;

public class very_basic_calc {
  protected static double current_value = 0;
  protected static Scanner scr = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Usage instructions: ");
    System.out.println("This program stores a number for you.");
    System.out.println("Every selected option is an operation on that number");
    System.out.println("and the number will be set as result");
    System.out.println("----------------------------");

    int selection = -1;
    while (selection != 0) {
      current_value = Math.round(current_value * 100000.0) / 100000.0; /* round to 5th digit */
      selection = print_menu_and_get_option();
      interpret_selection(selection);
    }

    scr.close();
  }

  private static int print_menu_and_get_option() {
    System.out.println("CALCULATOR - please select:");
    System.out.println("Current number: " + current_value);
    System.out.println("0: end program");
    System.out.println("1: set number");
    System.out.println("2: add");
    System.out.println("3: subtract");
    System.out.println("4: multiply");
    System.out.println("5: divide");
    System.out.println("6: sin (rad)");
    System.out.println("7: pow");
    System.out.println("8: greatest common denominator");
    System.out.println("9: fibbonachi");
    System.out.println("----------------------------");
    System.out.println("Enter your selection: ");

    int out = -1;
    boolean first = true;
    while (!(out >= 0 && out <= 9)) {
      if (!first) {
        System.out.println("Please enter a valid selection: ");
      }
      try {
        out = scr.nextInt();
      } catch (Exception e) {
        scr.next();
      }
      first = false;
    }

    return out;
  }

  private static double get_input() {
    System.out.println("Please enter a number:");
    String line = scr.nextLine();
    while (true) {
      try {
        line = scr.nextLine();
        return Double.parseDouble(line);
      } catch (Exception e) {
        System.out.println("Please enter a valid number");
        scr.next();
      }
    }
  }

  private static void interpret_selection(final int selection) {
    switch (selection) {
      case 1:
        set(get_input());
        break;
      case 2:
        add(get_input());
        break;
      case 3:
        sub(get_input());
        break;
      case 4:
        mult(get_input());
        break;
      case 5:
        div(get_input());
        break;
      case 6:
        sin();
        break;
      case 7:
        pow(get_input());
        break;
      case 8:
        gcd(get_input());
        break;
      case 9:
        fib();
        break;
      default:
        /* on zero nothing happens */
        break;
    }
  }

  private static void set(final double value) {
    current_value = value;
  }

  private static void add(final double value) {
    current_value += value;
  }

  private static void sub(final double value) {
    current_value -= value;
  }

  private static void mult(final double value) {
    current_value *= value;
  }

  private static void div(final double value) {
    current_value /= value;
  }

  private static void sin() {
    current_value = Math.sin(current_value);
  }

  private static void pow(final double value) {
    current_value = Math.pow(current_value, value);
  }

  private static double gcd_impl(final double a, final double b) { /*
                                                                    * https://www.geeksforgeeks.org/dsa/program-find-gcd
                                                                    * -floating-point-numbers/
                                                                    */
    if (a < b)
      return gcd_impl(b, a);

    // base case
    if (Math.abs(b) < 0.001)
      return a;

    else
      return (gcd_impl(b, a - Math.floor(a / b) * b));
  }

  private static void gcd(final double value) {
    current_value = gcd_impl(value, current_value);
  }

  private static int fib_impl(final int num) {
    if (num <= 1)
      return num;
    return fib_impl(num - 1) + fib_impl(num - 2); /* not optimized whatsoever, as requested */
  }

  private static void fib() {
    current_value = fib_impl((int) current_value);
  }
}
