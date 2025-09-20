

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Primes {

    static long[] primes = null;

    public static void main(String[] args) {
        double startTime = System.nanoTime();
        byte[] bytes = getFileBytes("./half_gaps.bin");

        long[] gaps = convertBytes(bytes);

        long[] cumsum = cumsum(gaps);

        long[] modifiedCumSum = modifyCumSum(cumsum);
        double endTime = (System.nanoTime() - startTime) / Math.pow(10, 9);

        long[] first15 = first15(modifiedCumSum);
        long[] last15 = last5(modifiedCumSum);

        System.out.println("2\n3");

        for (long i : first15) {
            System.out.println(i);
        }

        System.out.println("...");

        for (long i : last15) {
            System.out.println(i);
        }

        System.out.println("in " + endTime + " seconds");

        primes = modifiedCumSum;
    }

    public static long[] returnPrimes() {
        main(null);
        return primes;
    }

    public static byte[] getFileBytes(String path) {
        byte[] bytes = null;
        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println("bytes gotten");
        return bytes;
    }

    public static long[] convertBytes(byte[] bytes) {
        long[] gaps = new long[bytes.length];
        for (int i = 0; i < bytes.length; i++)
            gaps[i] = Byte.toUnsignedInt(bytes[i]);
        // System.out.println("bytes converted");
        return gaps;
    }

    public static long[] cumsum(long[] gaps) {
        // System.out.println("cumsum started");
        long[] cumsum = new long[gaps.length];

        int cumsumAti = 0;
        for (int i = 0; i < gaps.length; i++) {

            cumsumAti += gaps[i];

            cumsum[i] = cumsumAti;
        }

        return cumsum;
    }

    public static long[] modifyCumSum(long[] cumsum) {
        long[] modifiedCumSum = new long[cumsum.length];

        for (int i = 0; i < cumsum.length; i++) {
            modifiedCumSum[i] = (cumsum[i] * 2) + 3;
        }

        return modifiedCumSum;
    }

    public static long[] last5(long[] array) {
        long[] last15 = new long[5];

        for (int i = 0; i < last15.length; i++) {
            last15[i] = array[array.length - 6 + i];
        }

        return last15;
    }

    public static long[] first15(long[] array) {
        long[] first15 = new long[15];

        for (int i = 0; i < first15.length; i++) {
            first15[i] = array[i];
        }

        return first15;
    }
}