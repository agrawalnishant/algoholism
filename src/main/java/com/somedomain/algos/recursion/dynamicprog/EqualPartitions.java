package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;

public class EqualPartitions {
    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();

    private static Integer counter;

    public static boolean hasEqualPartitionsUsingNaiveDP(int[] srcArr) {
        int sum = 0;
        counter = 0;
        for (int num : srcArr)
            sum += num;
        boolean result = sum % 2 == 0 ? hasElementsThatAddUpToUsingNaiveDP(srcArr, 0, sum / 2) : false;
        flogger.atInfo().log("Total Calculations: " + counter);
        return result;
    }

    private static boolean hasElementsThatAddUpToUsingNaiveDP(final int[] srcArr, final int idx, final int sum) {
        if (sum == 0)
            return true;
        else if (sum < 0 || idx >= srcArr.length || srcArr[idx] > sum)
            return false;

        counter++;
        return hasElementsThatAddUpToUsingNaiveDP(srcArr, idx + 1, sum) || hasElementsThatAddUpToUsingNaiveDP(srcArr, idx + 1, sum - srcArr[idx]);
    }

    public static boolean hasEqualPartitionsUsingMemoization(int[] srcArr) {
        int sum = 0;
        counter = 0;
        for (int num : srcArr)
            sum += num;
        int[][] possibilitiesMatrix = new int[srcArr.length][sum];
        for (int arrIdx = 0; arrIdx < srcArr.length; arrIdx++) {
            Arrays.fill(possibilitiesMatrix[arrIdx], -1);
        }

        boolean result = sum % 2 == 0 ? hasElementsThatAddUpToUsingMemoization(srcArr, 0, sum / 2, possibilitiesMatrix) : false;
        flogger.atInfo().log("Total Calculations: " + counter);
        return result;
    }

    private static boolean hasElementsThatAddUpToUsingMemoization(final int[] srcArr, final int idx, final int sum, final int[][] possibilitiesMatrix) {
        boolean skipElementAtCurrentIndex = false;
        if (sum == 0)
            return true;
        else if (sum < 0 || idx >= srcArr.length || srcArr[idx] > sum)
            return false;
        if (possibilitiesMatrix[idx][sum] != -1) {
            return possibilitiesMatrix[idx][sum] == 1 ? true : false;
        }
        counter++;
        boolean withElementAtCurrentIndex = hasElementsThatAddUpToUsingMemoization(srcArr, idx + 1, sum - srcArr[idx], possibilitiesMatrix);
        if (withElementAtCurrentIndex != true) {
            skipElementAtCurrentIndex = hasElementsThatAddUpToUsingMemoization(srcArr, idx + 1, sum, possibilitiesMatrix);
        }
        possibilitiesMatrix[idx][sum] = (withElementAtCurrentIndex || skipElementAtCurrentIndex) == true ? 1 : 0;
        return possibilitiesMatrix[idx][sum] == 1;
    }
}
