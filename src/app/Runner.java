/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import controllers.MatrixInputController;
import controllers.MatrixMultiplicationController;
import models.Matrix;

/**
 *
 * @author Администратор
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       MatrixInputController firstMatrixInput = new MatrixInputController();
       firstMatrixInput.execute();
       
       MatrixInputController secondMatrixInput = new MatrixInputController();
       secondMatrixInput.execute();
       
       MatrixMultiplicationController multiplicationController = new MatrixMultiplicationController(firstMatrixInput.getMatrixModel(), 
               secondMatrixInput.getMatrixModel());
       multiplicationController.execute();
       
    }

}
