package Programming;

/**
 * 
 * @author zhangy10 671205
 *
 *         Sep 5, 2015
 *
 *         Checker.java
 */
public class Checker {
	private boolean isRed;
	private int row;
	private int column;

	private static final int MIN_MOVE = 1;
	private static final int MAX_MOVE = 8;
	private static final int NUM_ROLE = 2;

	public Checker(boolean isRed) {
		this(isRed, MIN_MOVE, MIN_MOVE);
	}

	public Checker(boolean isRed, int row, int column) {
		this.isRed = isRed;
		if (!validSingleStep(row, column)) {
			row = MIN_MOVE;
			column = MIN_MOVE;
		}
		this.row = row;
		this.column = column;
	}

	public void move(int row, int column) {
		if (validStep(row, column)) {
			this.row += row;
			this.column += column;
		}
	}

	private boolean validStep(int row, int column) {
		if (Math.abs(row) != MIN_MOVE || Math.abs(column) != MIN_MOVE) {
			return false;
		}
		// has been update, negative for red one
		if (this.isRed == row > 0)
			return false;
		return validSingleStep(this.row + row, this.column + column);
	}

	private boolean validSingleStep(int row, int column){
		if (row < MIN_MOVE || row > MAX_MOVE || column < MIN_MOVE
				|| column > MAX_MOVE || (column % NUM_ROLE != row % NUM_ROLE)) {
			return false;
		}
		return true;
	}

	public boolean isRed() {
		return this.isRed;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}
}