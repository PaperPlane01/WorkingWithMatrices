
package models;


public class MatrixActions {
    
    /**
     * Multiplies two matrices. 
     * @param firstMatrix The first matrix.
     * @param secondMatrix The second matrix.
     * @return Result of multiplication.
     */
    public static Matrix multiply(Matrix firstMatrix, Matrix secondMatrix) {
        Matrix resultMatrix = new Matrix(firstMatrix.getNumberOfRows(), 
                secondMatrix.getNumberOfColumns());
        for (int rowNumber = 0; rowNumber < resultMatrix.getNumberOfRows(); rowNumber++) {
            for (int columnNumber = 0; columnNumber < resultMatrix.getNumberOfColumns(); columnNumber++) {
                Integer value = 0;
                for (int iter = 0; iter < firstMatrix.getNumberOfColumns(); iter ++) {
                    value += firstMatrix.getValueAt(rowNumber, iter) * secondMatrix.getValueAt(iter, columnNumber);
                }
                resultMatrix.setValueAt(rowNumber, columnNumber, value);
            }
        }
        
        return resultMatrix;
    }
}
