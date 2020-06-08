package org.example;

import java.util.HashSet;
import java.util.Set;



public class SodukuValidator {

  static  org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(SodukuValidator.class);

    // Function to check if a given row is valid. It will return:
    // -1 if the row contains an invalid value
    // 0 if thr row contains repeated values
    // 1 is the row is valid.
    public static int isRowValid(int row, int [][] grid){
        int temp[] = grid[row];
        Set<Integer>set = new HashSet<Integer>();
        for (int value : temp) {
            // Checking for values outside 0 and 9;
            // 0 is considered valid because it
            // denotes an empty cell.
            // Removing zeros and the checking for values and
            // outside 1 and 9 is another way of doing
            // the same thing.
            if (value < 0 || value > 9){
                getInvalidMessage("Bad Row Value Outside Range 0 to 9 ");
                return -1;
            }
            //Checking for repeated values.
            else if (value != 0){
                if (set.add(value) == false) {
                    getInvalidMessage("Bad Row Value Repeated Value");
                    return 0;
                }
            }
        }
        return 1;
    }
    // Function to check if a given column is valid. It will return:
    // -1 if the column contains an invalid value
    // 0 if the column contains repeated values
    // 1 is the column is valid.
    public static int isColumnValid(int col, int [][] grid){
        Set<Integer>set = new HashSet<Integer>();
        for (int i =0 ; i< 9; i++) {
            // Checking for values outside 0 and 9;
            // 0 is considered valid because it
            // denotes an empty cell.
            // Removing zeros and the checking for values and
            // outside 1 and 9 is another way of doing
            // the same thing.
            if (grid[i][col] < 0 || grid[i][col] > 9){
                getInvalidMessage("Bad Column Values Outside Range 0 to 9");
                return -1;
            }
            // Checking for repeated values.
            else if (grid[i][col] != 0){
                if (set.add(grid[i][col]) == false) {
                    getInvalidMessage("Bad Column  Repeated Value");
                    return 0;
                }
            }
        }
        return 1;
    }
    // Function to check if all the subsquares are valid. It will return:
// -1 if a subsquare contains an invalid value
// 0 if a subsquare contains repeated values
// 1 if the subsquares are valid.

    public static int isSubSquareValid(int [][] grid){
        for (int row = 0 ; row < 9; row = row + 3) {
            for (int col = 0; col < 9; col = col + 3) {
                Set<Integer>set = new HashSet<Integer>();
                for(int r = row; r < row+3; r++) {
                    for(int c= col; c < col+3; c++){
                        // Checking for values outside 0 and 9;
                        // 0 is considered valid because it
                        // denotes an empty cell.
                        // Removing zeros and the checking for values and
                        // outside 1 and 9 is another way of doing
                        // the same thing.
                        if (grid[r][c] < 0 || grid[r][c] > 9){
                            getInvalidMessage("Bad Sub Square outside Range  0 to 9");
                            return -1;
                        }
                        // Checking for repeated values.
                        else if (grid[r][c] != 0){
                            if (set.add(grid[r][c]) == false) {
                                getInvalidMessage("Bad Sub Square  Repeated Value");
                                return 0;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
    //Function to check if the board invalid.
    public static boolean isBoardValid(int [][] grid){
        // Checking the rows and columns.
        for (int i =0 ; i< 9; i++) {
            int res1 = isRowValid(i, grid);
            int res2 = isColumnValid(i, grid);
            // if a row or column is invalid, then the board is invalid.
            if (res1 < 1 || res2 < 1) {
                return false ;
            }

        }
        int res3 = isSubSquareValid(grid);
        // if any one the subsquares is invalid, then the board is invalid.
        if (res3 < 1) {
            getInvalidMessage("Subsquare Invalid");
            return  false;
        }
        else {
            getValidMsg();
            return true;
        }
    }

    public static void getInvalidMessage(String reason) {
        logger.info("INVALID "+ reason);
    }

    public static void getValidMsg() { logger.info("VALID"); }


}