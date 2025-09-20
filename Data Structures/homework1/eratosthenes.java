
public class eratosthenes {

    public static void main(String[] args) {

        int n = 100;
        if (args.length > 0)
            n = Integer.parseInt(args[0]);

        double startTime = System.nanoTime();
        boolean[] notPrimes = sieve(n);
        double endTime = System.nanoTime();

        int[] topFive = new int[5];
        int count = 0;
        for (int i = n - 1; i >= 2 && count < 5; i--) {
            if (!notPrimes[i]) {
                topFive[count++] = i;
            }
        }

        for (int i : topFive) {
            System.out.println(i);
        }

        double time = (endTime - startTime) / Math.pow(10, 9);
        System.out.println(time);
    }

    public static boolean[] sieve(int n) {

        boolean[] notPrimes = new boolean[n];

        /*
         * Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
         * Initially, let p equal 2, the smallest prime number.
         * Enumerate the multiples of p by counting in increments of p from 2p to n, and
         * mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not
         * be marked).
         * Find the smallest number in the list greater than p that is not marked. If
         * there was no such number, stop. Otherwise, let p now equal this new number
         * (which is the next prime), and repeat from step 3.
         * When the algorithm terminates, the numbers remaining not marked in the list
         * are all the primes below n.
         */

        for (int p = 2; p < Math.sqrt(notPrimes.length); p++) {
            if (notPrimes[p] == true)
                continue;
            for (int i = 2; i * p < notPrimes.length; i++) {
                notPrimes[i * p] = true;
            }
        }

        return notPrimes;
    }
}

/*
 * v1 simple loop
 * 1073741789
 * 1073741783
 * 1073741741
 * 1073741723
 * 1073741719
 * 132.747966329
 */

/*
 * v2 skip trues
 * 1073741789
 * 1073741783
 * 1073741741
 * 1073741723
 * 1073741719
 * 18.236022787
 */

/*
 * v2 
 * 97
 * 89
 * 83
 * 79
 * 73
 * 1.0965E-5
 */

/*v3 only loop sqrt(n)
 * 1073741789
 * 1073741783
 * 1073741741
 * 1073741723
 * 1073741719
 * 16.603312252
 */
