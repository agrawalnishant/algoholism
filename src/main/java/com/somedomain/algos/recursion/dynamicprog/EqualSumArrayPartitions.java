package com.somedomain.algos.recursion.dynamicprog;

import com.google.common.flogger.FluentLogger;
import com.somedomain.algos.Utility;

public class EqualSumArrayPartitions {
    private static final FluentLogger flogger = FluentLogger.forEnclosingClass();

    private static Integer counter;

    public static boolean naiveCheck(int[] srcArr) {
        int sum = 0;
        counter = 0;
        for (int num : srcArr)
            sum += num;
        boolean result = sum % 2 == 0 && srcArr.length > 1 && naiveCheckSum(srcArr, 0, sum / 2);
        flogger.atInfo().log("Total Calculations: " + counter);
        return result;
    }

    private static boolean naiveCheckSum(final int[] srcArr, final int idx, final int sum) {
        if (sum == 0)
            return true;
        else if (sum < 0 || idx >= srcArr.length || srcArr[idx] > sum)
            return false;

        counter++;
        return naiveCheckSum(srcArr, idx + 1, sum) || naiveCheckSum(srcArr, idx + 1, sum - srcArr[idx]);
    }

    public static boolean memoizedCheck(int[] srcArr) {
        int sum = 0;
        counter = 0;
        for (int num : srcArr)
            sum += num;
        int[][] possibilitiesMatrix = Utility.buildAndInit2DMatrix(srcArr.length, sum, -1);
        boolean result = sum % 2 == 0 && srcArr.length > 1 && memoizedCheckSum(srcArr, 0, sum / 2, possibilitiesMatrix);
        flogger.atInfo().log("Total Calculations: " + counter);
        return result;
    }

    private static boolean memoizedCheckSum(final int[] srcArr, final int idx, final int sum, final int[][] possibilitiesMatrix) {
        boolean skipElementAtCurrentIndex = false;
        if (sum == 0)
            return true;
        if (sum < 0 || srcArr.length <= 1 || idx >= srcArr.length || srcArr[idx] > sum)
            return false;
        if (possibilitiesMatrix[idx][sum] != -1) {
            return possibilitiesMatrix[idx][sum] == 1;
        }

        counter++;
        boolean withElementAtCurrentIndex = memoizedCheckSum(srcArr, idx + 1, sum - srcArr[idx], possibilitiesMatrix);

        if (!withElementAtCurrentIndex) {
            skipElementAtCurrentIndex = memoizedCheckSum(srcArr, idx + 1, sum, possibilitiesMatrix);
        }
        possibilitiesMatrix[idx][sum] = (withElementAtCurrentIndex || skipElementAtCurrentIndex) ? 1 : 0;
        return possibilitiesMatrix[idx][sum] == 1;
    }
}