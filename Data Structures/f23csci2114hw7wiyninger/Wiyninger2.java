package f23csci2114hw7wiyninger;

public class Wiyninger2 {
    // Even Fibonacci Numbers

    // 4613732

    // Find the sum  of all even number in the fibonacci 
    // sequence under 4 million
    public static void main(String[] args) {
        int first = 1;
        int second = 2;
        int current = 0;
        int sum = 2;

        // 4000000
        while (current < (4000000)) {
            current = first + second;
            first = second;
            second = current;
            if (current % 2 == 0) {
                sum += current;
            }
        }
        System.out.println(sum);
    }
}
