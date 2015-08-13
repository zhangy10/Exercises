import java.util.Scanner;

public class Matrix {

	private static int blankNum = 0;
	private static long dimension = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		scanner.close();
		blankNum = input.length() * 2 + 1;
		dimension = Long.parseLong(input);
		String m = "sdfffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";

	}

	private static void printCell() {

	}

}
