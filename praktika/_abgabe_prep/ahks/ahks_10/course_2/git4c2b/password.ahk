; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 10  ; Set typing speed

Send {Text}import java.util.Scanner;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}public class password `{
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  static int pw_hash;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  static `{
Send {Enter}
Sleep, 10
Send {Text}    pw_hash = hash_string("123456");
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  public password(final String default_password) `{
Send {Enter}
Sleep, 10
Send {Text}    pw_hash = hash_string(default_password);
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  public password() `{
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  public static void main(String[] args) `{
Send {Enter}
Sleep, 10
Send {Text}    Scanner scr = new Scanner(System.in);
Send {Enter}
Sleep, 10
Send {Text}    while (get_and_act_user_input(scr))
Send {Enter}
Sleep, 10
Send {Text}      ;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    scr.close();
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static final int hash_string(final String s) `{
Send {Enter}
Sleep, 10
Send {Text}    return s.hashCode();
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static void print_option_screen() `{
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("\nPASSWORD THING");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("0: end program");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("1: change password");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("2: check password");
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static boolean get_and_act_user_input(Scanner scr) `{
Send {Enter}
Sleep, 10
Send {Text}    print_option_screen();
Send {Enter}
Sleep, 10
Send {Text}    switch (get_int_input(scr, 0, 2)) `{
Send {Enter}
Sleep, 10
Send {Text}      case 0:
Send {Enter}
Sleep, 10
Send {Text}        return false;
Send {Enter}
Sleep, 10
Send {Text}      case 1:
Send {Enter}
Sleep, 10
Send {Text}        change_pw(scr);
Send {Enter}
Sleep, 10
Send {Text}        break;
Send {Enter}
Sleep, 10
Send {Text}      case 2:
Send {Enter}
Sleep, 10
Send {Text}        check_pw(scr);
Send {Enter}
Sleep, 10
Send {Text}        break;
Send {Enter}
Sleep, 10
Send {Text}      default:
Send {Enter}
Sleep, 10
Send {Text}        break;
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Text}    return true;
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static void change_pw(Scanner scr) `{
Send {Enter}
Sleep, 10
Send {Text}    if (check_pw(scr, "Please enter your old password to confirm change: ")) `{
Send {Enter}
Sleep, 10
Send {Text}      System.out.print("Enter the new password you'd like to have: ");
Send {Enter}
Sleep, 10
Send {Text}      int new_pw_hash = get_pw_input(scr);
Send {Enter}
Sleep, 10
Send {Text}      if (new_pw_hash == pw_hash) `{
Send {Enter}
Sleep, 10
Send {Text}        System.out.println("New password cant be your old password  ");
Send {Enter}
Sleep, 10
Send {Text}        return;
Send {Enter}
Sleep, 10
Send {Text}      `}
Send {Enter}
Sleep, 10
Send {Text}      System.out.print("Please confirm your input: ");
Send {Enter}
Sleep, 10
Send {Text}      if (new_pw_hash == get_pw_input(scr)) `{
Send {Enter}
Sleep, 10
Send {Text}        pw_hash = new_pw_hash;
Send {Enter}
Sleep, 10
Send {Text}      `} else `{
Send {Enter}
Sleep, 10
Send {Text}        System.out.println("The password you entered does not match the first input");
Send {Enter}
Sleep, 10
Send {Text}      `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static boolean check_pw(Scanner scr, final String msg) `{
Send {Enter}
Sleep, 10
Send {Text}    System.out.print(msg);
Send {Enter}
Sleep, 10
Send {Text}    if (hash_string(get_line_input(scr)) == pw_hash) `{
Send {Enter}
Sleep, 10
Send {Text}      System.out.println("The password you entered is correct");
Send {Enter}
Sleep, 10
Send {Text}      return true;
Send {Enter}
Sleep, 10
Send {Text}    `} else `{
Send {Enter}
Sleep, 10
Send {Text}      System.out.println("The password you entered is incorrect");
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Text}    return false;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static boolean check_pw(Scanner scr) `{
Send {Enter}
Sleep, 10
Send {Text}    return check_pw(scr, "Enter a password you'd like to check: ");
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static int get_int_input(Scanner scr, final int min, final int max) `{
Send {Enter}
Sleep, 10
Send {Text}    int out = min - 1;
Send {Enter}
Sleep, 10
Send {Text}    boolean first = true;
Send {Enter}
Sleep, 10
Send {Text}    while (!(out >= min && out <= max)) `{
Send {Enter}
Sleep, 10
Send {Text}      if (!first) `{
Send {Enter}
Sleep, 10
Send {Text}        System.out.format("Please enter a valid integer input[`%s, `%s]: ", min, max);
Send {Enter}
Sleep, 10
Send {Text}      `}
Send {Enter}
Sleep, 10
Send {Text}      String line = scr.nextLine().trim();
Send {Enter}
Sleep, 10
Send {Text}      try `{
Send {Enter}
Sleep, 10
Send {Text}        out = Integer.parseInt(line);
Send {Enter}
Sleep, 10
Send {Text}      `} catch (Exception e) `{
Send {Enter}
Sleep, 10
Send {Text}      `}
Send {Enter}
Sleep, 10
Send {Text}      first = false;
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    return out;
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static String get_line_input(Scanner scr) `{
Send {Enter}
Sleep, 10
Send {Text}    return scr.nextLine().trim();
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static int get_pw_input(Scanner scr) `{
Send {Enter}
Sleep, 10
Send {Text}    String out = "";
Send {Enter}
Sleep, 10
Send {Text}    boolean first = true;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    while (true) `{
Send {Enter}
Sleep, 10
Send {Text}      if (!first) `{
Send {Enter}
Sleep, 10
Send {Text}        System.out.println("Password must be at least 8 characters long, and include:");
Send {Enter}
Sleep, 10
Send {Text}        System.out.println("- One uppercase letter");
Send {Enter}
Sleep, 10
Send {Text}        System.out.println("- One number");
Send {Enter}
Sleep, 10
Send {Text}        System.out.println("- One special character (*, -, /, etc.)");
Send {Enter}
Sleep, 10
Send {Text}      `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}      out = get_line_input(scr);
Send {Enter}
Sleep, 10
Send {Text}      first = false;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}      if (is_valid_password(out)) `{
Send {Enter}
Sleep, 10
Send {Text}        break;
Send {Enter}
Sleep, 10
Send {Text}      `}
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    return hash_string(out);
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static boolean is_valid_password(String pw) `{
Send {Enter}
Sleep, 10
Send {Text}    if (pw.length() < 8)
Send {Enter}
Sleep, 10
Send {Text}      return false;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    boolean hasUpper = false;
Send {Enter}
Sleep, 10
Send {Text}    boolean hasNumber = false;
Send {Enter}
Sleep, 10
Send {Text}    boolean hasSpecial = false;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    for (char c : pw.toCharArray()) `{
Send {Enter}
Sleep, 10
Send {Text}      if (Character.isUpperCase(c)) `{
Send {Enter}
Sleep, 10
Send {Text}        hasUpper = true;
Send {Enter}
Sleep, 10
Send {Text}      `} else if (Character.isDigit(c)) `{
Send {Enter}
Sleep, 10
Send {Text}        hasNumber = true;
Send {Enter}
Sleep, 10
Send {Text}      `} else if (!Character.isLetterOrDigit(c)) `{
Send {Enter}
Sleep, 10
Send {Text}        hasSpecial = true;
Send {Enter}
Sleep, 10
Send {Text}      `}
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}    return hasUpper && hasNumber && hasSpecial;
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}`}
Send {Enter}
Sleep, 10

ExitApp
