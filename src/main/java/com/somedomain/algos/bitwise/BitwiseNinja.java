package com.somedomain.algos.bitwise;

public class BitwiseNinja {


    public static void main(String[] args) {
        countNumberOfBits(21);
        System.out.println(convertToBits(21));
        System.out.println("isPowerOfTwo(1): " + isPowerOfTwo(1));
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
