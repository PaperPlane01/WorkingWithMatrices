
package models;

public class MatrixFactory {
    
    public static Matrix generateMatrixFilledWithRandomNumbers(int numberOfRows,
            int numberOfColumns) {
        Matrix result = new Matrix(numberOfRows, numberOfColumns);
        result.fillWithRandomNumbers();
        return result;
    }
}
