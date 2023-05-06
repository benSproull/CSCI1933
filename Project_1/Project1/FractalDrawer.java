//Written by Ben Sproull, sprou028@umn.edu
//Written by Luke Zaki, zaki0007@umn.edu

// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;
import java.util.Random;

public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area

    public FractalDrawer() {
    }  // contructor


    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {

        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();    // Creates object of type random to make 3 random floats to be used in the RGB scale to create a random color
        float blue = rand.nextFloat();
        Color randomColor = new Color(red, blue, green);


        if (type.equals("Rectangle")) {
            Canvas myShape = new Canvas(1000, 1000);
            drawRectangleFractal(200.0, 200.0, 400.0, 350.0, randomColor, myShape, 0);
        }
        if (type.equals("Circle")) {
            Canvas myShape = new Canvas(1000, 1000);
            drawCircleFractal(75.0, 500.0, 400.0, randomColor, myShape, 0);
        }
        if (type.equals("Triangle")) {
            Canvas myShape = new Canvas(1000, 1000);
            drawTriangleFractal(300.0, 250.0, 300.0, 600.0, randomColor, myShape, 0);
        }
        else{
            System.out.println("Not one of the options");
        }
        System.out.print("The total area is:  ");
        return totalArea;
    }


    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        Color randomColor = new Color(red, blue, green);

        if (level < 0) {
            //base case
        } else if (level < 7) {
            Triangle tri = new Triangle(x,y,width,height);
            totalArea += tri.calculateArea();
            tri.setColor(randomColor);
            can.drawShape(tri);

            drawTriangleFractal(width/2, height/2, x-width / 2, y, c, can, level+1); //left side
            drawTriangleFractal(width/2, height/2, x+width, y, c, can, level+1); //right side
            drawTriangleFractal(width/2, height/2, x+width/4, y-height, c, can, level+1); //top
        }
    }


    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public Circle drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        Color randomColor = new Color(red, blue, green);

        if (level < 0) {
            //base case
        } else if (level < 7) {
            Circle cir = new Circle(radius, x, y);
            totalArea += cir.calculateArea();
            cir.setColor(randomColor);
            can.drawShape(cir);

            drawCircleFractal(radius / 2, x, y - radius * 2, c, can, level + 1); //top of circle
            drawCircleFractal(radius / 2, x, y + radius * 2, c, can, level + 1); //bottom of circle
            drawCircleFractal(radius / 2, x + radius * 2, y, c, can, level + 1); //right side
            drawCircleFractal(radius / 2, x - radius * 2, y, c, can, level + 1); //left side
        }
        return null;
    }


    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public Rectangle drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        Color randomColor = new Color(red, blue, green);

        if (level < 0) {
            //base case
        } else if (level < 7) {
            Rectangle rec = new Rectangle(x, y, width, height);
            totalArea += rec.calculateArea();
            //c.setColor(Color.red);
            rec.setColor(randomColor);
            can.drawShape(rec);


            drawRectangleFractal(width / 2, height / 2, x + width, y + height, c, can, (level + 1)); //bottom right side
            drawRectangleFractal(width / 2, height / 2, x - width / 2, y + height, c, can, (level + 1)); //bottom left side
            drawRectangleFractal(width / 2, height / 2, x - width / 2, y - height / 2, c, can, (level + 1)); //top left side
            drawRectangleFractal(width / 2, height / 2, x + width, y - height / 2, c, can, (level + 1)); //top right side

            }

            return null;
        }

        //TODO:
        // main should ask user for shape input, and then draw the corresponding fractal.
        // should print area of fractal
        public static void main (String[]args){


            System.out.println("What shape?");
            System.out.print("Circle, Rectangle, Triangle? ----   ");
            Scanner myScanner = new Scanner(System.in);
            String input = myScanner.nextLine();
            System.out.println("Shape = " + input);
            FractalDrawer drawer = new FractalDrawer();
            System.out.println(drawer.drawFractal(input));


        }
    }

