//Written by Ben Sproull, sprou028@umn.edu
//Written by Luke Zaki, zaki0007@umn.edu

import java.lang.*;
import java.awt.Color;

public class Rectangle {
    double xpos;
    double ypos;
    double width;
    double height;
    Color color;

    public Rectangle(double xp, double yp, double wd, double ht) {
        xpos = xp;
        ypos = yp;
        width = wd;
        height = ht;
    }

    public double calculatePerimeter() {
        return (width * 2) + (height * 2);
    }

    public double calculateArea() {
        return width * height;
    }

    public void setColor(Color c) {
        color = c;
    }

    public void setPos(double xp, double yp) {
        xpos = xp;
        ypos = yp;
    }

    public void setHeight(double ht) {
        height = ht;
    }

    public void setWidth(double wd) {
        width = wd;
    }

    public Color getColor() {
        return color;

    }

    public double getXPos() {
        return xpos;
    }
    public double getYPos() {
        return ypos;
    }
    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public static void main (String[] args){
        Rectangle r1 = new Rectangle(10, 10,5, 5);
        Rectangle r2 = new Rectangle(10,10,10, 10);
        System.out.println(r1.calculateArea());
    }
}
