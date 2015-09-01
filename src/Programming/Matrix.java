package Programming;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 * 
 * @author zhangy10 671205
 *
 *         Aug 16, 2015
 *
 *         Matrix.java
 */
public class Matrix {

	// File path for saving ouput
	private static final String FILE_PATH = System.getProperty("user.home")
			+ "/Desktop";
	private static final String FILE_NAME = "Result";

	// Design for N * N table, use double for big number
	private double dimension = 0;
	private int formattedNum = 0;
	private String formattedCell = "";

	// Define some string codes
	private static final String LINE_CODE = "-";
	private static final String MEET_CODE = "+";
	private static final String TABLE_CODE = "|";
	private static final String START_CODE = "*";
	private static final String BLANK_CODE = " ";

	// To write the result to a file or console
	private static Printer printer = null;

	public Matrix(String input) {
		dimension = Double.parseDouble(input);
		printer = new Printer();
		// The number of formatted blank
		formattedNum = printer.numTrim(dimension * dimension).length();
		formattedCell = " %" + formattedNum + "s ";
	}

	public Matrix(String input, boolean isWriteToFile) {
		this(input);
		if (isWriteToFile) {
			// Write the result to a file
			try {
				File file = new File(FILE_PATH + "/" + FILE_NAME);
				if (!file.exists()) {
					file.createNewFile();
				}
				printer.setFormatter(new Formatter(file));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String numStr = scanner.next();
		scanner.close();

		// The result will be printed into a file
		// Matrix matrix = new Matrix(numStr, true);
		// The result will be printed into default console
		Matrix matrix = new Matrix(numStr);
		matrix.printMatrix();
	}

	/**
	 * To print a multiplication table for n*n
	 * 
	 * 
	 */
	public void printMatrix() {
		for (double i = 0; i < dimension + 1; i++) {
			for (double j = 0; j < dimension + 1; j++) {
				double result = i * j;
				printMartix((int) i, (int) j, printer.numTrim(result));
			}
			// If not the end, print a new line
			if (i != dimension) {
				newLine();
			}
		}
		printer.close();
	}

	public void printMartix(int i, int j, String value) {
		if (i == 0 && j == 0) {
			printCell(START_CODE);
		}
		else if (j == 0) {
			printFirstCell(printer.numTrim(i));
		}
		else if (j == dimension) {
			if (i == 0) {
				printEndCell(printer.numTrim(j));
			}
			else {
				printEndCell(value);
			}
		}
		else if (i == 0) {
			printCell(printer.numTrim(j));
		}
		else {
			printCell(value);
		}
	}

	private void printEndCell(String num) {
		printCell(num, false, true);
	}

	private void printFirstCell(String num) {
		printCell(num, true, false);
	}

	private void printCell(String num) {
		printCell(num, false, false);
	}

	private void printCell(String num, boolean isFirst, boolean isEnd) {
		if (num.equals(START_CODE)) {
			int position = formattedNum / 2 + 1;
			for (int i = 0; i < formattedNum + 2; i++) {
				if (i == position) {
					printer.print(START_CODE);
				}
				else {
					printer.print(BLANK_CODE);
				}
			}
			return;
		}

		if (!isFirst) {
			printer.print(TABLE_CODE);
		}

		printer.printf(formattedCell, num);

		if (isEnd) {
			printer.println();
		}
	}

	public void newLine() {
		newLine(false);
	}

	public void newLine(boolean isEdge) {
		// first column need to be added
		for (int i = 0; i < dimension + 1; i++) {
			if (i != 0) {
				if (isEdge) {
					printer.print(LINE_CODE);
				}
				else {
					printer.print(MEET_CODE);
				}
			}
			
			// 2 means 2 blanks at the beginning and at the end
			for (int j = 0; j < formattedNum + 2; j++) {
				printer.print(LINE_CODE);
			}
		}
		printer.println();
	}

	private class Printer {

		private Formatter formatter = null;

		public Formatter getFormatter() {
			return formatter;
		}

		public void setFormatter(Formatter formatter) {
			this.formatter = formatter;
		}

		public Printer() {
		}

		public void print(String str) {
			printf(str, "");
		}

		public void println() {
			printf("%n", "");
		}

		public void printf(String str, String args) {
			if (formatter != null) {
				formatter.format(str, args);
				formatter.flush();
			}
			else {
				System.out.printf(str, args);
			}
		}

		/**
		 * To convert a double to a string, cut off the string behind "."
		 * 
		 * @param num
		 *            a double number
		 * @return a string without "."
		 */
		public String numTrim(double num) {
			String str = Double.toString(num);
			int index = str.indexOf(".");
			return str.substring(0, index);
		}

		public void close() {
			if (formatter != null) {
				formatter.close();
				formatter = null;
			}
		}
	}

}
