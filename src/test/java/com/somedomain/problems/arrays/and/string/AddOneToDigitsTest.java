package com.somedomain.problems.arrays.and.string;

import com.somedomain.comparators.IntegerArrayListComparator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

class AddOneToDigitsTest {

    @Test
    void plusOne() {
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        Collections.addAll(integerArrayList, new Integer[]{0, 0, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        ArrayList<Integer> result = AddOneToDigits.plusOne(integerArrayList);
        ArrayList<Integer> expectedResult = new ArrayList<>();
        Collections.addAll(expectedResult, new Integer[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Assertions.assertTrue(new IntegerArrayListComparator().compare(result, expectedResult) == 0);

    }
}