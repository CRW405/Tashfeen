public class Wiyninger14 {
  // longest collatz sequence
  // 837799
  public static void main(String[] args) {
    Long largest = 0L;
    Long number = 0L;

    for (Long i = 1L; i < 1_000_000L; i += 2L) {
      Long length = collatz(i);

      if (length > largest) {
        largest = length;
        number = i;
      }
    }

    System.out.println(number);
  }

  public static Long collatz(Long n) {
    if (n == 1) {
      return 1L;
    } else if (n % 2 == 0) {
      return 1 + collatz(n / 2);
    } else {
      return 1 + collatz(3 * n + 1);
    }
  }

}
