//Ben Sproull sprou028@umn.edu
//Luke Zaki zaki0007@umn.edu
public class Queen {
    private int row;
    private int col;
    private boolean isBlack;

    public Queen(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    public boolean isMoveLegal(Board board, int endRow, int endCol){
        if(board.verifyDiagonal(this.row, this.col, endRow, endCol) && board.verifyVertical(this.row, this.col, endRow, endCol) && board.verifyHorizontal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){
            if(this.isBlack){
                return (endRow == this.row + endRow);
            } else {
                return (endRow == this.row - endRow);
            }
        } else if (this.col == endCol + this.col || this.col == endCol - this.col){
            if(board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack){
                if (this.isBlack) {
                    return (endRow == this.row + endRow);
                } else {
                    return (endRow == this.row - endRow);
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
