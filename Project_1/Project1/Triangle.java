//Written by Ben Sproull, sprou028@umn.edu
//Written by Luke Zaki, zaki0007@umn.edu

import java.awt.Color;
import java.lang.*;


public class Triangle {
    double x_position;
    double y_position;
    double width;
    double height;
    Color color;

    public Triangle(double xp, double yp, double wd, double ht){
        x_position = xp;
        y_position = yp;
        width = wd;
        height = ht;
    }
    public double calculatePerimeter(){
        double sideB = Math.sqrt((width/2 * width/2) + (height * height));
        return (sideB * 2) + width;
    }
    public double calculateArea(){
        return width * height * 1/2;
    }
    public void setColor(Color c){
        color = c;
    }
    public void setPos(double xp, double yp) {
        x_position = xp;
        y_position = yp;
    }
    public void setHeight(double ht){
        height = ht;
    }
    public void setWidth(double wd){
        width = wd;
    }
    public Color getColor(){
        return color;
    }
    public double getXPos() {
        return x_position;
    }
    public double getYPos() {
        return y_position;
    }
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
    public static void main (String[] args) {
    Triangle t1 = new Triangle(0,10,10,4);
    System.out.println(t1.calculatePerimeter());
    }

}
