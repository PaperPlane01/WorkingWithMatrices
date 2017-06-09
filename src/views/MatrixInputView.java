/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.MatrixInputController;
import java.util.Scanner;

/**
 *
 * @author Администратор
 */
public class MatrixInputView {
    
    private String data;
    private MatrixInputController controller;
    
    public MatrixInputView() {
        
    }
    
    public void enterNumberOfRows() {
        Scanner scanner = new Scanner(System.in);
        showMessage("Enter the number of rows contained in matrix:");
        data = scanner.nextLine();
    }
    
    public void enterNumberOfColumns() {
        Scanner scanner = new Scanner(System.in);
        showMessage("Enter the number of columns contained in matrix:");
        data = scanner.nextLine();
    }
    
    public void shouldMatrixBeFilledManually() {
        Scanner scanner = new Scanner(System.in);
        showMessage("Do you want to fill matrix manually?");
        data = scanner.nextLine();
    }
    
    public void enterRow() {
        Scanner scanner = new Scanner(System.in);
        showMessage("Enter the row. The row should be typed as one line of integer"
                + " numbers separated with a whitespace character.");
        data = scanner.nextLine();
    }
    
    public String receiveData() {
        return data;
    }
    
    public void showMessage(String message) {
        System.out.println(message);
    }
}
