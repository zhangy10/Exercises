package Programming;
/**
 * 
 * @author zhangy10 671205
 *
 *         Sep 4, 2015
 *
 *         CheckerChecker.java
 */
public class CheckerChecker {

	private static final String YES = "CORRECT";
	private static final String NO = "BUG";

	private static final int MIN_MOVE = 1;
	private static final int MAX_MOVE = 8;
	private static final int NUM_ROLE = 2;

	public static void main(String[] args) {
		try {
			testDefaultConstructor();
			testChecker();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(NO);
			System.exit(1);
		}
		System.out.println(YES);
	}

	public static void testDefaultConstructor() throws Exception {
		// testing whether program can identify a correct role
		// 1
		for (int i = 0; i < NUM_ROLE; i++) {
			verifyStay(newChecker(i == 0 ? true : false), MIN_MOVE, MIN_MOVE);
		}
	}

	public static void testChecker() throws Exception {
		for (int i = MIN_MOVE - 1; i <= MAX_MOVE + 1; i++) {
			for (int j = MIN_MOVE - 1; j <= MAX_MOVE + 1; j++) {
				for (int k = 0; k < NUM_ROLE; k++) {
					// testing row or column is out of range case
					// testing an odd number and an even number as inputs
					// 6-10
					Checker checker = newChecker(k == 0 ? true : false, i, j);
					verifyEdge(checker.getRow(), checker.getColumn());
					// 2
					if (checker.getRow() != MIN_MOVE
							|| checker.getColumn() != MIN_MOVE) {
						verifyStay(checker, i, j);
					}
					// once create successfully, the track of red should be
					// within
					// the given area 1 to 8
					// 3-5
					testMove(checker.isRed(), checker.getRow(),
							checker.getColumn());
				}
			}
		}
	}

	private static void testMove(boolean isRed, int row, int column)
			throws Exception {
		// the max step of movement is 7 if it is toward to the same direction x
		// or y
		// for each checker, we should manage it to move to 4 direction
		// ++
		Checker checker = newChecker(isRed, row, column);
		for (int k = MIN_MOVE; k <= MAX_MOVE; k++) {
			moveStep(checker, MIN_MOVE, MIN_MOVE);
		}

		// +-
		checker = newChecker(isRed, row, column);
		for (int k = MIN_MOVE; k <= MAX_MOVE; k++) {
			moveStep(checker, MIN_MOVE, -MIN_MOVE);
		}

		// --
		checker = newChecker(isRed, row, column);
		for (int k = MIN_MOVE; k <= MAX_MOVE; k++) {
			moveStep(checker, -MIN_MOVE, -MIN_MOVE);
		}

		// -+
		checker = newChecker(isRed, row, column);
		for (int k = MIN_MOVE; k <= MAX_MOVE; k++) {
			moveStep(checker, -MIN_MOVE, MIN_MOVE);
		}

		// check the number of movement > 1
		checker = newChecker(isRed, row, column);
		moveStep(checker, row, column);
	}

	private static void moveStep(Checker checker, int row, int column)
			throws Exception {
		int stayRow = checker.getRow();
		int stayColumn = checker.getColumn();
		// since error move inputs were given, the checker should be
		// stay, otherwise throw exception
		if (!verifyMove(checker.isRed(), row, column)) {
			checker.move(row, column);
			verifyStay(checker, stayRow, stayColumn);
		}
		else {
			// for correct move inputs, the checker should be in the
			// area of table
			checker.move(row, column);
			verifyEdge(checker.getRow(), checker.getColumn());
		}
	}

	private static Checker newChecker(boolean isRed, int row, int column) {
		return new Checker(isRed, row, column);
	}

	private static Checker newChecker(boolean isRed) throws Exception {
		Checker checker = new Checker(isRed);
		if (isRed != checker.isRed()) {
			throw new Exception("Default constructor error!");
		}
		return checker;
	}

	private static boolean verifyMove(boolean isRed, int moveRow,
			int moveColumn) {
		// every step should be 1
		if (Math.abs(moveRow) != MIN_MOVE || Math.abs(moveColumn) != MIN_MOVE) {
			return false;
		}
		// the number of row should be negative (updated)!
		if (isRed == moveRow > 0) {
			return false;
		}
		return true;
	}

	private static void verifyStay(Checker checker, int stayRow, int stayColumn)
			throws Exception {
		if (checker.getRow() != stayRow || checker.getColumn() != stayColumn) {
			throw new Exception("Move error!");
		}
	}

	private static void verifyEdge(int row, int column) throws Exception {
		if (row < MIN_MOVE || row > MAX_MOVE || column < MIN_MOVE
				|| column > MAX_MOVE || (column % NUM_ROLE != row % NUM_ROLE)) {
			throw new Exception("Out of range error!");
		}
	}

}
