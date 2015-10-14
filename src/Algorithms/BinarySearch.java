package Algorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int max = 33554431;
        int[] theArray = new int[max];
        for (int i = 0; i < max; i++) {
            theArray[i] = i + 1;
        }
        int count = 0;
        Pair result = binarySearch(theArray, 10, 0, max, count);
        System.out.println(result == null ? null : result.toString());
    }

    static class Pair {
        int target;
        int index;
        int count;

        public Pair(int x, int y, int z) {
            this.target = x;
            this.index = y;
            this.count = z;
        }

        public String toString() {
            return target + " + " + index + " = " + count;
        }
    }

    private static Pair binarySearch(int[] theArray, int target, int lo, int lh,
            int count) {
        if (lo > lh)
            return null;
        int mid = (lo + lh) / 2;
        ++count;
        if (theArray[mid] == target)
            return new Pair(target, mid, count);
        else if (theArray[mid] < target)
            return binarySearch(theArray, target, mid + 1, lh, count);
        else
            return binarySearch(theArray, target, lo, mid - 1, count);
    }

}
