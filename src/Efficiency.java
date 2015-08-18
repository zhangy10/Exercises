import java.util.Scanner;

/**
 * 
 * @author zhangy10 671205
 *
 *         Aug 18, 2015
 *
 *         Efficiency.java
 */
public class Efficiency {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter vehicle make: ");
		String vehicleMake = scanner.nextLine();
		System.out.print("Enter vehicle model: ");
		String vehicleModle = scanner.nextLine();
		System.out.print("Enter kilometres travelled: ");
		double travelledKilo = scanner.nextDouble();
		System.out.print("Enter litres of fuel used: ");
		double usedFuel = scanner.nextDouble();
		scanner.close();
		System.out.printf("Fuel efficiency for a %s %s: %.2f litres/100 km%n",
				vehicleMake, vehicleModle, (100 * usedFuel) / travelledKilo);
	}
}
