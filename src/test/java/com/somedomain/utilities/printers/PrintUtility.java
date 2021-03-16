package com.somedomain.utilities.printers;

public class PrintUtility {
    public static String print2D(int[][] mat) {
        // Loop through all rows
        for (int i = 0; i < mat.length; i++) {
            System.out.println();
            // Loop through all elements of current row
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");

        }
        System.out.println();
        return "";
    }
}