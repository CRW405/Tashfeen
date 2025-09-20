
public class Search {
    public static void main(String[] args) {
        double start = System.nanoTime();
        double favourable = 0;
        long[] primes = getPrimes();
        int sampleSize = 1000000;
        // int sampleSize = 100;
        for (int i = 1; i <= sampleSize; i++) {
            long x = getRandomInt(2, Integer.MAX_VALUE);

            // favourable += linearSearch(x, primes) ? 1.0 : 0.0;

            favourable += binarySearch(x, primes) ? 1.0 : 0.0;

            // System.out.println(favourable / i);
        }
        System.out.println(favourable / sampleSize);
        double duration = (System.nanoTime() - start) / Math.pow(10, 9);
        System.out.printf(" Time taken : %.2f seconds %n", duration);
        // // ???
        // for (int i = 0; i < primes.length; i++) {
        // while (true) {
        // int random = getRandomInt(2, Integer.MAX_VALUE);
        // System.out.println(random);
        // }
        // }

    }

    public static boolean linearSearch(long x, long[] primes) {
        boolean found = false;

        for (long i : primes) {
            if (i > x)
                break;
            if (x == i) {
                found = true;
                break;
            }
        }

        return found;
    }

    /*
     * LOG
     * 0.09
     * Time taken : 3.20 seconds
     * 
     * 0.048551
     * Time taken : 20469.49 second
     * 
     * 0.048731
     * Time taken : 20482.42 seconds
     */

    public static boolean binarySearch(long x, long[] primes) {
        int start = 0;
        int end = primes.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (x == primes[mid]) {
                return true;
            } else if (primes[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }

    /*
     * LOG
     * 0.03
     * Time taken : 0.50 seconds
     */

    public static int getRandomInt(int min, int max) {
        int randomInt = (int) (Math.round(Math.random() * max) + min);
        return randomInt;
    }

    public static long[] getPrimes() {
        return Primes.returnPrimes();
    }
}