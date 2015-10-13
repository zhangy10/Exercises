package Programming;

/**
 * 
 * @author Yu Zhang
 * 
 *         LoginID: zhangy10
 * 
 *         StudentID: 671205
 *
 * @ClassName: Rook
 * 
 *             Oct 6, 2015
 * 
 */
public class Rook extends ChessPiece {

    public Rook(int row, int column) {
        super(row, column);
    }

    @Override
    public boolean validMove(int toRow, int toColumn) {
        if ((toRow == this.row && toColumn != this.column)
                || (toColumn == this.column && toRow != this.row)) {
            return super.validMove(toRow, toColumn);
        }

        return false;
    }
}
