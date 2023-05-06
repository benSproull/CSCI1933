import java.util.*;

public class Matrix {
    private int nrows;
    private int ncols;
    private int[][] matrix;

    public Matrix(int nrows, int ncols){
        this.nrows = nrows;
        this.ncols = ncols;
        matrix = new int[nrows][ncols];


    }

    public Matrix(int[][] arr){
        int[][] matrix = {};

    }
    public Matrix transpose(){
        Matrix newMatrix = new Matrix(ncols,nrows);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                newMatrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        return newMatrix;
    }
    public String toString(){
        String str = " ";
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){

                str = str + matrix[j][i];

            }
            str += "\n";

        }
        return str;
    }
    public static void main(String[] args){
        Matrix Mat = new Matrix(3,3);

        System.out.println(Mat);




    }
}
