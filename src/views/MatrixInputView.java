
package views;

import controllers.MatrixInputController;
import java.util.Scanner;

public class MatrixInputView {
    
    private String data;
    
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
        showMessage("Do you want to fill matrix manually? Y/N");
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
