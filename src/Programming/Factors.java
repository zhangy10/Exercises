package Programming;

/**
 * 
 * @author zhangy10 671205
 *
 *         Aug 19, 2015
 *
 *         Factors.java
 */
public class Factors {

    public static void main(String[] args) {
        int input = 0;
        if (args != null) {
            input = Integer.parseInt(args[0]);
        }
        for (int i = 1; i <= input / 2; i++) {
            if (input % i == 0) {
                if (i != 1) {
                    System.out.print(" ");
                }
                System.out.print(i);
            }
        }
        System.out.println((input <= 1 ? "" : " ") + input);
    }

}
