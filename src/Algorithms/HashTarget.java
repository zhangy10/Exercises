package Algorithms;

import java.util.Arrays;

/**
 * 
 * @author zhangy10 671205
 *
 *         Aug 29, 2015
 *
 *         HashTarget.java
 */
public class HashTarget {
    private int[] hash;
    private int size;
    private int[] theArray;

    public int[] getArray() {
        return theArray;
    }

    public static void main(String[] args) {
        HashTarget hashTarget = new HashTarget(20);
        System.out.println(Arrays.toString(hashTarget.getArray()));
        Pair pair = hashTarget.getTarget(50);
        System.out.println(pair != null ? pair.toString() : -1);
    }

    public HashTarget(int size) {
        this.size = size;
        theArray = new int[this.size];
        generateRandomArray();
        hash = new int[findMax() + 1];
        for (int i = 0; i < this.size; i++) {
            hash[theArray[i]]++;
        }
    }

    public int getSize() {
        return size;
    }

    private void generateRandomArray() {
        for (int i = 0; i < size; i++) {
            // Generate a random array with values between
            // 10 and 59
            theArray[i] = (int) (Math.random() * 50) + 10;
        }
    }

    private int findMax() {
        int maxNum = theArray[0];
        for (int i = 0; i < size; i++) {
            if (maxNum < theArray[i]) {
                maxNum = theArray[i];
            }
        }
        return maxNum;
    }

    class Pair {
        int x;
        int y;
        int target;

        public String toString() {
            return x + " + " + y + " = " + target;
        }
    }

    public Pair getTarget(int target) {
        for (int i = 0; i < size; i++) {
            int restNum = target - theArray[i];
            if (restNum < 0) {
                break;
            }
            if (hash[restNum] != 0) {
                Pair pair = new Pair();
                pair.x = restNum;
                pair.y = theArray[i];
                pair.target = target;
                return pair;
            }
        }

        return null;
    }

}
