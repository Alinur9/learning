package com.hridoy;

public class LargestDiagonalPrime {
    public int largestDiagonalPrime(int[][] nums) {
        int n = nums.length;
        int largestPrime = 0;
        // Check the main diagonal
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                largestPrime = Math.max(largestPrime, nums[i][i]);
            }
        }
        // Check the secondary diagonal
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][n - i - 1])) {
                largestPrime = Math.max(largestPrime, nums[i][n - i - 1]);
            }
        }
        return largestPrime;
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{5,6,7},{9,10,11}};
         LargestDiagonalPrime obj = new LargestDiagonalPrime();
        System.out.println(obj.largestDiagonalPrime(nums));
    }
}
