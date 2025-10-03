import java.util.Random;

public class balance {
  public static void main(String[] args) {
    Random random = new Random();
    double n = 1_000_000;
    Stack<Character> stack = new Stack<>();
    int balanced = 0;
    boolean isBalanced = true;

    for (int i = 0; i < n; i++) {
      String string = "";
      for (int k = 0; k < 6; k++) {
        int coin = random.nextInt(2);
        char parenthesis = (coin == 1) ? '(' : ')';
        string += parenthesis;
      }

      isBalanced = true;

      while (!stack.isEmpty()) {
        stack.pop();
      }

      for (int j = 0; j < string.length(); j++) {
        if (string.charAt(j) == '(') {
          stack.push(string.charAt(j));
        } else if (string.charAt(j) == ')') {
          if (stack.isEmpty()) {
            isBalanced = false;
            break;
          }
          stack.pop();
        }
      }

      if (stack.isEmpty() && isBalanced)
        balanced++;
    }
    System.out.println((double) balanced / n);
  }
}
