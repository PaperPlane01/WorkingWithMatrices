
package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Matrix {
    
    /**
     * Rows of the matrix.
     */
    private ArrayList<Row> rows;
    /**
     * Number of rows contained in matrix.
     */
    private int numberOfRows;
    /**
     * Number of columns contained in matrix.
     */
    private int numberOfColumns;

    public Matrix() {
    }

    /**
     * Creates a matrix with defined numbers of rows and columns.
     * @param numberOfRows Number of rows.
     * @param numberOfColumns Number of columns.
     */
    public Matrix(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.rows = new ArrayList<Row>();
        
        for (int i = 0; i < numberOfRows; i++) {
            rows.add(new Row(numberOfColumns));
        }
        
        this.numberOfColumns = numberOfColumns;
    }
    
    /**
     * Defines if matrix is square.
     * @return <Code>True</Code> if matrix is square, <Code>False</Code> if not.
     */
    public boolean isSquare() {
        if (numberOfRows == numberOfColumns) {
            return true;
        } else {
            return false;
        }
    }
    
   /**
    * Returns value of matrix's cell with specific row and column indexes.
    * @param rowIndex Index of the row.
    * @param columnIndex Index of the column.
    * @return Value of matrix's cell with specific row and column indexes.
    */
    public Integer getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).getValueAt(columnIndex);
    }
    
    /**
     * Sets new value to matrix's sell with specific row and column indexes.
     * @param rowIndex Index of the row.
     * @param columnIndex Index of the column.
     * @param value New value which is to be set.
     */
    public void setValueAt(int rowIndex, int columnIndex, Integer value) {
        rows.get(rowIndex).setValueAt(columnIndex, value);
    }
    
    /**
     * Adds new row to matrix.
     * @param rowAsArray New row repsesented as array of Integer.
     */
    public void addRow(Integer[] rowAsArray) {
        rows.add(new Row(rowAsArray));
        numberOfRows = rows.size();
    }
    
    /**
     * Replaces all values in row with specific index with values from array.
     * @param index Index of the row.
     * @param rowAsArray New values of the row.
     */
    public void setRow(int index, Integer[] rowAsArray) {
        rows.get(index).setValues(rowAsArray);
    }

    /**
     * Returns number of rows contained in matrix.
     * @return Number of rows contained in matrix.
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * Sets new a number of rows.
     * @param numberOfRows New number of rows.
     */
    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    /**
     * Returns number of columns contained in matrix
     * @return Number of columns contained in matrix
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * Allows to set a new number of columns. 
     * @param numberOfColumns New number of columns.
     */
    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }   
    
    /**
     * Allows to fill the matrix with random numbers.
     */
    public void fillWithRandomNumbers() {
        Random random = new Random(System.currentTimeMillis());
        
        for (Row row : rows) {
            for (int i = 0; i < row.getSize(); i++) {
                row.setValueAt(i, random.nextInt());
            }
        }
    }

    /**
     * Allows to get string representation of matrix.
     * @return String representation of matrix.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        for (Row row : rows) {
            for (int index = 0; index < row.getSize(); index++) {
                result.append(row.getValueAt(index));
                result.append(" ");
            }
            result.append("\n");
        }
        
        return result.toString();
    }
    

    private class Row {
        /**
         * Values contained in the row.
         */
        private ArrayList<Integer> values;
        /**
         * The size of the row.
         */
        private int size;
        
        private Row() {
            
        }
        
        /**
         * Creates a new row with specific size.
         * @param size Size of the row.
         */
        private Row(int size) {
            this.values = new ArrayList(Arrays.asList(new Integer[size]));
            this.size = values.size();
        }
        
        /**
         * Creates a new row from array of Integer.
         * @param valuesAsArray Array with integer numbers.
         */
        private Row(Integer[] valuesAsArray) {
            this.values = new ArrayList(Arrays.asList(valuesAsArray));
            this.size = values.size();
        }
        
        /**
         * Returns values contained in the row.
         * @return Values contained in the row.
         */
        private ArrayList<Integer> getValues() {
            return this.values;
        }
        
        /**
         * Sets new values to the row.
         * @param values New values which are to be set.
         */
        private void setValues(ArrayList<Integer> values) {
            this.values = values;
            size = values.size();
        }
        
        /**
         * Sets new values to the row.
         * @param valuesAsArray New values which are to be set (represented as array)
         */
        private void setValues(Integer[] valuesAsArray) {
            this.values = new ArrayList(Arrays.asList(valuesAsArray));
            size = valuesAsArray.length;
        }
        
        /**
         * Returns value located at the specific index.
         * @param index Index of the value.
         * @return Value located at the specific index.
         */
        private Integer getValueAt(int index) {
            return values.get(index);
        }
        
        /**
         * Allows to set new value located at the specific index. 
         * @param index Index of the value.
         * @param value New value which is to be set.
         */
        private void setValueAt(int index, Integer value) {
            values.set(index, value);
        }
        
        /**
         * Allows to know the size of the row. 
         * @return Size of the row.
         */
        private int getSize() {
            return this.size;
        }
        
    }
   
}
