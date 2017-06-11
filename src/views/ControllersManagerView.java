/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.Scanner;

/**
 *
 * @author Администратор
 */
public class ControllersManagerView {
    
    private String data;
    
    public ControllersManagerView() {
        
    }
    
    public void isAnotherMatrixGoingToBeEntered() {
        showMessage("Do you want to enter another matrix? Y/N");
        Scanner scanner = new Scanner(System.in);
        data = scanner.nextLine();
    }
    
    public void enterIndexes() {
        showMessage("Enter indexes of the matrices. The indexes should be type as"
                + " one line of integer numbers separated with a whitespace character");
        Scanner scanner = new Scanner(System.in);
        data = scanner.nextLine();
    }
    
    public void requestNextAction() {
        showMessage("What to do next?");
        showMessage("1 — enter new matrix;");
        showMessage("2 — show matrices;");
        showMessage("3 — multiply matrices;");
        showMessage("4 — exit;");
        Scanner scanner = new Scanner(System.in);
        data = scanner.nextLine();
    }
    
    public void demonstrateMatrices() {
        showMessage("Do you want to see matrices you entered? Y/N");
        Scanner scanner = new Scanner(System.in);
        data = scanner.nextLine();
    }
    
    public String receiveData() {
        return data;
    }
    
    public void showMessage(String message) {
        System.out.println(message);
    }
}
