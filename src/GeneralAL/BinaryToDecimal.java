package GeneralAL;

import java.util.Scanner;

public class BinaryToDecimal {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        String array = scanner.next();
        System.out.println(function(array));
        scanner.close();
    }

    /**
     * array.substring from the beginning to the end to remove the first element
     * 
     */
    public static int function(String array) {
        int size = array.length();
        if (size == 1) {
            // the last * pow(2, 1)
            return Integer.parseInt(array);
        }
        else {
            return function(array.substring(1, size))
                    + Integer.parseInt(array.substring(0, 1))
                            * (int) Math.pow(2, size - 1);
        }
    }

}
