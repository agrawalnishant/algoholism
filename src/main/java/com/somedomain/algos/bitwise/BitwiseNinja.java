package com.somedomain.algos.bitwise;

import java.util.Arrays;

public class BitwiseNinja {


    public static void main(String[] args) {
        countNumberOfBits(21);
        System.out.println(convertToBits(21));
        System.out.println("isPowerOfTwo(1): " + isPowerOfTwo(1));
        int[] arr = {0, 1, 2, 4, 5, 6, 7, 8, 9,10,11};
        System.out.println("Missing Number in " + Arrays.toString(arr) + " is :" + findMissingNumber(arr));

        arr = new int[]{2, 3, 2, 6, 3, 5, 6, 4, 5};
        System.out.println("Non Duplicate Number in " + Arrays.toString(arr) + " is : " + findNonDuplicateNumber(arr));
    }


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

    public static void countNumberOfBits(int number) {
        int bitCount = 0;
        while (number > 0) {
            number >>= 1;
            bitCount++;
        }
        System.out.println("Number of Bits in " + number + " is " + bitCount);
    }

    public static String convertToBits(int number) {
        System.out.println("");
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
