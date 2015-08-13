import java.util.ArrayList;
import java.util.Scanner;

public class DecimalToBinary {
	
	private static ArrayList<Integer> stack = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int input = Integer.parseInt(scanner.next());
		scanner.close();
		function(input);
		for (int i = stack.size() - 1; i >= 0; i--) {
			System.out.print(stack.get(i));
			if (i == 0) System.out.println();
		}
	}
	
	public static void function(int num) {
		if (num > 0) {
//			System.out.println(num % 2);
			stack.add(num % 2);
			function(num / 2);
		}
	}
	
}
