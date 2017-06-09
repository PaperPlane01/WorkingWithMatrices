/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import entities.Matrix;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Администратор
 */
public class MatrixMultiplicationController {

    private Matrix firstMatrix;
    private boolean firstMatrixInitialized;
    private Matrix secondMatrix;
    private boolean secondMatrixInitialized;
    private Matrix resultMatrix;

    public MatrixMultiplicationController() {

    }

    public void start() {
        initMatrices();
        fillMatrices();
        multiplyMatrices();
    }

    private void initMatrices() {
        initFirstMatrix();
        initSecondMatrix();
    }

    private void initFirstMatrix() {
        firstMatrixInitialized = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows in the first matrix:");
        try {
            Integer numberOfRowsInFirstMatrix = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the number of columns in the first matrix:");
            try {
                Integer numberOfColumnsInFirstMatrix = Integer.parseInt(scanner.nextLine());
                firstMatrix = new Matrix(numberOfRowsInFirstMatrix, numberOfColumnsInFirstMatrix);
                firstMatrixInitialized = true;
            } catch (NumberFormatException ex) {
                System.out.println("You should enter an integer number.");
                initFirstMatrix();
            }
        } catch (NumberFormatException ex) {
            System.out.println("You should enter an integer number.");
            initFirstMatrix();
        }
    }

    private void initSecondMatrix() {
        secondMatrixInitialized = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows in the second matrix:");
        try {
            Integer numberOfRowsInSecondMatrix = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter the number of columns in the second matrix:");
            try {
                Integer numberOfColumnsInSecondMatrix = Integer.parseInt(scanner.nextLine());
                secondMatrix = new Matrix(numberOfRowsInSecondMatrix, numberOfColumnsInSecondMatrix);
                secondMatrixInitialized = true;
            } catch (NumberFormatException ex) {
                System.out.println("You should enter an integer number.");
                initSecondMatrix();
            }
        } catch (NumberFormatException ex) {
            System.out.println("You should enter an integer number.");
            initSecondMatrix();
        }
    }

    private void fillMatrices() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to fill matrices manually? Y/N");
        String answer = scanner.nextLine();
        switch (answer) {
            case "N":
                firstMatrix.fillWithRandomNumbers();
                secondMatrix.fillWithRandomNumbers();
                break;
            case "n":
                firstMatrix.fillWithRandomNumbers();
                secondMatrix.fillWithRandomNumbers();
                break;
            case "Y":
                fillFirstMatrixManually();
                fillSecondMatrixManually();
                break;
            case "y":
                fillFirstMatrixManually();
                fillSecondMatrixManually();
                break;
            default:
                System.out.println("You should type Y or N");
                fillMatrices();
                break;
        }
    }

    private void fillFirstMatrixManually() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[-?\\d\\s]+");
        System.out.println("You need to enter values contained in the rows of the first matrix. "
                + "Each row should contain " + firstMatrix.getNumberOfColumns()
                + " values. The values should be typed in one line and"
                + " separated with a whitespace character. You need to enter "
                + firstMatrix.getNumberOfRows() + " rows to continue");

        int enteredRowIndex = 0;

        while (enteredRowIndex < firstMatrix.getNumberOfRows()) {
            String rowAsString = scanner.nextLine();
            Matcher enteredRow = pattern.matcher(rowAsString);

            if (enteredRow.matches()) {
                String[] rowValuesAsString = rowAsString.split("\\s");
                Integer[] rowValues = new Integer[rowValuesAsString.length];

                for (int index = 0; index < rowValues.length; index++) {
                    try {
                        rowValues[index] = Integer.parseInt(rowValuesAsString[index]);

                    } catch (NumberFormatException ex) {
                        System.out.println("You should've typed integer numbers. Please "
                                + "try again");
                        break;
                    }
                }

                if (rowValues.length != firstMatrix.getNumberOfColumns()) {
                    System.out.println(Arrays.toString(rowValues));
                    System.out.println("Looks like you've entered less or more values"
                            + "than required. The row should contain exactly "
                            + firstMatrix.getNumberOfColumns() + " values. Please "
                            + "try again.");
                } else {
                    firstMatrix.setRow(enteredRowIndex, rowValues);
                    enteredRowIndex++;
                }
            } else {
                System.out.println("Oops, looks like you haven't entered the row correctly. "
                        + "You should type integer values separated by a whitespace "
                        + "character.");
            }
        }
    }

    private void fillSecondMatrixManually() {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[-?\\d\\s]+");
        System.out.println("You need to enter values contained in the rows of the second matrix. "
                + "Each row should contain " + secondMatrix.getNumberOfColumns()
                + " values. The values should be typed in one line and"
                + "separated with a whitespace character. You need to enter "
                + secondMatrix.getNumberOfRows() + " rows to continue");

        int enteredRowIndex = 0;

        while (enteredRowIndex < secondMatrix.getNumberOfRows()) {
            String rowAsString = scanner.nextLine();
            Matcher enteredRow = pattern.matcher(rowAsString);

            if (enteredRow.matches()) {
                String[] rowValuesAsString = rowAsString.split("[\\s]+");
                Integer[] rowValues = new Integer[rowValuesAsString.length];

                for (int index = 0; index < rowValues.length; index++) {
                    try {
                        rowValues[index] = Integer.parseInt(rowValuesAsString[index]);

                    } catch (NumberFormatException ex) {
                        System.out.println("You should've typed integer numbers. Please "
                                + "try again");
                        break;
                    }
                }

                if (rowValues.length != secondMatrix.getNumberOfColumns()) {
                    System.out.println(rowValues.length);
                    System.out.println("Looks like you've entered less or more values "
                            + "than required. The row should contain exactly "
                            + secondMatrix.getNumberOfColumns() + " values. Please "
                            + "try again.");
                } else {
                    secondMatrix.setRow(enteredRowIndex, rowValues);
                    enteredRowIndex++;
                }
            } else {
                System.out.println("Oops, looks like you haven't entered the row correctly. "
                        + "You should type integer values separated by a whitespace "
                        + "character");
            }
        }

    }

    private void multiplyMatrices() {
        if (firstMatrix.getNumberOfColumns() == secondMatrix.getNumberOfRows()) {
            resultMatrix = Matrix.multiply(firstMatrix, secondMatrix);
            System.out.println("The first matrix is:\n");
            System.out.println(firstMatrix);
            System.out.println("The second matrix is:\n");
            System.out.println(secondMatrix);
            System.out.println("The result of multiplication of these matrices:\n");
            System.out.println(resultMatrix);
        } else {
            System.out.println("The number of columns in the first matrix should be "
                    + "equal to the number of rows in the second matrix. Please try to re-enter "
                    + "matrices:\n");
            System.out.println("You need to fill matrices once more:\n");
            start();
        }
    }
}
