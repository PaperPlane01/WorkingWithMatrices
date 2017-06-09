/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Администратор
 */
public class MatrixFactory {
    
    public static Matrix generateMatrixFilledWithRandomNumbers(int numberOfRows,
            int numberOfColumns) {
        Matrix result = new Matrix(numberOfRows, numberOfColumns);
        result.fillWithRandomNumbers();
        return result;
    }
}
