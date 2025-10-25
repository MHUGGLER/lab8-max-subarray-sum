public class MaxSubarraySolver {

    /**
     * Brute Force Algorithm
     * Theoretical Complexity: O(n^2)
     * 
     * Explanation:
     * - Outer loop runs n times
     * - Inner loop runs up to n times for each iteration
     * - Therefore total primitive operations ~ n * n = n^2
     */
    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) { // n iterations
            int currentSum = 0;
            for (int j = i; j < n; j++) { // up to n iterations
                currentSum += arr[j];     // primitive operation
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Kadane’s Algorithm
     * Theoretical Complexity: O(n)
     * 
     * Explanation:
     * - Single loop through array.
     * - Constant number of primitive operations per iteration.
     * - Therefore total ~ n operations → O(n)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
