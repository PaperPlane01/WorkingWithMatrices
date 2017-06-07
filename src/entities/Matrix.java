/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Администратор
 */
public class Matrix {
    private ArrayList<Row> rows;
    private int numberOfRows;
    private int numberOfColumns;

    public Matrix() {
    }

    public Matrix(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.rows = new ArrayList<Row>();
        
        for (int i = 0; i < numberOfRows; i++) {
            rows.add(new Row(numberOfColumns));
        }
        
        this.numberOfColumns = numberOfColumns;
    }
    
    public boolean isSquare() {
        if (numberOfRows == numberOfColumns) {
            return true;
        } else {
            return false;
        }
    }
    
    public Integer getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).getValueAt(columnIndex);
    }
    
    public void setValueAt(int rowIndex, int columnIndex, Integer value) {
        rows.get(rowIndex).setValueAt(columnIndex, value);
    }
    
    public void addRow(Integer[] rowAsArray) {
        rows.add(new Row(rowAsArray));
        numberOfRows += 1;
    }
    
    public void setRow(int index, Integer[] rowAsArray) {
        rows.get(index).setValues(rowAsArray);
    }

    public ArrayList<Row> getRows() {
        return rows;
    }

    public void setRows(ArrayList<Row> rows) {
        this.rows = rows;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }
    
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
    
    public void fillWithRandomNumbers() {
        Random random = new Random(System.currentTimeMillis());
        
        for (Row row : rows) {
            for (int i = 0; i < row.getSize(); i++) {
                row.setValueAt(i, random.nextInt());
            }
        }
        
        System.out.println(this);
    }
    
    public static Matrix generateMatrixFilledWithRandomNumbers(int numberOfRows,
            int numberOfColumns) {
        Matrix result = new Matrix(numberOfRows, numberOfColumns);
        result.fillWithRandomNumbers();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        
        for(Row row : rows) {
            for (int index = 0; index < row.getSize(); index++) {
                result.append(row.getValueAt(index));
                result.append(" ");
            }
            result.append("\n");
        }
        
        return result.toString();
    }
    

    private class Row {
        private ArrayList<Integer> values;
        private int size;
        
        private Row() {
            
        }
        
        private Row(int size) {
            this.values = new ArrayList(Arrays.asList(new Integer[size]));
            this.size = values.size();
        }
        
        private Row(Integer[] valuesAsArray) {
            this.values = new ArrayList(Arrays.asList(valuesAsArray));
            this.size = values.size();
        }
        
        private ArrayList<Integer> getValues() {
            return this.values;
        }
        
        private void setValues(ArrayList<Integer> values) {
            this.values = values;
        }
        
        private void setValues(Integer[] valuesAsArray) {
            this.values = new ArrayList(Arrays.asList(valuesAsArray));
        }
        
        private Integer getValueAt(int index) {
            return values.get(index);
        }
        
        private void setValueAt(int index, Integer value) {
            values.set(index, value);
        }
        
        private int getSize() {
            return this.size;
        }
        
    }
   
}
