
package app;

import controllers.MatrixInputController;
import controllers.MatrixMultiplicationController;
import models.Matrix;


public class Runner {

    
    public static void main(String[] args) {

       MatrixInputController firstMatrixInput = new MatrixInputController();
       firstMatrixInput.execute();
       
       MatrixInputController secondMatrixInput = new MatrixInputController();
       secondMatrixInput.execute();
       
       MatrixMultiplicationController multiplicationController = 
               new MatrixMultiplicationController(firstMatrixInput.getMatrixModel(), 
               secondMatrixInput.getMatrixModel());
       multiplicationController.execute();
       
    }

}
