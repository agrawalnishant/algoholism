package com.somedomain.algos.bitwise;

public class BitwiseNinja {


    public static int findMissingNumber(int[] nums) {
        int missingNumber = nums.length;
        for (int count = 0; count < nums.length; count++) {
            missingNumber ^= count ^ nums[count];
        }
        return missingNumber;
    }

    public static int findNonDuplicateNumber(int[] nums) {
        int nonDupNumber = 0;
        for (int count = 0; count < nums.length; count++) {
            nonDupNumber ^= nums[count];
        }
        return nonDupNumber;
    }


    public static int findHammingDistance(int num1, int num2) {
        int distance = 0;
        int xor = num1 ^ num2;
        while (xor != 0) {
            distance++;
            xor &= xor - 1;
        }
        return distance;
    }

    public static int countNumberOfBits(final int sourceNumber) {
        int number = sourceNumber;
        int bitCount = 0;
        while (number > 0) {
            number >>= 1;
            bitCount++;
        }
        return bitCount;
    }

    public static String convertToBits(int number) {
        String bits = new String();
        for (int count = 31; count >= 0; count--) {
            bits += ("" + ((number & (1 << count)) == 0 ? 0 : 1));
        }
        return bits;
    }

    public static boolean isPowerOfTwo(int number) {
        if (number == 0) return false;
        if ((number & (number - 1)) == 0) {
            return true;
        } else return false;
    }
}
