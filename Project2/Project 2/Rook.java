//Ben Sproull sprou028@umn.edu
//Luke Zaki zaki0007@umn.edu
public class Rook {
    private int row;
    private int col;
    private boolean isBlack;
    public Rook(int row, int col, boolean isBlack){
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    public boolean isMoveLegal(Board board, int endRow, int endCol){


        if (board.verifyVertical(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){
            if (this.isBlack){
                return (endRow == endRow - this.row) || ((endRow == this.row - endRow) && (endRow < this.row));
            } else {
                return (endRow == this.row - endRow) || ((endRow == endRow - this.row) && (endRow > this.row));
            }
        }
        if (board.verifyHorizontal(this.row, this.col, endRow, endCol)){

        }
        return false;
    }
}
