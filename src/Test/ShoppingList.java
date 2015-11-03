package Test;

public class ShoppingList {
    
    private int size = 0;
    private String[] list;
    private final static int MAX = 20;
    
    public ShoppingList() {
        this.list = new String[MAX];
    }
    
    int getSize() {
        return size;
    }
    
    void addItem(String item) {
        if (item == null) {
            return;
        }
        size++;
        for (int i = 0; i < size; i++) {
            if (list[i] == null) {
                list[i] = item;
                break;
            }
        }
    }
    
    boolean removeItem(String item) {
        int removeIndex = -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                removeIndex = i;
                break;
            }
        }
        if (removeIndex == -1) {
            return false;
        }
        removeByIndex(removeIndex);
        return true;
    }
    
    String getItem(int num) {
        return list[num];
    }
    
    private void removeByIndex(int index) {
        for (int i = index + 1; i < size; i++) {
            list[i - 1] = list[i];
            list[i] = null;
        }
        size--;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(list[i] + " ");
        }
        return sb.toString();
    }
}
