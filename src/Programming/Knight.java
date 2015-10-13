package Programming;

/**
 * 
 * @author Yu Zhang
 * 
 *         LoginID: zhangy10
 * 
 *         StudentID: 671205
 *
 * @ClassName: Knight
 * 
 *             Oct 6, 2015
 * 
 */
public class Knight extends ChessPiece {

    public Knight(int row, int column) {
        super(row, column);
    }

    @Override
    public boolean validMove(int toRow, int toColumn) {
        int validColumn = (Math.abs(this.row - toRow) % 2) * 2
                + Math.abs(this.row - toRow) / 2;
        if (Math.abs(this.column - toColumn) == validColumn) {
            return super.validMove(toRow, toColumn);
        }
        return false;
    }

}
