//Ben Sproull sprou028@umn.edu
//Luke Zaki zaki0007@umn.edu
public class Knight {
    private int row;
    private int col;
    private boolean isBlack;
    public Knight(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifyAdjacent(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){
            if(this.isBlack){
                return (endRow == this.row + 2 && endCol == this.col + 1 || endRow == this.row + 2 && endCol == this.col - 1 || endCol == this.col + 2 && endRow == this.row + 1 || endCol == this.col - 2 && endRow == this.row +1);
            } else {
                return (endRow == this.row - 2 && endCol == this.col + 1 || endRow == this.row - 2 && endCol == this.col - 1 || endCol == this.col + 2 && endRow == this.row - 1 || endCol == this.col - 2 && endRow == this.row - 1);
            }
        } else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) {
            if(this.isBlack){
                return (endRow == this.row + 2 && endCol == this.col + 1 || endRow == this.row + 2 && endCol == this.col - 1 || endCol == this.col + 2 && endRow == this.row + 1 || endCol == this.col - 2 && endRow == this.row + 1);
            } else {
                return (endRow == this.row - 2 && endCol == this.col + 1 || endRow == this.row - 2 && endCol == this.col - 1 || endCol == this.col + 2 && endRow == this.row - 1 || endCol == this.col - 2 && endRow == this.row - 1);
            }
        } else {
            return false;
        }

    }
}
