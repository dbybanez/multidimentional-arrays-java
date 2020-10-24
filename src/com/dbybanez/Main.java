package com.dbybanez;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        final byte ROWS = 10;
        final byte COLS = 8;
        final int MAX_NUMBER = 99;

        int[] sumCols = new int[COLS];
        int[] sumRows = new int[ROWS];

        Random random = new Random();
//        random.nextInt(MAX_NUMBER);

        int[][] table = new int[ROWS][COLS];

        for (byte rowIndex = 0; rowIndex < ROWS; rowIndex++) {
            for (byte colIndex = 0; colIndex < COLS; colIndex++) {
                table[rowIndex][colIndex] = random.nextInt(MAX_NUMBER);

                sumRows[rowIndex] += table[rowIndex][colIndex];
                sumCols[colIndex] += table[rowIndex][colIndex];

                System.out.printf("%-10s", table[rowIndex][colIndex]);

                // Display sum of each row
                if (colIndex == (COLS - 1)) {
                    System.out.printf("%-10s", "| " + sumRows[rowIndex]);
                }

            }
            if (rowIndex == (ROWS - 1)) {
                System.out.printf("\n");
                System.out.printf("--------------------------------------------------------------------------------\n");
                for (byte colIndex = 0; colIndex < COLS; colIndex++) {
                    System.out.printf("%-10s", sumCols[colIndex]);
                }
            }
            System.out.printf("\n");
        }

        /*
         *  Finding the row with the largest number and row sum
         */

        byte indexOfMaxRow = 0;
        int maxRow = sumRows[indexOfMaxRow];
        int totalRow = 0;

        for (byte rowIndex = 0; rowIndex < ROWS; rowIndex++) {
            if (sumRows[rowIndex] > maxRow) {
                maxRow = sumRows[rowIndex];
                indexOfMaxRow = rowIndex;
            }
            totalRow += sumRows[rowIndex];
        }
        System.out.println("\nSum of row (total): " + totalRow);
        System.out.println("indexOfMaxRow is: " + indexOfMaxRow);
        System.out.println("maxRow is: " + maxRow);

        /*
         *  Finding the col with the largest number and col sum
         */

        byte indexOfMaxCol = 0;
        int maxCol = sumCols[indexOfMaxCol];
        int totalCol = 0;

        for (byte colIndex = 0; colIndex < COLS; colIndex++) {
            if (sumCols[colIndex] > maxCol) {
                maxCol = sumCols[colIndex];
                indexOfMaxCol = colIndex;
            }
            totalCol += sumRows[colIndex];
        }
        System.out.println("Sum of col (total): " + totalCol);
        System.out.println("indexOfMaxCol is: " + indexOfMaxCol);
        System.out.println("maxCol is: " + maxCol);

        /*
         * Problem:
         * Suppose a 2d array is created as follows:
         * int[][] table = new int[10][8];
         * Write a java program that does the following iterations:
         * a) Initialize table with random values between 0 and 99.
         * b) Summing all elements by column in the table. For each column, use a variable named total to store its sum.
         * c) Which row in the table has the largest sum? Use variables maxRow and indexOfMaxRow to track the largest sum and index of the row.
         */
    }
}
