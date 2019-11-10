package com.somedomain.problems.string;

import com.google.common.flogger.FluentLogger;

public class Unique {

    public boolean hasAllUniqueChars(final String inputString) {
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
}
