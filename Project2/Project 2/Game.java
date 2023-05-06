//Ben Sproull sprou028@umn.edu
//Luke Zaki zaki0007@umn.edu

import java.util.Scanner;
public class Game {
    int count = 0;

    public static void main(String[] args){
        String input = "";
        Board board = new Board();
        System.out.println(board.toString());
        Scanner s = new Scanner(System.in);
        while (board.isGameOver() == false) {
            System.out.println("It is currently white's turn to play");
            System.out.println("What is your move? (format: [start row] [start column] [end row] [end column]");
            input = s.nextLine();
            if (input.equals("exit")){
                break;
            }
            if (input.equals("clear")){
                board.clear();
            }
            String[] coord = input.split(" ");
            int sr = Integer.parseInt(coord[0]);
            int sc = Integer.parseInt(coord[1]);
            int er = Integer.parseInt(coord[2]);
            int ec = Integer.parseInt(coord[3]);
            try{
                board.movePiece(sr,sc,er,ec);
                System.out.println(board.toString());
            } catch (NumberFormatException e) {
                System.out.println("invalid move");
            }
        }
            /*System.out.println(board.movePiece(1,4,3,4));
            System.out.println(board.toString());
            System.out.println(board.movePiece(0, 5, 4, 1));
            System.out.println(board.toString());

            System.out.println(board.movePiece(1, 4, 2, 4));
            System.out.println(board.toString());
            System.out.println(board.movePiece(6, 3, 4, 3));
            System.out.println(board.toString());
            System.out.println(board.movePiece(0, 5, 4, 1));
            System.out.println(board.toString());
            System.out.println(board.movePiece(4, 1, 7, 4));
            System.out.println(board.toString());*/






        /*while (board.isGameOver() == false){

            System.out.println(board.toString());
            System.out.println(board.movePiece(1,1,2,1));
            System.out.println(board.toString());
            s.hasNext();
        }*/

        /*System.out.println(board.movePiece(6,2,4,2));
        System.out.println(board.toString());
        System.out.println(board.movePiece(1,3,3,3));
        System.out.println(board.toString());
*/


        /*System.out.println(board.verifyVertical(1,1,5,1)); // True
        System.out.println(board.verifyVertical(1,1,6,1)); // True
        System.out.println(board.verifyVertical(1,1,7,1)); // False
        System.out.println(board.verifyVertical(2,1,7,1)); // False*/






    }
}
