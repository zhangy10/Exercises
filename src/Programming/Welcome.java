package Programming;

/**
 * 
 * @author zhangyu 671205
 *
 */
public class Welcome {

    public static void main(String[] args) {
        // Using formatted output string
        final String greetStr = "Hello %s %s.%n";
        final String tipsStr = "Is that %s or %s?%n";
        String firstName = "";
        String secondName = "";

        // Using command line arguments for input
        if (args != null && !args.equals("")) {
            try {
                firstName = args[0];
                secondName = args[1];
            }
            catch (IndexOutOfBoundsException e) {
                // Ignore the indexOutOfBoundsException
                // considering the case there is no input given or no arguments.
            }
        }

        System.out.printf(greetStr, firstName, secondName);
        System.out.printf(tipsStr, firstName + " " + secondName.toUpperCase(),
                firstName.toUpperCase() + " " + secondName);
    }

}
