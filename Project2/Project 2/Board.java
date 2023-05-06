//Ben Sproull sprou028@umn.edu
//Luke Zaki zaki0007@umn.edu

public class Board {

    // Instance variables
    private Piece[][] board = new Piece[8][8];

    //TODO:
    // Construct an object of type Board using given arguments.
    public Board() {
       // board = new Piece[8][8];
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR",this);

    }

    // Accessor Methods

    //TODO:
    // Return the Piece object stored at a given row and column
    public Piece getPiece(int row, int col) {

        return board[row][col];
    }

    //TODO:
    // Update a single cell of the board to the new piece.
    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    // Game functionality methods

    //TODO:
    // Moves a Piece object from one cell in the board to another, provided that
    // this movement is legal. Returns a boolean to signify success or failure.
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece moving = this.getPiece(startRow,startCol);
        Piece moveTo = this.getPiece(endRow,endCol);

        if (moving.isMoveLegal(this, endRow, endCol)){ // move is legal and executes it
            this.setPiece(endRow, endCol, moving);
            this.setPiece(startRow,startCol,null);

            return true;
        }
        System.out.println("Not a legal move try again");
        return false;   // move is not legal
    }

    //TODO:
    // Determines whether the game has been ended, i.e., if one player's King
    // has been captured.
    public boolean isGameOver() {
       int kingCount = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] != null){
                    char currentPiece = board[i][j].getCharacter();
                    if (currentPiece == '\u265a' || currentPiece == '\u2654'){
                        kingCount += 1;

                    }
                }
            }
        }
        if (kingCount != 2){
            return true;
        }

        return false;
    }

    //TODO:
    // Construct a String that represents the Board object's 2D array. Return
    // the fully constructed String.
    public String toString() {
        String finalBoard = "Board: \n" + "   \uFF10 \uFF11 \uFF12 \uFF13 \uFF14 \uFF15 \uFF16 \uFF17 \n";

        for (int i = 0; i < board.length; i++){     // rows
            switch (i){
                case 0: finalBoard += "\uFF10" + "|";
                break;
                case 1: finalBoard += "\uFF11" + "|";
                break;
                case 2: finalBoard += "\uFF12" + "|";
                break;
                case 3: finalBoard += "\uFF13" + "|";
                break;
                case 4: finalBoard += "\uFF14" + "|";
                break;
                case 5: finalBoard += "\uFF15" + "|";
                break;
                case 6: finalBoard += "\uFF16" + "|";
                break;
                case 7: finalBoard += "\uFF17" + "|";
                break;
            }
            for (int j = 0; j < board.length; j++){     // columns
                if (board[i][j] != null){
                    if (j != 7){
                        finalBoard += board[i][j].getCharacter() + " |";
                    } else{
                        finalBoard += board[i][j].getCharacter() + " |\n";
                    }

                } else{
                    if (j != 7){
                        finalBoard += "\u2001" + " |";

                    } else{
                        finalBoard += "\u2001 |\n";
                    }

                }
            }
        }


        return finalBoard;
    }

    //TODO:
    // Sets every cell of the array to null. For debugging and grading purposes.
    public void clear() {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = null;
            }
        }

    }

    // Movement helper functions

    //TODO:
    // Ensure that the player's chosen move is even remotely legal.
    // Returns a boolean to signify whether:
    // - 'start' and 'end' fall within the array's bounds.
    // - 'start' contains a Piece object, i.e., not null.
    // - Player's color and color of 'start' Piece match.
    // - 'end' contains either no Piece or a Piece of the opposite color.
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (startRow > 0 && startRow < 7 && startCol > 0 && startCol < 7){
            if (endRow > 0 && endRow < 7 && endCol > 0 && endCol < 7){
                if (this.getPiece(startRow,startCol) != null && this.getPiece(endRow,endCol) == null){
                    return true;
                }
            }
        }
        return false;
    }

    //TODO:
    // Check whether the 'start' position and 'end' position are adjacent to each other
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        // move up
        if (startRow + 1 == endRow && startCol == endCol){
            return true;
        }
        // move down
        if (startRow - 1 == endRow && startCol == endCol){
            return true;
        }
        //move right
        if (startRow == endRow && startCol + 1 == endCol){
            return true;
        }
        //move left
        if (startRow == endRow && startCol - 1 == endCol){
            return true;
        }
        return false;
    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid horizontal move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one row.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        int spaces;
        int filledSpace;

        if (startRow != endRow){
            return false;
        }
        if (endCol > startCol){   // moving to the right
            spaces = endCol - startCol;
            for (int i = 0; i < spaces; i++){
                filledSpace = startCol + i + 1;
                if (board[startRow][filledSpace] != null){
                    if (filledSpace == endCol){
                        return true;
                    }
                    return false;
                }
            }
            return true;
        } else{    // moving to the left
            spaces = startCol - endCol;
            for (int i = 0; i < spaces; i++){
                filledSpace = startCol - i -1;
                if (board[startRow][filledSpace] != null){
                    if (filledSpace == endCol){
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }

    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid vertical move.
    // Returns a boolean to signify whether:
    // - The entire move takes place on one column.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        int spaces;
        int filledSpace;

        if (startCol != endCol){ // must be in the same column inorder to move vertically
            return false;
        }
        if (startRow < endRow){   // moving up
            spaces = endRow - startRow;
            for (int i = 0; i < spaces; i++){
                filledSpace = startRow + i + 1;
                if (board[filledSpace][startCol] != null){
                    if (filledSpace == endRow){
                        return true;
                    }
                    return false;
                }
            }
            return true;
        } else {    // moving down
            spaces = startRow - endRow;
            for (int i = 0; i < spaces; i++){
                filledSpace = startRow - i - 1;
                if (board[filledSpace][startCol] != null){
                    if (filledSpace == endRow){
                        return true;
                    }
                    return false;
                }
            }
            return true;
        }



    }

    //TODO:
    // Checks whether a given 'start' and 'end' position are a valid diagonal move.
    // Returns a boolean to signify whether:
    // - The path from 'start' to 'end' is diagonal... change in row and col.
    // - All spaces directly between 'start' and 'end' are empty, i.e., null.
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        int rowD;
        int colD;
        int moveToRow = 0;
        int moveToCol = 0;

        rowD = startRow - endRow;
        if (rowD < 0){
            rowD = rowD * -1;
        }
        colD = startCol - endCol;
        if (colD < 0){
            colD = colD * -1;
        }

        if (rowD != colD){
            return false;
        }
        for (int i = 0; i < rowD; i++){   // right
            if (endCol > startCol){
                moveToCol = startCol + i + 1;
            }
            if (endCol < startCol){       // left
                moveToCol = startCol - i - 1;
            }
            if (endRow < startRow){
                moveToRow = startRow - i - 1;
            }
            if (endRow > startRow){
                moveToRow = startRow + i + 1;
            }
            if (board[moveToRow][moveToCol] != null){
                if (moveToRow == endRow && moveToCol == endCol){
                    return true;
                }
                return false;
            }
        }



        return true;
    }
}
