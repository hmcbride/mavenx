package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SodukuCSVReader {

    private final int width = 9;										// Grid Width (ex. 9 for a 9x9 grid)
    private int[][] grid;												// Grid that will hold the Sudoku values
    private List<Integer> possibleValues;								// Assigns possible values to each Sudoku cell
    private static String sudokuinput = "sudokuinput.csv";				// Location of the Sudoku input csv file
    private static String sudokuoutput = "sudokuoutput.csv"; 			// Location of the Sudoku output csv file



    public int[][] getData(String filepath) {
        grid = new int[width][width];
        Scanner scanIn = null;					//Retrieves Input Data
        String InputLine = "";
        int row = 0;
        possibleValues = new ArrayList<Integer>();

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
            System.out.println("INVALID Bad Input: " + e);
            scanIn.close();
            return grid;
        }

        for (int i=1; i<=width; i++) {       // Specifies the possible values for a given cell (ex. in a 3x3 puzzle 1 to 9 are possible values)
            possibleValues.add(i);
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
        SodukuCSVReader csvReader = new SodukuCSVReader();

        int[][] data = csvReader.getData(argv[0]);
    }

}
