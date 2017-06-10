
package app;

import controllers.MatrixInputController;
import controllers.MatricesMultiplicationController;


public class Runner {

    
    public static void main(String[] args) {
        
        start();
    }
    
    public static void start() {
        MatrixInputController firstMatrixInput = new MatrixInputController();
       firstMatrixInput.execute();
       
       MatrixInputController secondMatrixInput = new MatrixInputController();
       secondMatrixInput.execute();
       
       MatricesMultiplicationController multiplicationController = 
               new MatricesMultiplicationController(firstMatrixInput.getMatrixModel(), 
               secondMatrixInput.getMatrixModel());
       multiplicationController.execute();
    }

}
