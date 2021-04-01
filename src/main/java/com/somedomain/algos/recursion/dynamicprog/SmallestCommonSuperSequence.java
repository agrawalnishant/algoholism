package com.somedomain.algos.recursion.dynamicprog;

public class SmallestCommonSuperSequence {

    public static String findSCS(final String s1, final String s2) {
        int idx = findSCSIndex(s1, s2, 0, 0, 0);
        return idx == 0 ? s1.concat(s2) : s1.concat(s2.substring(idx));

    }

    private static int findSCSIndex(String s1, String s2, int idx1, int idx2, int count) {
        if (idx1 >= s1.length() - 1 || idx2 >= s2.length() - 1) {
            if (s1.charAt(idx1) == s2.charAt(idx2)) {
                return count + 1;
            } else {
                return 0;
            }
        }
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return findSCSIndex(s1, s2, idx1 + 1, idx2 + 1, count + 1);
        } else {
            return findSCSIndex(s1, s2, idx1 + 1, 0, 0);
        }


    }
}
