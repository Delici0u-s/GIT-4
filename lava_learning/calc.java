import java.util.ArrayList;
import java.util.Scanner;

public class calc {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    System.out.println("space to seperate new numbers. Type exit to exit.");

    while (compute_tokens_and_print(parse_input(scn.nextLine())))
      ;
    scn.close();
  }

  private static ArrayList<String> parse_input(String s) {
    ArrayList<String> tokens = new ArrayList<String>();
    StringBuilder contiguous = new StringBuilder();

    Runnable flush = () -> {
      if (contiguous.length() > 0) {
        tokens.add(contiguous.toString());
        contiguous.setLength(0);
      }
    };

    for (char c : s.toCharArray()) {
      switch (c) {
        case '+':
          flush.run();
          tokens.add("+");
          break;
        case '-':
          flush.run();
          tokens.add("-");
          break;
        case '*':
          flush.run();
          tokens.add("*");
          break;
        case '/':
          flush.run();
          tokens.add("/");
          break;
        case '%':
          flush.run();
          tokens.add("%");
          break;
        case '^':
          flush.run();
          tokens.add("^");
          break;
        case '(':
          flush.run();
          tokens.add("(");
          break;
        case ')':
          flush.run();
          tokens.add(")");
          break;
        case ' ':
          flush.run();
          break;
        default:
          if ((c >= '0' && c <= '9')) {
            contiguous.append(c);
          } else if (c == '.') {
            if (contiguous.indexOf(".") == -1) { /* check if a . is already present */
              contiguous.append('.');
            }
          }
          break;
      }
    }

    // IMPORTANT: add any remaining token after the loop
    if (contiguous.length() > 0) {
      tokens.add(contiguous.toString());
    }

    return tokens;
  }

  private static double resolve_operator(double num1, char operator, double num2) {
    switch (operator) {
      case '+':
        return double_add(num1, num2);
      case '-':
        return double_sub(num1, num2);
      case '*':
        return double_mult(num1, num2);
      case '/':
        return double_div(num1, num2);
      case '%':
        return double_mod(num1, num2);
      case '^':
        return double_pow(num1, num2);
      default:
        return 0;
    }
  }

  private static double parse_tokens(ArrayList<String> tokens, final int start_id) {
    double num1 = 0;
    double num2 = 0;
    char operator = '+';

    /* TODO: give a fuck to finish this shit implementation */
    for (String token : tokens) {
      switch (token) {
        case "+":
          break;

        case ")":
          return value;
        default:
          try {

          } catch (Exception e) {
            /* nothing */
          }
          ;
      }

    }

    return value;
  }

  private static boolean compute_tokens_and_print(ArrayList<String> tokens) {
    boolean out = true;
    for (String token : tokens) {
      if ("exit".equalsIgnoreCase(token)) {
        out = false;
        break;
      }
    }
    System.out.println(parse_tokens(tokens, 0));

    return out;
  }

  private static final Double double_add(final Double a, final Double b) {
    return a + b;
  }

  private static final Double double_sub(final Double a, final Double b) {
    return a - b;
  }

  private static final Double double_mult(final Double a, final Double b) {
    return a * b;
  }

  private static final Double double_div(final Double a, final Double b) {
    return a / b;
  }

  private static final Double double_mod(final Double a, final Double b) {
    return a % b;
  }

  private static final Double double_pow(Double a, final Double b) {
    for (int i = 0; i < b; ++i) {
      a *= a;
    }
    return a;
  }
}
