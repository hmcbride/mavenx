package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class TestSodukuValidator {
    @Test
    public void checkValidBoard() {
        SodukuValidator tester = new SodukuValidator(); // MyClass is tested

        // assert statements
        int[][] validBoard = {
                {1, 4, 7, 0, 0, 0, 0, 0, 3},
                {2, 5, 0, 0, 0, 1, 0, 0, 0},
                {3, 0, 9, 0, 0, 0, 0, 0, 0},
                {0, 8, 0, 0, 2, 0, 0, 0, 4},
                {0, 0, 0, 4, 1, 0, 0, 2, 0},
                {9, 0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 9},
                {4, 0, 0, 0, 0, 2, 0, 0, 0},
                {0, 0, 1, 0, 0, 8, 0, 0, 7},
        };
        tester.print_board(validBoard);
        tester.valid_board(validBoard);
        // An invalid validBoard. The first row contains
        // repeated values.
        assertTrue("Board is Valid",SodukuValidator.valid_board(validBoard));

    }


    @Test
    public void checkInValidBoard() {

        int [] [] invalidBoard = {
                {1, 4, 4, 0, 0, 0, 0, 0, 3},
                {2, 5, 0, 0, 0, 1, 0, 0, 0},
                {3, 0, 9, 0, 0, 0, 0, 0, 0},
                {0, 8, 0, 0, 2, 0, 0, 0, 4},
                {0, 0, 0, 4, 1, 0, 0, 2, 0},
                {9, 0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 9},
                {4, 0, 0, 0, 0, 2, 0, 0, 0},

                {0, 0, 1, 0, 0, 8, 0, 0, 7},};
        assertFalse("Board is Invalid ", SodukuValidator.valid_board(invalidBoard));

    }
}
