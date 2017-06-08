/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import entities.Matrix;

/**
 *
 * @author Администратор
 */
public class Runner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       MatrixMultiplicationController controller = new MatrixMultiplicationController();
       controller.start();
       
    }

}
