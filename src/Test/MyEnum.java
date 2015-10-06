package Test;

public class MyEnum implements MyDate {

	public static void main(String[] args) {
		// for (int i = 0; i < 7; i++) {
		// Day day = Day.toDay(i);
		// System.out
		// .println(day.ordinal() + " " + day.toString() + " " + day);
		// }
		//
		// int year = 2015;
		// for (int i = 0; i < 12; i++) {
		// Month month = Month.toMonth(i);
		// System.out.println(month.days(year) + " " + month.toString() + " "
		// + month.ordinal() + " " + month.source() + " " + month);
		// }

		System.out.println(Year.YEAR_2014 + " " + Year.YEAR_2014.getDay() + " "
				+ Year.YEAR_2014.getMonth() + " "
				+ Year.YEAR_2014.getMonth().days(2015));
	}

	public static boolean leapYear(int year) {
		return false;
	}

}

interface MyDate {
	/**
	 * ENUM: 1. ordinal(): type int is the ordinal value of the enum value, such
	 * as index; 2. toString(): return the declared nameof the enum value, such
	 * as "Mon"; 3. compareTo(enum): return -1, 0, 1; 4. static valuse(): return
	 * a new array of type ENUM[] holding references to all enum values
	 * 
	 */
	enum Day {
		Mon, Tue, Wed, Thu, Fri, Sat, Sun;

		private final static Day[] day = values();

		/* only private or default */
		Day() {

		}

		public static Day toDay(int n) {
			return day[n];
		}
	}

	enum Month {
		Jan(31), Feb(28), Mar(31), Apr(30), May(31), Jun(30), Jul(31), Aug(
				31), Sep(30), Oct(31), Nov(30), Dec(31);

		private final int day;
		private final static Month[] month = values();

		Month(int day) {
			this.day = day;
		}

		public int days(int year) {
			return this == Month.Feb && MyEnum.leapYear(year) ? 29 : day;
		}

		public static Month toMonth(int n) {
			return month[n];
		}

		public Month source() {
			return toMonth(ordinal());
		}
	}

	enum Year {
		YEAR_2014(Month.Sep, Day.Sun);

		private Month month;
		private Day day;

		Year(Month month, Day day) {
			this.day = day;
			this.month = month;
		}

		public Month getMonth() {
			return month;
		}

		public Day getDay() {
			return day;
		}

	}
}
