package com.somedomain.algos.recursion.dynamicprog;

public class LongestCommonSubstring {


    public static int maxLengthNaive(final String firstString, final String secondString) {
        if (firstString == null || firstString.length() == 0 || secondString == null || secondString.length() == 0) {
            return 0;
        } else {
            return maxLengthNaive(firstString.toLowerCase().toCharArray(), 0, secondString.toLowerCase().toCharArray(), 0, 0);
        }
    }

    private static int maxLengthNaive(final char[] firstString, final int idxFirst, final char[] secondString, final int idxSecond, int maxCommLen) {
        int  count2 = 0, count3 = 0;

        if (idxFirst >= firstString.length || idxSecond >= secondString.length) {
            return maxCommLen;
        }
        if (firstString[idxFirst] == secondString[idxSecond]) {
            maxCommLen = maxLengthNaive(firstString, idxFirst + 1, secondString, idxSecond + 1, maxCommLen + 1);
        }

        count2 = maxLengthNaive(firstString, idxFirst, secondString, idxSecond + 1, 0);
        count3 = maxLengthNaive(firstString, idxFirst + 1, secondString, idxSecond, 0);
        maxCommLen = Math.max(maxCommLen, Math.max(count2, count3));

        return maxCommLen;
    }
}
