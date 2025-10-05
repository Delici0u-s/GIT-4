import java.util.Scanner;

public class password {

  static int pw_hash;

  static {
    pw_hash = hash_string("123456");
  }

  public password(final String default_password) {
    pw_hash = hash_string(default_password);
  }

  public password() {
  }

  public static void main(String[] args) {
    Scanner scr = new Scanner(System.in);
    while (get_and_act_user_input(scr))
      ;

    scr.close();
  }

  private static final int hash_string(final String s) {
    return s.hashCode();
  }

  private static void print_option_screen() {
    System.out.println("\nPASSWORD THING");
    System.out.println("0: end program");
    System.out.println("1: change password");
    System.out.println("2: check password");
  }

  private static boolean get_and_act_user_input(Scanner scr) {
    print_option_screen();
    switch (get_int_input(scr, 0, 2)) {
      case 0:
        return false;
      case 1:
        change_pw(scr);
        break;
      case 2:
        check_pw(scr);
        break;
      default:
        break;
    }
    return true;
  }

  private static void change_pw(Scanner scr) {
    if (check_pw(scr, "Please enter your old password to confirm change: ")) {
      System.out.print("Enter the new password you'd like to have: ");
      int new_pw_hash = get_pw_input(scr);
      if (new_pw_hash == pw_hash) {
        System.out.println("New password cant be your old password  ");
        return;
      }
      System.out.print("Please confirm your input: ");
      if (new_pw_hash == get_pw_input(scr)) {
        pw_hash = new_pw_hash;
      } else {
        System.out.println("The password you entered does not match the first input");
      }

    }

  }

  private static boolean check_pw(Scanner scr, final String msg) {
    System.out.print(msg);
    if (hash_string(get_line_input(scr)) == pw_hash) {
      System.out.println("The password you entered is correct");
      return true;
    } else {
      System.out.println("The password you entered is incorrect");
    }
    return false;

  }

  private static boolean check_pw(Scanner scr) {
    return check_pw(scr, "Enter a password you'd like to check: ");

  }

  private static int get_int_input(Scanner scr, final int min, final int max) {
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

  private static String get_line_input(Scanner scr) {
    return scr.nextLine().trim();
  }

  private static int get_pw_input(Scanner scr) {
    String out = "";

    boolean first = true;
    while (out.length() < 8) {
      if (!first) {
        System.out.println("Please enter a valid input (min 8 characters): ");
      }
      out = get_line_input(scr);
      first = false;
    }

    return hash_string(out);
  }

}
