//Written by Ben Sproull, sprou028@umn.edu
//Written by Luke Zaki, zaki0007@umn.edu

import java.awt.Color;
import java.lang.*;

public class Circle {
    double x_position;
    double y_position;
    double radius;
    Color color;
    public static final double PI = 3.1415926;

    public Circle(double r,double xpo, double ypo){
        radius = r;
        x_position = xpo;
        y_position = ypo;

    }
    public double getRadius(){
        return radius;
    }


    public double calculatePerimeter(){
        return 2 * PI * radius;
    }
    public double calculateArea(){
        return PI * radius * radius;
    }
    public void setColor(Color c){
        color = c;
    }
    public void setPos(double xpo, double ypo){
        x_position = xpo;
        y_position = ypo;
    }
    public double setRadius(double r){
        radius = r;
        return r;
    }
    public Color getColor(){
        return color;
    }
    public double getXPos(){
        return x_position;
    }
    public double getYPos(){
        return y_position;
    }


    public static void main (String[] args){
        Circle c1 = new Circle(10, 0,0);
        Circle c2 = new Circle(20,0,0);
        System.out.println(c1.getRadius());
    }
}
