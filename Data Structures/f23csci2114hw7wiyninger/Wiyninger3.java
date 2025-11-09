public class Wiyninger3 {

  // Main method: Entry point of the program
  public static void main(String[] args) {
    // The number for which we want to find the largest prime factor
    long n = 600851475143L;

    // Variable to store the largest prime factor
    long prime = 0;

    // Cursor used to check divisors starting from the smallest prime number, 2
    long cursor = 2;

    // Loop until the number is reduced to 1 by division
    while (n > 1) {
      // If the current cursor divides n, it's a prime factor
      if (n % cursor == 0) {
        // Update the largest prime factor
        prime = cursor;
        // Reduce n by dividing it with the current prime factor
        n = n / cursor;
      } else {
        // Increment cursor to check the next possible factor
        cursor++;
      }
    }

    // Print the largest prime factor to the console
    System.out.println(prime);
  }
}
