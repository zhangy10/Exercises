package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class TestInstanceOf {

    protected String name = "zac";

    volatile String type = "father";

    public TestInstanceOf() {
        Map<Integer, Boolean> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
    }

    public static void main(String[] args) throws checkedException {
        // Father f1 = new SonImpl();
        // calculate(f1);
        // InnerClass in = new SubClass();
        // in.print();
        // SubClass sub = new SubClass();
        // sub.print();
        // System.out.println(TestInstanceOf.add(6, 7));
//        System.out.println(add(5, 7));
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(""))) {
//            System.out.println(0 / 1);
//        }
//        catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        BufferedReader bufferedReader = new BufferedReader(new Reader());
        
        DecimalFormat format = new DecimalFormat("#0.######E0");
        System.out.println(format.format(12.7896987));
        
    }

    public static class InnerClass {
        static void print() {
            System.out.println("InnerClass");
        }
    }

    public static class SubClass extends InnerClass {
        static void print() {
            System.out.println("SubClass");
        }

    }

    public static void calculate(Father father) {
        if (father instanceof Son) {
            ((Son) father).divide();
        }
    }

    protected void print() {

    }

    protected class A {

    }

    // public static double add(int x, float y) {
    //
    // return x * y;
    // }

    public int add(float x, int y) throws checkedException {
        if (x > 0) {
            throw new checkedException();
        }
        return (int) (x * y);
    }
    
    public static String drink() {
        int x = 0;
        if (x > 0) {
//            throw new UncheckedException();
            throw new InputMismatchException();
        }
        return null;
    }

}

class UncheckedException extends RuntimeException {

}

class checkedException extends Exception {

}

abstract class Agent {
    public static void print() {
        System.out.println("yes.");
    }
}

interface Father {
    public static final int I = 0;
    public static int A = 0;
    public int S = 0;
    public void add();
}

interface Mother {
    public void say();
}

interface Son extends Father, Mother {
    public void divide();
}

class SonImpl implements Son {
    @Override
    public void add() {
        System.out.println(getClass().getName() + " add method");
    }

    @Override
    public void divide() {
        System.out.println(getClass().getName() + " divide method");
    }

    @Override
    public void say() {

    }

}
