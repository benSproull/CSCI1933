//Ben Sproull sprou028@umn.edu
//Luke Zaki zaki0007@umn.edu

public class Bishop {
    private int row;
    private int col;
    private boolean isBlack;

    public Bishop(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if(board.verifyDiagonal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){
            if(this.isBlack){
                return (endRow == this.row + endRow && endCol == endCol - this.col || endRow == this.row + endRow && endCol == endCol || endCol == endCol);
                //return (this.row == endRow && this.col == endCol);
            } else {
                return (endRow == this.row - endRow && endCol == this.col + endCol || endRow == this.row - endRow && endCol == this.col - endCol || endCol == endCol);
            }
        }else if (this.col == endCol + 1 || this.row == endRow + 1) {
            if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) {
                if (this.isBlack) {
                    return (endRow == this.row + endRow && endCol == endCol);
                } else{
                    return (endRow == this.row - endRow && endCol == this.col - endCol);
                }
            } else{
                return false;
            }
        } else {
            return false;
        }
    }


}
