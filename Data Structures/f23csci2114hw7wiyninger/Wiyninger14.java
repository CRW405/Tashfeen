public class Wiyninger14 {
  // longest collatz sequence
  public static void main(String[] args) {
    int largest = 0;
    int number = 0;

    for (int i = 1; i < 1_000_000; i += 2) {

      if (i % 2 == 0) {
        continue;
      }

      int length = collatz(i);

      if (length > largest) {
        largest = length;
        number = i;
      }
    }

    System.out.println(number);
  }

  public static int collatz(int n) {
    int length = 1;

    while (n != 1) {
      if (n % 2 == 0) {
        n = whenEven(n);
      } else {
        n = whenOdd(n);
      }
      length++;
    }

    return length;
  }

  public static int whenEven(int n) {
    return n / 2;
  }

  public static int whenOdd(int n) {
    return 3 * n + 1;
  }
}
