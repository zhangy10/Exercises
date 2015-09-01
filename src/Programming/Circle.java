package Programming;
/**
 * 
 * @author zhangyu 671205
 *
 */
public class Circle {

	public static void main(String[] args) {
		double diameter = 0;
		if (args != null && !args.equals("")) {
			try {
				diameter = Double.parseDouble(args[0]);
			}
			catch (Exception e) {
				// Ignore exceptions here
				// considering the case there is no input given or no arguments.
			}
		}
		System.out.printf("%.4f%n", Math.PI * Math.pow(diameter / 2, 2));
	}
}
