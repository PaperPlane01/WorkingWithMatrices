
package models;

public class MatrixFactory {
    
    /**
     * Creates a matrix filled with random valiues.
     * @param numberOfRows Number of rows.
     * @param numberOfColumns Number of columns. 
     * @return Matrix filled with random values. 
     */
    public static Matrix generateMatrixFilledWithRandomNumbers(int numberOfRows,
            int numberOfColumns) {
        Matrix result = new Matrix(numberOfRows, numberOfColumns);
        result.fillWithRandomNumbers();
        return result;
    }
}
