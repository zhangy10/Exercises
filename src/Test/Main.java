package Test;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        ShoppingList shoppingList = new ShoppingList();
//        for (int i = 0; i < 5; i++) {
//            shoppingList.addItem((i * i) + "");
//        }
//        System.out.println(shoppingList.toString());
//        System.out.println(shoppingList.getSize());
//        
//        for (int i = 3; i < 4; i++) {
//            shoppingList.removeItem((i * i) + "");
//        }
//        System.out.println(shoppingList.toString());
//        System.out.println(shoppingList.getSize());
//        
//        for (int i = 0; i < 5; i++) {
//            shoppingList.addItem((i * i) + "");
//        }
//        System.out.println(shoppingList.toString());
//        System.out.println(shoppingList.getSize());
//        
//        for (int i = 0; i < 5; i++) {
//            shoppingList.addItem((i * i) + "");
//        }
//        System.out.println(shoppingList.toString());
//        System.out.println(shoppingList.getSize());
//        
//        for (int i = 3; i < 10; i++) {
//            shoppingList.removeItem((i * i) + "");
//        }
//        System.out.println(shoppingList.toString());
//        System.out.println(shoppingList.getSize());
        
//        int[] a = {123, 332, 1, 32, 5334, 112, 32, 53};
//        printList(a);
        
    }
    
    
    public static void printList(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("{");
            }
            System.out.print(array[i]);
            if (i == array.length - 1) {
                System.out.print("}");
            }
            else {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
