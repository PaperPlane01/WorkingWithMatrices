/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import models.Matrix;

/**
 *
 * @author Администратор
 */
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
