// Names: Ben Sproull & Luke Zaki
// x500s: sprou028      zaki0007

import java.util.Random;
import java.util.Scanner;

public class MyMaze{
    Cell[][] maze;
    int startRow;
    int endRow;

    public static int randomInt()
    {
        double randomNumber = Math.random();
        randomNumber = randomNumber * 4;
        return (int)(randomNumber);
    }

    public MyMaze(int rows, int cols, int startRow, int endRow) {
        this.startRow = startRow;
        this.endRow = endRow;
        maze = new Cell[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                maze[i][j] = new Cell();
                if (i == endRow - 1 && j == cols - 1){
                    maze[i][j].setRight(false);
                }
            }
        }

    }
    /* TODO: Create a new maze using the algorithm found in the writeup. */
    public static MyMaze makeMaze(int rows, int cols, int startRow, int endRow) {
        MyMaze madeMaze = new MyMaze(rows, cols, startRow, endRow);
        Stack1Gen<int[]> stack = new Stack1Gen();
        int[] hold = new int[2];
        int[] currentSpot;
        hold[0] = startRow;
        hold[1] = 0;
        stack.push(hold);
        madeMaze.maze[startRow][0].setVisited(true);
        while (!stack.isEmpty()){
            hold = stack.top();
            boolean visitAll = true;

            if (hold[0] - 1 >= startRow && !madeMaze.maze[hold[0] - 1][hold[1]].getVisited()){  //upward
                visitAll = false;

            }
            if (hold[0] + 1 < endRow && !madeMaze.maze[hold[0] + 1][hold[1]].getVisited()){     //downward
                visitAll = false;

            }
            if (hold[1] + 1 <= madeMaze.maze[0].length - 1 && !madeMaze.maze[hold[0]][hold[1] + 1].getVisited()){     //right
                visitAll = false;

            }
            if (hold[1] - 1 >= 0 && !madeMaze.maze[hold[0]][hold[1] - 1].getVisited()){     //left
                visitAll = false;

            }
            if (visitAll){
                stack.pop();

            }
            else{
                int dir = randomInt();
                if (dir == 0 && hold[0] - 1 >= startRow && !madeMaze.maze[hold[0] - 1][hold[1]].getVisited()){ //up
                    madeMaze.maze[hold[0] - 1][hold[1]].setBottom(false);
                    madeMaze.maze[hold[0] - 1][hold[1]].setVisited(true);
                    currentSpot = new int[2];
                    currentSpot[0] = hold[0] - 1;
                    currentSpot[1] = hold[1];
                    stack.push(currentSpot);


                }
                else if (dir == 1 && hold[0] + 1 <= endRow - 1 && !madeMaze.maze[hold[0] + 1][hold[1]].getVisited()){  //down
                    madeMaze.maze[hold[0]][hold[1]].setBottom(false);
                    madeMaze.maze[hold[0] + 1][hold[1]].setVisited(true);
                    currentSpot = new int[2];
                    currentSpot[0] = hold[0] + 1;
                    currentSpot[1] = hold[1];
                    stack.push(currentSpot);
                }
                else if (dir == 3 && hold[1] + 1 <= cols - 1 && !madeMaze.maze[hold[0]][hold[1] + 1].getVisited()){ //right
                    madeMaze.maze[hold[0]][hold[1]].setRight(false);
                    madeMaze.maze[hold[0]][hold[1] + 1].setVisited(true);
                    currentSpot = new int[2];
                    currentSpot[0] = hold[0];
                    currentSpot[1] = hold[1] + 1;
                    stack.push(currentSpot);
                }
                else if (dir == 2 && hold[1] - 1 >= 0 && !madeMaze.maze[hold[0]][hold[1] - 1].getVisited()){ //left
                    madeMaze.maze[hold[0]][hold[1] - 1].setRight(false);
                    madeMaze.maze[hold[0]][hold[1] - 1].setVisited(true);
                    currentSpot = new int[2];
                    currentSpot[0] = hold[0];
                    currentSpot[1] = hold[1] - 1;
                    stack.push(currentSpot);
                }
            }

        }
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                madeMaze.maze[i][j].setVisited(false);
            }
        }


        return madeMaze;
    }

    /* TODO: Print a representation of the maze to the terminal */
    public void printMaze() {
        for (int i = 0; i < (maze.length * 2) + 1; i++){
            String mazePrint = "";
            if (i == (startRow * 2) + 1){
                mazePrint += " ";
            }
            else{
                mazePrint += "|";
            }
            for (int j = 0; j < maze[0].length; j++){
                if (i == 0 || i == maze.length * 2){
                    mazePrint += "---|";
                }
                else if (i % 2 == 1){
                    if (maze[i/2][j].getVisited()){
                        mazePrint += " * ";
                    }
                    else if (!maze[i/2][j].getVisited()){
                        mazePrint += "   ";
                    }
                    if (maze[i/2][j].getRight()){
                        mazePrint += "|";
                    }
                    else if (!maze[i/2][j].getRight()){
                        mazePrint += " ";
                    }
                }
                else if (i % 2 != 1){
                    if (maze[i/2 - 1][j].getBottom()){
                        mazePrint += "---|";
                    }
                    else if (!maze[i/2 - 1][j].getBottom()){
                        mazePrint += "   |";
                    }
                }
            }
            System.out.println(mazePrint);
        }
    }

    /* TODO: Solve the maze using the algorithm found in the writeup. */
    public void solveMaze() {
        Q1Gen solve = new Q1Gen();
        int[] hold = new int[2];
        int[] temp;
        hold[0] = startRow;
        hold[1] = 0;
        //temp[0] = hold[1];
        solve.add(hold);
        while(solve.length() > 0){
            hold = (int[]) solve.remove();
            maze[hold[0]][hold[1]].setVisited(true);
            if(hold[0] == endRow - 1 && hold[1] == maze[0].length - 1){
                break;
            }else {
                if (hold[0] - 1 >= startRow) {
                    if (!maze[hold[0] - 1][hold[1]].getVisited() && !maze[hold[0] - 1][hold[1]].getBottom()) {
                        temp = new int[2];
                        temp[0] = hold[0] - 1;
                        temp[1] = hold[1];
                        solve.add(temp);
                    }
                }
                if (hold[0] + 1 <= endRow - 1) {
                    if (!maze[hold[0] + 1][hold[1]].getVisited() && !maze[hold[0]][hold[1]].getBottom()) {
                        temp = new int[2];
                        temp[0] = hold[0] + 1;
                        temp[1] = hold[1];
                        solve.add(temp);
                    }
                }
                if (hold[1] - 1 >= 0) {
                    if (!maze[hold[0]][hold[1] - 1].getVisited() && !maze[hold[0]][hold[1] - 1].getRight()) {
                        temp = new int[2];
                        temp[0] = hold[0];
                        temp[1] = hold[1] - 1;
                        solve.add(temp);
                    }
                }
                if (hold[1] + 1 <= maze[0].length - 1) {
                    if (!maze[hold[0]][hold[1] + 1].getVisited() && !maze[hold[0]][hold[1]].getRight()) {
                        temp = new int[2];
                        temp[0] = hold[0];
                        temp[1] = hold[1] + 1;
                        solve.add(temp);
                    }
                }
            }
        }
        printMaze();

    }

    public static void main(String[] args){

        /*Make and solve maze */
        Scanner myScanner = new Scanner(System.in);
        int row = 0;
        int col = 0;
        int start = 0;
        int end = 0;
        System.out.println("WELCOME TO THE MAZE SOLVER");
        System.out.println("\nEnter dimension of the row: ");
        while(true){
            row = myScanner.nextInt();
            if(row > 0){
                break;
            } else {
                System.out.println("\nInvalid row dimension");
                System.out.println("Please re-enter row dimension");
                System.out.println("Note: row dimension must be greater than 0");
            }
        }
        System.out.println("\nEnter dimension of the column: ");
        while(true){
            col = myScanner.nextInt();
            if(col > 0){
                break;
            } else {
                System.out.println("\nInvalid row dimension");
                System.out.println("Please re-enter column dimension that is greater than 0");
                System.out.println("Note: column dimension must be greater than 0");
            }
        }
        System.out.println("\nEnter what row you would like to have your first step: ");
        while(true){
            start = myScanner.nextInt();
            if(start >= 0 && start < row){
                break;
            } else {
                System.out.println("\nInvalid start dimension");
                System.out.println("Please re-enter start row dimension");
            }
        }
        System.out.println("\nEnter what row you would like to have your last step: ");
        while(true){
            end = myScanner.nextInt();
            if(end > start && end > 0 && end <= row){
                break;
            } else {
                System.out.println("\nInvalid end row dimension");
                System.out.println("Please re-enter end row dimension");
            }
        }
        System.out.println("\n");
        MyMaze test = new MyMaze(row, col ,start, end);
        test = test.makeMaze(row, col, start, end);
        test.solveMaze();


    }
}
