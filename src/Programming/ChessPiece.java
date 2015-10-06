package Programming;


/**
 * 
 * @author Yu Zhang
 * 
 *         LoginID: zhangy10
 * 
 *         StudentID: 671205
 *
 * @ClassName: ChessPiece
 * 
 *             Oct 6, 2015
 * 
 */
public abstract class ChessPiece {

	protected int row;
	protected int column;

	public ChessPiece(int row, int column) {
		if (!verifyEdge(row, column)) {
			row = column = 1;
		}
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean validMove(int toRow, int toColumn) {
		if (toRow == row && toColumn == column) {
			return false;
		}
		return verifyEdge(toRow, toColumn);
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " at (" + row + "," + column + ")";
	}

	protected boolean verifyEdge(int row, int column) {
		return row >= 1 && row <= 8 && column >= 1 && column <= 8;
	}
}
