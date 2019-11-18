package com.somedomain.utilities.comparators;

import java.util.Comparator;

public class IntegerArrayComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] intArray1, int[] intArray2) {
        if (intArray1.length != intArray2.length) {
            return intArray1.length - intArray2.length;
        }

        for (int index = 0; index < intArray1.length; index++) {
            if (intArray1[index] != intArray2[index])
                return intArray1[index] - intArray2[index];
        }
        return 0;
    }
}
