package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        scanner.close();
        // int[] randomArr = {1, 1231, 12312, 535, 123, 435, 12312, 5};
        // System.out.println(Arrays.toString(randomArr));
        // int[] a = new int[s1.length() >= s2.length() ? s1.length() :
        // s2.length()];
        int[] a = new int[(int) 'z' + 1];
        int[] result = convertArr(convertArr(a, s1, true), s2, false);
        boolean output = true;
        for (int i = 'A'; i <= 'z'; i++) {
            if (result[i] != 0) {
                output = false;
                break;
            }
        }
        System.out.println(output ? "Yes" : "No");
    }

    public static int[] convertArr(int[] a, String s, boolean isSum) {
        for (int i = 0; i <= s.length() - 1; i++) {
            // ******
            if (isSum) {
                a[(int) s.charAt(i)]++;
            }
            else {
                a[(int) s.charAt(i)]--;
            }
        }
        System.out.println(Arrays.toString(a));
        return a;
    }
}
