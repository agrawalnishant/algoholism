package com.somedomain.algos.recursion.dynamicprog;


// Incomplete and WIP
public class LongestIncreasingSequence {

    public static int maxIncLength(int[] seq, int idx, int currMaxLen) {
        int maxLen = 0;
        if (idx < seq.length - 1) {
            if (idx == 0 || seq[idx] > seq[idx - 1]) {
                int newMaxLen = maxIncLength(seq, idx + 1, currMaxLen + 1);
                if (newMaxLen > currMaxLen) {
                    maxLen = newMaxLen;
                } else {
                    maxLen = currMaxLen + 1;
                }
            } else {
                maxLen = maxIncLength(seq, idx + 1, 1) ;
            }
        } else {
            if (seq[idx] > seq[idx - 1]) {
                maxLen = 1;
            } else {
                maxLen = 0;
            }
        }
        return maxLen;
    }
}
