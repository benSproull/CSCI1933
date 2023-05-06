//Ben Sproull sprou028@umn.edu
//Luke Zaki zaki0007@umn.edu
public class King {
    private int row;
    private int col;
    private boolean isBlack;
    public King(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        //if (board.verifyAdjacent(this.row, this.col, endRow, endCol) && board.getPiece(endRow,endCol) == null){
        if (board.verifyVertical(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null || board.verifyHorizontal(this.row, this.col, endRow, endCol) && board.getPiece(endRow,endCol) == null || board.verifyDiagonal(this.row,this.col,endRow,endCol) && board.getPiece(endRow,endCol) == null) {
            // Case 1: Forward movement to empty square.
            // Determine if the distance being moved is valid.
            if (this.isBlack) {
                return (endRow == this.row + 1);
            } else {
                return (endRow == this.row - 1);
            }
        } else if (this.col == endCol+1 || this.col == endCol-1) {
            // Case 2: Capturing a piece.
            if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) {
                // There is a piece of the opposite color to be captured.
                if (this.isBlack) {
                    return (endRow == this.row + 1);
                } else {
                    return (endRow == this.row - 1);
                }
            } else {
                return false;
            }
        } else {
            // Case 3: Moving in a non-adjacent column. (illegal move)
            return false;
        }
    }
}
