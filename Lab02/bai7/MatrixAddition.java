package bai7;

import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the size of the matrices from the user
        int rows = 0;
        int cols = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter the number of rows and columns for the matrices: ");
                rows = Integer.parseInt(scanner.next());
                cols = Integer.parseInt(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter integers only.");
            }
        }

        // Create the two matrices
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        // Get the values for matrix1 from the user
        System.out.println("Enter the values for matrix1: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                validInput = false;
                while (!validInput) {
                    try {
                        matrix1[i][j] = Integer.parseInt(scanner.next());
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter integers only.");
                    }
                }
            }
        }

        // Get the values for matrix2 from the user
        System.out.println("Enter the values for matrix2: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                validInput = false;
                while (!validInput) {
                    try {
                        matrix2[i][j] = Integer.parseInt(scanner.next());
                        validInput = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter integers only.");
                    }
                }
            }
        }

        // Add the two matrices and store the result in a new matrix
        int[][] resultMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Print the result matrix
        System.out.println("The result of adding the two matrices is: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
}}
