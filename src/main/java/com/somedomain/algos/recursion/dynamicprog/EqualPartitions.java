package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;

public class EqualPartitions {
    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();

    private static Integer counter;

    public static boolean naiveCheck(int[] srcArr) {
        int sum = 0;
        counter = 0;
        for (int num : srcArr)
            sum += num;
        boolean result = (sum % 2 == 0  || srcArr.length <=1 ) ? naivelyCheckSum(srcArr, 0, sum / 2) : false;
        flogger.atInfo().log("Total Calculations: " + counter);
        return result;
    }

    private static boolean naivelyCheckSum(final int[] srcArr, final int idx, final int sum) {
        if (sum == 0)
            return true;
        else if (sum < 0  || idx >= srcArr.length || srcArr[idx] > sum)
            return false;

        counter++;
        return naivelyCheckSum(srcArr, idx + 1, sum) || naivelyCheckSum(srcArr, idx + 1, sum - srcArr[idx]);
    }

    public static boolean memoizedCheck(int[] srcArr) {
        int sum = 0;
        counter = 0;
        for (int num : srcArr)
            sum += num;
        int[][] possibilitiesMatrix = new int[srcArr.length][sum];
        for (int arrIdx = 0; arrIdx < srcArr.length; arrIdx++) {
            Arrays.fill(possibilitiesMatrix[arrIdx], -1);
        }

        boolean result = (sum % 2 == 0  || srcArr.length <=1 ) ? memoizedCheckSum(srcArr, 0, sum / 2, possibilitiesMatrix) : false;
        flogger.atInfo().log("Total Calculations: " + counter);
        return result;
    }

    private static boolean memoizedCheckSum(final int[] srcArr, final int idx, final int sum, final int[][] possibilitiesMatrix) {
        boolean skipElementAtCurrentIndex = false;
        if (sum == 0)
            return true;
        if (sum < 0 || srcArr.length <=1 || idx >= srcArr.length || srcArr[idx] > sum)
            return false;
        if (possibilitiesMatrix[idx][sum] != -1) {
            return possibilitiesMatrix[idx][sum] == 1 ? true : false;
        }

        counter++;
        boolean withElementAtCurrentIndex = memoizedCheckSum(srcArr, idx + 1, sum - srcArr[idx], possibilitiesMatrix);
        if (withElementAtCurrentIndex != true) {
            skipElementAtCurrentIndex = memoizedCheckSum(srcArr, idx + 1, sum, possibilitiesMatrix);
        }
        possibilitiesMatrix[idx][sum] = (withElementAtCurrentIndex || skipElementAtCurrentIndex) == true ? 1 : 0;
        return possibilitiesMatrix[idx][sum] == 1;
    }
}
