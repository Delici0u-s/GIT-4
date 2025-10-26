; Auto-generated AutoHotkey script
; Wait 5 seconds before starting to allow you to focus the remote window
Sleep, 5000
SetKeyDelay, 1  ; Set typing speed

Send {Text}import java.util.Scanner;
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}public class basic_calc `{
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
Send {Text}  private static void print_option_screen() `{
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("\nCALCULATOR - please select:");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("0: end program");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("1: add");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("2: subtract");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("3: multiply");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("4: divide");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("----------------------------");
Send {Enter}
Sleep, 10
Send {Text}    System.out.println("Enter your selection: ");
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
Send {Text}    /* A+ code ahead, be warned */
Send {Enter}
Sleep, 10
Send {Text}    print_option_screen();
Send {Enter}
Sleep, 10
Send {Text}    final int selection = get_int_input(scr, 0, 4);
Send {Enter}
Sleep, 10
Send {Text}    /* num as first input and output */
Send {Enter}
Sleep, 10
Send {Text}    double num = (selection != 0) ? get_double_input(scr, "Please enter your first value: ") : 0;
Send {Enter}
Sleep, 10
Send {Text}    switch (selection) `{
Send {Enter}
Sleep, 10
Send {Text}      case 1:
Send {Enter}
Sleep, 10
Send {Text}        num = add(num, get_double_input(scr, "Please enter your second value: "));
Send {Enter}
Sleep, 10
Send {Text}        break;
Send {Enter}
Sleep, 10
Send {Text}      case 2:
Send {Enter}
Sleep, 10
Send {Text}        num = sub(num, get_double_input(scr, "Please enter your second value: "));
Send {Enter}
Sleep, 10
Send {Text}        break;
Send {Enter}
Sleep, 10
Send {Text}      case 3:
Send {Enter}
Sleep, 10
Send {Text}        num = mult(num, get_double_input(scr, "Please enter your second value: "));
Send {Enter}
Sleep, 10
Send {Text}        break;
Send {Enter}
Sleep, 10
Send {Text}      case 4:
Send {Enter}
Sleep, 10
Send {Text}        num = div(num, get_double_input(scr, "Please enter your second value: "));
Send {Enter}
Sleep, 10
Send {Text}        break;
Send {Enter}
Sleep, 10
Send {Text}      default:
Send {Enter}
Sleep, 10
Send {Text}        return false;
Send {Enter}
Sleep, 10
Send {Text}    `}
Send {Enter}
Sleep, 10
Send {Text}    System.out.format("Your request evaluated to: `%f\n", num);
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
Send {Text}  private static final int get_int_input(Scanner scr, final int min, final int max) `{
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
Send {Text}  private static final double get_double_input(Scanner scr, final String message) `{
Send {Enter}
Sleep, 10
Send {Text}    System.out.print(message);
Send {Enter}
Sleep, 10
Send {Text}    double out;
Send {Enter}
Sleep, 10
Send {Text}    boolean first = true;
Send {Enter}
Sleep, 10
Send {Text}    while (true) `{
Send {Enter}
Sleep, 10
Send {Text}      if (!first) `{
Send {Enter}
Sleep, 10
Send {Text}        System.out.print("Please enter a valid double input: ");
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
Send {Text}        out = Double.parseDouble(line);
Send {Enter}
Sleep, 10
Send {Text}        return out;
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
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static double add(final double a, final double b) `{
Send {Enter}
Sleep, 10
Send {Text}    return a + b;
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static double sub(final double a, final double b) `{
Send {Enter}
Sleep, 10
Send {Text}    return a - b;
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static double mult(final double a, final double b) `{
Send {Enter}
Sleep, 10
Send {Text}    return a * b;
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Enter}
Sleep, 10
Send {Text}  private static double div(final double a, final double b) `{
Send {Enter}
Sleep, 10
Send {Text}    return a / b;
Send {Enter}
Sleep, 10
Send {Text}  `}
Send {Enter}
Sleep, 10
Send {Text}`}
Send {Enter}
Sleep, 10

ExitApp
