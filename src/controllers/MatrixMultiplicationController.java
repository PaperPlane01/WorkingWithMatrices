
package controllers;

import models.Matrix;
import views.MatricesMultiplicationView;
import views.MatrixView;


public class MatrixMultiplicationController {

    private Matrix firstMatrix;
    private MatrixView firstMatrixView;
    private Matrix secondMatrix;
    private MatrixView secondMatrixView;
    private Matrix resultMatrix;
    private MatrixView resultMatrixView;
    private MatricesMultiplicationView view;

    public MatrixMultiplicationController(Matrix firsMatrix, Matrix secondMatrix) {
        this.firstMatrix = firsMatrix;
        this.firstMatrixView = new MatrixView(firsMatrix);

        this.secondMatrix = secondMatrix;
        this.secondMatrixView = new MatrixView(secondMatrix);
        
        this.resultMatrixView = new MatrixView();

        this.view = new MatricesMultiplicationView();
    }

    public void execute() {
        if (areMatricesInvalid()) {
            view.showMessage("The number of columns in the first matrix should be"
                    + " equal to the number of rows in the second matrix. Please try to re-enter"
                    + " matrices:\n");
            MatrixInputController matrixInput = new MatrixInputController();
            matrixInput.execute();
        } else {
            multiplyMatrices();
        }
    }

    private boolean areMatricesInvalid() {
        if (firstMatrix.getNumberOfColumns() != secondMatrix.getNumberOfRows()) {
            return true;
        } else {
            return false;
        }
    }

    private void multiplyMatrices() {
        resultMatrix = Matrix.multiply(firstMatrix, secondMatrix);
        updateMatrixViews();
        showResult();
    }
    
    private void showResult() {
        view.showMessage("The first matrix is:");
        firstMatrixView.printModel();
        view.showMessage("The second matrix is:");
        secondMatrixView.printModel();
        view.showMessage("The result of multuplication is:");
        resultMatrixView.printModel();
    }
    
    private void updateMatrixViews() {
        firstMatrixView.setModel(firstMatrix);
        secondMatrixView.setModel(secondMatrix);
        resultMatrixView.setModel(resultMatrix);
    }
}
