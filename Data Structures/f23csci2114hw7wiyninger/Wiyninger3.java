public class Wiyninger3 {
    
    public static void main(String[] args) {
        int factor = 1;

        // int n = (int) Math.sqrt(600851475143L);
        int n = 13195;

        for (int i = 2; i < n; i++) {
            if(n % i == 0 && n > factor && isPrime(i))
                factor = i; 
        }

        System.out.println(factor); // got 2639
    }

    public static boolean isPrime(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if ((n % (j*i)) == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
