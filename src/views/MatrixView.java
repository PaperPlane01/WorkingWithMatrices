
package views;

import models.Matrix;


public class MatrixView {

    private Matrix model;

    public MatrixView() {

    }

    public MatrixView(Matrix model) {
        this.model = model;
    }

    public Matrix getModel() {
        return model;
    }

    public void setModel(Matrix model) {
        this.model = model;
    }
    
    public void printModel() {
        System.out.println(model);
    }
 }
