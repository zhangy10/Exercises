package Test;

public class Main {

    public static void main(String[] args) {
        ShoppingList shoppingList = new ShoppingList();
        for (int i = 0; i < 20; i++) {
            shoppingList.addItem((i * i) + "");
        }
        System.out.println(shoppingList.toString());
        System.out.println(shoppingList.getSize());
        System.out.println(shoppingList.getItem(3));
        
        shoppingList.removeItem((4 * 4) + "");
        System.out.println(shoppingList.toString());
        System.out.println(shoppingList.getSize());
        System.out.println(shoppingList.getItem(3));
    }
}
