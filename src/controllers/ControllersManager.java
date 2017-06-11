package controllers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.Matrix;
import views.ControllersManagerView;
import views.MatrixView;

public class ControllersManager {

    private ControllersManagerView view;
    private ArrayList<Matrix> matrices;
    private ArrayList<MatrixView> matrixViews;
    private ArrayList<Integer> indexes;
    private boolean indexesSuccessfullyValidated;

    public ControllersManager() {
        this.view = new ControllersManagerView();
        this.matrices = new ArrayList<>();
        this.indexes = new ArrayList<>();
        this.matrixViews = new ArrayList<>();
    }

    public void execute() {
        requestNextAction();
    }

    public void enterMatrix(Boolean... requestNextAction) {
        MatrixInputController matrixInput = new MatrixInputController();
        matrixInput.execute();
        matrices.add(matrixInput.getMatrixModel());
        matrixViews.add(new MatrixView(matrixInput.getMatrixModel()));
        isAnotherMatrixGoingToBeEntered();

        if (requestNextAction.length > 1) {
            throw new IllegalArgumentException("enterMatrix(Boolean... requestNextAction): Only one parameter is allowed");
        } else {
            if (requestNextAction.length != 0) {
                if (requestNextAction[0] = true) {
                    requestNextAction();
                }
            }
        }
    }

    public void isAnotherMatrixGoingToBeEntered(Boolean... requestNextAction) {
        
        boolean flag = false;
        if (requestNextAction.length > 1) {
            throw new IllegalArgumentException("enterMatrix(Boolean... requestNextAction): Only one parameter is allowed");
        } else {
            if (requestNextAction.length != 0) {
                if (requestNextAction[0] = true) {
                    flag = true;
                }
            }
        }
        
        view.isAnotherMatrixGoingToBeEntered();
        String answer = view.receiveData();
        

        switch (answer) {
            case "y":
                enterMatrix(flag);
                break;
            case "Y":
                enterMatrix(flag);
                break;
            case "n":
                break;
            case "N":
                break;
            default:
                view.showMessage("You should type Y or N.");
                isAnotherMatrixGoingToBeEntered();
        }
    }

    public void requestNextAction() {
       
        view.requestNextAction();
        String answer = view.receiveData();

        switch (answer) {
            case "1":
                enterMatrix(true);
                break;
            case "2":
                showMatrices(true);
                break;
            case "3":
                multiplyMatrices(true);
                break;
            case "4":
                System.exit(0);
                break;
            default:
                view.showMessage("You should type 1, 2, 3 or 4");
                requestNextAction();
                break;
        }
    }

    public void multiplyMatrices(Boolean... requestNextAction) {
        
        boolean flag = false;
        if (requestNextAction.length > 1) {
            throw new IllegalArgumentException("multiplyMatrices(Boolean... requestNextAction): Only one parameter is allowed");
        } else {
            if (requestNextAction.length != 0) {
                if (requestNextAction[0] = true) {
                    flag = true;
                }
            }
        }

        if (matrices.size() < 2) {
            view.showMessage("You should enter at least 2 matrices.");
            requestNextAction();
        } else {
            validateIndexes();
            if (indexesSuccessfullyValidated) {
                if (indexes.size() > 2) {
                    view.showMessage("You should enter two indexes. Only two matrices"
                            + " can be multiplied at once.");
                    validateIndexes();
                } else {
                    int firstIndex = indexes.get(0);
                    int secondIndex = indexes.get(1);

                    try {
                        Matrix firstMatrix = matrices.get(firstIndex);
                        Matrix secondMatrix = matrices.get(secondIndex);

                        MatricesMultiplicationController multiplication
                                = new MatricesMultiplicationController(firstMatrix, secondMatrix);
                        multiplication.setManager(this);
                        multiplication.execute();
                        requestNextAction();
                    } catch (IndexOutOfBoundsException ex) {
                        view.showMessage("Looks like you entered invalid indexes "
                                + " as one of their values is greater than the number"
                                + " of matrices you entered.\nPlease take into account"
                                + " that numeration of matrices starts from 0.\n"
                                + " Please try again.");
                        validateIndexes();
                    }
                }
            }
        }
    }

    private void validateIndexes() {

        indexes.clear();
        indexesSuccessfullyValidated = false;
        shouldMatricesBeShown();
        view.enterIndexes();

        String indexesAsString = view.receiveData();
        Pattern pattern = Pattern.compile("[\\d+\\s?]+");
        Matcher enteredIndexes = pattern.matcher(indexesAsString);

        if (enteredIndexes.matches()) {
            String[] enteredIndexesAsArray = indexesAsString.split("\\s");

            try {
                for (int iter = 0; iter < enteredIndexesAsArray.length; iter++) {
                    Integer index = Integer.parseInt(enteredIndexesAsArray[iter]);
                    indexes.add(index);
                    indexesSuccessfullyValidated = true;
                }
            } catch (NumberFormatException ex) {
                view.showMessage("You should type integer numbers. Please try again.");
            }
        } else {
            view.showMessage("You should type integer numbers. Please try again.");
        }
    }

    private void shouldMatricesBeShown() {
        view.demonstrateMatrices();
        String answer = view.receiveData();

        switch (answer) {
            case "Y":
                showMatrices(false);
                break;
            case "y":
                showMatrices(false);
                break;
            case "N":
                break;
            case "n":
                break;

        }
    }

    public void showMatrices(boolean requestNextAction) {

        if (matrices.size() == 0) {
            view.showMessage("You haven't entered any matrices yet.");
            if (requestNextAction) {
                requestNextAction();
            }
        } else {

            for (int index = 0; index < matrices.size(); index++) {
                view.showMessage("Matrix index: " + index);
                matrixViews.get(index).printModel();
            }

            if (requestNextAction) {
                requestNextAction();
            }
        }
    }

}
