package Test;

import java.util.List;

public class Test2<ab, sd> extends TestInstanceOf{

    public Test2() {
        super();
    }
    
    public Test2(int number) {
        this();
    }
    
    @Override
    public int add(float x, int y) throws checkedException  {
        // TODO Auto-generated method stub
        return super.add(x, y);
    }
    
    public static void main(String[] args) {
//        List<Apple> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(new Apple());
//        }
//        set(list);
//        System.out.println(list.toString());
        Test2 t = new Test2(3);
        TestInstanceOf test = new TestInstanceOf();
        test.name = "Zac";
        test.print();
        TestInstanceOf.A a = test.new A();
    }

    public static void set(List<Apple> list) {
        for (Apple apple : list) {
            apple.num++;
        }
    }
    
    public void print() {
        System.out.println(type);
    }

}

class Apple {
    int num = 0;

    @Override
    public String toString() {
        return num + " ";
    }
}