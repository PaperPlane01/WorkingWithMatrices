
package controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.Matrix;
import models.MatrixFactory;
import views.MatrixInputView;

public class MatrixInputController {

    private MatrixInputView view;
    private Matrix matrixModel;
    private Integer numberOfRows;
    private Integer numberOfColumns;
    private boolean rowSuccessfullyValidated;

    public MatrixInputController() {
        this.view = new MatrixInputView();
    }

    public MatrixInputController(MatrixInputView view) {
        this.view = view;
    }

    public MatrixInputView getView() {
        return view;
    }

    public void setView(MatrixInputView view) {
        this.view = view;
    }

    public Matrix getMatrixModel() {
        return matrixModel;
    }
    
    public void execute() {
        initMatrix();
    }

    private void initMatrix() {
        initNumberOfRows();
        initNumberOfColumns();
        matrixModel = new Matrix(numberOfRows, numberOfColumns);
        fillRows();
    }

    private void initNumberOfRows() {

        view.enterNumberOfRows();
        numberOfRows = new Integer(0);

        try {;
            numberOfRows = Integer.parseInt(view.receiveData());
        } catch (NumberFormatException ex) {
            view.showMessage("You should type an integer number. Please try again.\n");
            initNumberOfRows();
        }
    }

    private void initNumberOfColumns() {

        view.enterNumberOfColumns();
        numberOfColumns = new Integer(0);

        try {
            numberOfColumns = Integer.parseInt(view.receiveData());
        } catch (NumberFormatException ex) {
            view.showMessage("You should type an integer number. Please try again.\n");
            initNumberOfColumns();
        }
    }
    
    private void fillRows() {
        view.shouldMatrixBeFilledManually();
        String answer = view.receiveData();
        
        switch (answer) {
            case "Y":
                fillRowsManually();
                break;
            case "y":
                fillRowsManually();
                break;
            case "N":
                matrixModel = MatrixFactory.generateMatrixFilledWithRandomNumbers(numberOfRows, numberOfColumns);
                break;
            case "n":
                matrixModel = MatrixFactory.generateMatrixFilledWithRandomNumbers(numberOfRows, numberOfColumns);
                break;
            default:
                view.showMessage("You should type Y or N.");
                fillRows();
                break;
        }
    }
    
    private void fillRowsManually() {
         view.showMessage("You need to enter the rows of the matrix."
                + " Each row should conain " + matrixModel.getNumberOfColumns()
                + " values and be typed as one line of integer"
                + " numbers separated with a whitespace character.");
        view.showMessage("You should enter " + matrixModel.getNumberOfRows()
                + " rows.");
        
        int rowIndex = 0;
        while (rowIndex < matrixModel.getNumberOfRows()) {
            validateRow(rowIndex);
            if (rowSuccessfullyValidated) {
                rowIndex++;
            }
        }
    } 

    private void validateRow(int rowIndex) {

        rowSuccessfullyValidated = false;
        
        view.enterRow();
        String rowAsString = view.receiveData();

        Pattern pattern = Pattern.compile("[-?\\d\\s]+");
        Matcher enteredRow = pattern.matcher(rowAsString);

        if (enteredRow.matches()) {
            String[] rowValuesAsString = rowAsString.split("\\s");
            Integer[] rowValues = new Integer[rowValuesAsString.length];

            try {
                for (int index = 0; index < rowValues.length; index++) {
                    rowValues[index] = Integer.parseInt(rowValuesAsString[index]);
                }
            } catch (NumberFormatException ex) {
               view.showMessage("You should've typed integer numbers."
                        + " Please try again.");
                validateRow(rowIndex);
            }

            if (rowValues.length != matrixModel.getNumberOfColumns()) {
                view.showMessage("Looks like you've entered more or less values"
                        + " than required. The row should contain"
                        + " exactly " + matrixModel.getNumberOfColumns() + " values."
                        + " Please try again.");
                validateRow(rowIndex);
            } else {
                matrixModel.setRow(rowIndex, rowValues);
                rowSuccessfullyValidated = true;
            }
        } else {
            view.showMessage("You should've typed integer numbers."
                        + " Please try again.");
            validateRow(rowIndex);
        }
    }

}
