package com.somedomain.problems;

public class Analyze {

    private static final String TEST_STRING_UNIQ = "ABCDEF";
    private static final String TEST_STRING_REPEAT = "ABCDEFABC";
    private static final String TEST_STRING_PERMUTATION_OF_UNIQ = "ABEDC";

    public static void main(String[] args) {
        System.out.println(TEST_STRING_REPEAT + " has uniq?: " + hasAllUniqueChars(TEST_STRING_REPEAT));
        System.out.println(TEST_STRING_UNIQ + " has uniq?: " + hasAllUniqueChars(TEST_STRING_UNIQ));
        System.out.println(TEST_STRING_REPEAT + " : reversed : " + reverseInplace(TEST_STRING_REPEAT));
        System.out.println("Is " + "ABCBDEF" + " permutation of " + "ABCDEFB" + " : "
                + arePermutations(TEST_STRING_UNIQ, TEST_STRING_PERMUTATION_OF_UNIQ));
    }

    private static String reverseInplace(final String sourceString) {
        if (sourceString == null || sourceString.length() <= 1)
            return sourceString;
        char[] sourceStringChars = sourceString.toCharArray();
        int length = sourceString.length();
        int forwardCounter = 0;
        int backwardCounter = length - 1;

        while (forwardCounter <= backwardCounter) {
            int diff = sourceStringChars[forwardCounter] - sourceStringChars[backwardCounter];
            sourceStringChars[backwardCounter] = sourceStringChars[forwardCounter];
            sourceStringChars[forwardCounter] = (char) (sourceStringChars[forwardCounter] - diff);
            forwardCounter++;
            backwardCounter--;
        }
        return new String(sourceStringChars);

    }

    private static boolean hasAllUniqueChars(final String inputString) {
        boolean hasAllUnique = false;
        if (inputString == null || inputString.length() <= 0) {
            return hasAllUnique;
        } else if (inputString.length() == 1) {
            hasAllUnique = true;
        } else {
            int alphabetBits = 0;
            for (int counter = 0; counter < inputString.length(); counter++) {
                int residue = inputString.charAt(counter) - 'a' - 1;
                if ((alphabetBits & (1 << residue)) != 0) {
                    return hasAllUnique;
                } else {
                    alphabetBits |= (1 << residue);
                }
            }
            hasAllUnique = true;
        }

        return hasAllUnique;
    }

    private static boolean arePermutations(final String sourceString, final String targetString) {
        if (sourceString == targetString) {
            return true;
        }
        if (null != targetString && null != sourceString && sourceString.equals(targetString)) {
            return true;
        }
        int charsetSize = 256;

        int lengthOfSource = sourceString.length();
        int[] sourceDistri = new int[charsetSize];
        for (int c : sourceString.toCharArray()) {
            sourceDistri[c]++;
        }
        for (char c : targetString.toCharArray()) {
            if (sourceDistri[c]-- <= 0) {
                return false;
            }
        }
        return true;
    }

}
