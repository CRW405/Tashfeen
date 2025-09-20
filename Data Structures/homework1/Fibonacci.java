
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        if (args.length > 0) 
            n = Integer.parseInt(args[0]);

        int[] sequence = new int[n + 1];

        fibonacci(sequence, n);

        for (int i : sequence) {
            System.out.println(i);
        }
    }

    public static int fibonacci(int[] sequence, int n) {
        if (n < 2) 
            return sequence[n] = n;
        return sequence[n] = fibonacci(sequence, n - 1) + fibonacci(sequence, n - 2);
    }
}