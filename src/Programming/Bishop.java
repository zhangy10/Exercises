package Programming;

/**
 * 
 * @author Yu Zhang
 * 
 *         LoginID: zhangy10
 * 
 *         StudentID: 671205
 *
 * @ClassName: Bishop
 * 
 *             Oct 6, 2015
 * 
 */
public class Bishop extends ChessPiece {

    public Bishop(int row, int column) {
        super(row, column);
    }

    @Override
    public boolean validMove(int toRow, int toColumn) {
        if (Math.abs(this.row - toRow) == Math.abs(this.column - toColumn)) {
            return super.validMove(toRow, toColumn);
        }
        return false;
    }

}
