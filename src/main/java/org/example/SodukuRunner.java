package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import org.apache.logging.log4j.core.Logger;

public class SodukuRunner {



    private final int width = 9;										// Grid Width (ex. 9 for a 9x9 grid)
    private int[][] grid;												// Grid that will hold the Sudoku values


    public int[][] getData(String filepath) {
        grid = new int[width][width];
        Scanner scanIn = null;					//Retrieves Input Data
        String InputLine = "";
        int row = 0;

        try {

            scanIn = new Scanner(new BufferedReader(new FileReader(filepath)));
            while (scanIn.hasNextLine()) {
                InputLine = scanIn.nextLine();
                String[] InArray = InputLine.split(",");
                for (int col = 0; col < InArray.length; col++) {
                    grid[row][col] = Integer.parseInt(InArray[col]);
                }
                row++;
            }
            scanIn.close();

        } catch (Exception e) {
            SodukuValidator.getInvalidMessage(" Bad Input: " + e);
            scanIn.close();
            return grid;
        }



        return grid;

    }

    public static void print_board(int [][] grid){
        for (int[] row : grid) {
            System.out.print("[");
            for (int y : row) {
                System.out.print(y + ", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] argv)
    {
        SodukuRunner sodukuRunner = new SodukuRunner();

        int[][] data = sodukuRunner.getData(argv[0]);
        print_board(data);

        SodukuValidator.isBoardValid(data);


    }

}
