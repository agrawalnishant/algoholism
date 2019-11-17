package com.somedomain.problems.arrays.and.string;

import java.util.ArrayList;

public class AddOneToDigits {

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> finalList = new ArrayList<Integer>();
        ArrayList<Integer> finalList3 = new ArrayList<Integer>();
        if (A == null || A.size() == 0 || (A.size() == 1 && A.get(0) == 0)) {
            finalList3.add(1);
        } else {
            int digitCounter = 0;
            int digit = 0;
            int number = 0;
            boolean isLast9 = false;
            for (int iter = 0; iter < A.size(); iter++) {
                number = A.get(iter);
                if (digitCounter == 0 && (A.get(iter) == 0 || A.get(iter) == null)) {
                    continue;
                } else {
                    result.add(digitCounter++, number);
                }
                if (iter == A.size() - 1 && number == 9) {
                    isLast9 = true;
                }
            }
            digitCounter--;
            int carry = 1;
            for (int count = digitCounter; count >= 0; count--) {
                int currDig = result.get(count);
                int resDig = 0;
                if (carry == 1 && currDig == 9) {
                    resDig = 0;
                    carry = 1;
                } else {
                    resDig = currDig + carry;
                    carry = 0;
                }
                finalList.add(resDig);
            }
            if (carry == 1) {
                finalList.add(1);
                digitCounter++;
            }

            for (int i = digitCounter; i >= 0; i--) {
                finalList3.add(finalList.get(i));
            }
        }
        return finalList3;

    }
}
