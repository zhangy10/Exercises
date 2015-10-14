package Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class DecimalToBinary {

    private static ArrayList<Integer> stack = new ArrayList<Integer>();

    public DecimalToBinary(int num) {
        function(num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.next());
        scanner.close();
        System.out.println(new DecimalToBinary(input).printBinary());
    }

    public String printBinary() {
        reverse();
        String result = "";
        for (int i = 0; i < stack.size(); i++) {
            result += stack.get(i);
        }
        return result;
    }

    private void reverse() {
        ArrayList<Integer> tempStack = new ArrayList<Integer>();
        for (int i = stack.size() - 1; i >= 0; i--) {
            tempStack.add(stack.get(i));
        }
        stack = tempStack;
    }

    public void function(int num) {
        if (num > 0) {
            // System.out.println(num % 2);
            stack.add(num % 2);
            function(num / 2);
        }
    }

}
