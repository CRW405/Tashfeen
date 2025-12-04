public class Wiyninger12 {
  // Highly Divisible Triangular Number
  // 76576500
  public static void main(String[] args) {
    Long triangularNumber = 0L;

    Long n = 1L;
    while (calculateDivisors((n * (n + 1) / 2)) <= 500)
      n++;

    System.out.println((n * (n + 1) / 2));
  }

  public static Long calculateDivisors(Long n) {
    Long divisors = 0L;
    for (Long i = 1L; i * i < n; i++) {
      if (n % i == 0) {
        divisors += 2;
      }
    }
    return divisors;
  }
}
