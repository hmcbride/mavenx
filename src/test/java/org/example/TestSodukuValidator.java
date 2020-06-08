package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class TestSodukuValidator {

    SodukuValidator validator;
    SodukuRunner reader;

    @Before
    public void setUpParts()
    {
        validator = new SodukuValidator();
        reader = new SodukuRunner();
    }

    @Test
    public void testFileRead()
    {
        assertNotNull(reader.getData("src/badtestfile.txt"));
    }

    @Test
    public void checkValidBoard() {

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


        // An invalid validBoard. The first row contains
        // repeated values.
        assertTrue("Board is Valid", validator.isBoardValid(validBoard));

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

        assertFalse("Board is Invalid ", SodukuValidator.isBoardValid(invalidBoard));

    }


    @Test
    public void testBadRow() {

        int [] [] invalidBoard = {
                {1, 4, 4, 0, 0, 0, 0, 0, 3},
                {2, 5, 0, 0, 0, 1, 0, 0, 0},
                {3, 0, 9, 0, 0, 0, 0, 0, 0},
                {0, 18, 0, 0, 2, 0, 0, 0, 4},
                {0, 0, 0, 4, 1, 0, 0, 2, 0},
                {9, 0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 9},
                {4, 0, 0, 0, 0, 2, 0, 0, 0},
                {0, 0, 1, 0, 0, 8, 0, 0, 7},};

        assertEquals(-1, SodukuValidator.isRowValid(3,invalidBoard));

    }



    @Test
    public void testBadColumn() {

        int [] [] invalidBoard = {
                {1, 4, 4, 0, 0, 0, 0, 0, 3},
                {2, 5, 0, 0, 0, 1, 0, 0, 0},
                {3, 0, 9, 0, 0, 0, 0, 0, 0},
                {0, 18, 0, 0, 2, 0, 0, 0, 4},
                {0, 0, 0, 4, 1, 0, 0, 2, 0},
                {9, 0, 0, 0, 0, 0, 6, 0, 0},
                {0, 0, 3, 0, 0, 0, 0, 0, 9},
                {4, 0, 0, 0, 0, 2, 0, 0, 0},
                {0, 0, 1, 0, 0, 8, 0, 0, 7},};

        assertEquals(-1, SodukuValidator.isColumnValid(1,invalidBoard));

    }
}
