package Test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Apple());
        }
        set(list);
        System.out.println(list.toString());
    }

    public static void set(List<Apple> list) {
        for (Apple apple : list) {
            apple.num++;
        }
    }

}

class Apple {
    int num = 0;

    @Override
    public String toString() {
        return num + " ";
    }
}