package Test;

public class Main {

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        for (int i = 0; i < 5; i++) {
            shoppingList.addItem((i * i) + "");
        }
        System.out.println(shoppingList.toString());
        System.out.println(shoppingList.getSize());
        
        for (int i = 3; i < 4; i++) {
            shoppingList.removeItem((i * i) + "");
        }
        System.out.println(shoppingList.toString());
        System.out.println(shoppingList.getSize());
        
        for (int i = 0; i < 5; i++) {
            shoppingList.addItem((i * i) + "");
        }
        System.out.println(shoppingList.toString());
        System.out.println(shoppingList.getSize());
        
        for (int i = 0; i < 5; i++) {
            shoppingList.addItem((i * i) + "");
        }
        System.out.println(shoppingList.toString());
        System.out.println(shoppingList.getSize());
        
        for (int i = 3; i < 10; i++) {
            shoppingList.removeItem((i * i) + "");
        }
        System.out.println(shoppingList.toString());
        System.out.println(shoppingList.getSize());
    }
}
