import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] arr = generateRandomArrayWithNegatives(n);

            // Time Brute Force
            long start = System.nanoTime();
            MaxSubarraySolver.bruteForceMaxSum(arr);
            long bruteTime = System.nanoTime() - start;

            // Time Kadane's
            start = System.nanoTime();
            MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            long kadaneTime = System.nanoTime() - start;

            System.out.printf("Brute Force: %.4f ms\n", bruteTime / 1_000_000.0);
            System.out.printf("Kadane’s Algorithm: %.4f ms\n", kadaneTime / 1_000_000.0);
        }
    }

    // Generates random array with negative and positive integers
    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(2001) - 1000; // values between -1000 and 1000
        }
        return arr;
    }
}
