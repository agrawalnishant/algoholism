package com.somedomain.problems.sorting.sample;

import com.google.common.flogger.FluentLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private static final String REGEX = "\\d+";

    public static void main(String[] args) {
        int count = 0;
        int targetNum = 0;

        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern p = Pattern.compile(REGEX);
        Matcher m;
        try {

            String input = reader.readLine();
            m = p.matcher(input);
            if (m.find()) {
                targetNum = Integer.parseInt(m.group());
            }

            input = reader.readLine();
            m = p.matcher(input);
            if (m.find()) {
                count = Integer.parseInt(m.group());
            }

            input = reader.readLine();
            String[] strArr = input.split(" ");
            while (--count >= 0) {
                if (strArr[count].equals("" + targetNum)) {

                    logger.atFine().log("%s",count);
                    break;
                }

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}