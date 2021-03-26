package com.somedomain.algos.recursion.dynamicprog;

public class EqualPartitions {

    public static boolean hasEqualPartitionsUsingNaiveDP(int[] srcArr) {
        int sum = 0;
        for (int num : srcArr)
            sum += num;
        return sum % 2 == 0 ? hasElementsThatAddUpTo(srcArr, 0, sum / 2) : false;
    }

    private static boolean hasElementsThatAddUpTo(final int[] srcArr, final int idx, final int sum) {
        if (sum == 0)
            return true;
        else if (sum < 0 || idx >= srcArr.length || srcArr[idx] > sum )
            return false;

        return hasElementsThatAddUpTo(srcArr, idx + 1, sum - srcArr[idx]) || hasElementsThatAddUpTo(srcArr, idx + 1, sum);
    }
}
