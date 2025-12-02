import java.math.BigInteger;

public class Wiyninger15 {
  // Lattice paths
  // 137846528820
  public static void main(String[] args) {
    int smallGridSize = 2 + 2;
    int largeGridSize = 20 + 20;

    System.out.println(calculatePaths(smallGridSize));
    System.out.println(calculatePaths(largeGridSize));
  }

  public static BigInteger calculatePaths(int gridSize) {
    return factorial(gridSize).divide(factorial(gridSize / 2).multiply(factorial(gridSize - gridSize / 2)));
  }

  public static BigInteger factorial(int n) {
    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
      result = result.multiply(BigInteger.valueOf(i));
    }
    return result;
  }
}
