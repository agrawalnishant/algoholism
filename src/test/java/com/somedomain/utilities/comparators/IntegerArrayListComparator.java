package com.somedomain.utilities.comparators;

import java.util.ArrayList;
import java.util.Comparator;

public class IntegerArrayListComparator implements Comparator<ArrayList<Integer>> {
    @Override
    public int compare(ArrayList<Integer> intArray1, ArrayList<Integer> intArray2) {
        if (intArray1.size() != intArray2.size()) {
            return intArray1.size() - intArray2.size();
        }

        for (int index = 0; index < intArray1.size(); index++) {
            if (intArray1.get(index) != intArray2.get(index))
                return intArray1.get(index) - intArray2.get(index);
        }
        return 0;
    }
}
