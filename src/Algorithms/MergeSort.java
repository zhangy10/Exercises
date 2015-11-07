package Algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        // int[] list = {1, 23, 2342, 123, 42, 4322, 3, 21, 10};
        int[] list = { 6, 3, 1, 7, 9, 5, 8, 2, 4, 0 };
        MergeSort sort = new MergeSort();
        sort.mergeSort(list);
        System.out.println(Arrays.toString(list));
    }
    
    public void mergeSort(int[] list) {
        if (list.length > 1) {
            int[] a = copy(list, 0, list.length / 2 - 1);
            int[] b = copy(list, list.length / 2, list.length - 1);
            mergeSort(a);
            mergeSort(b);
            merge(a, b, list);
        }
    }
    
    private int[] copy(int[] list, int from, int to) {
        int size = to - from + 1;
        int[] newList = new int[size];
        System.arraycopy(list, from, newList, 0, size);
        return newList;
    }
    
    private void merge(int[] a, int [] b, int[] list) {
        int i = 0;
        int j = 0;
        int k = 0;
        for(; i < a.length && j < b.length; k++) {
            if (a[i] <= b[j]) {
                list[k] = a[i];
                i++;
            }
            else {
                list[k] = b[j];
                j++;
            }
        }
        // put the rest data into original array.
        if (i == a.length) {
            // a[] has been finished, then put the rest of b into list.
            System.arraycopy(b, j, list, k, b.length - j + 1);
        }
        else {
            System.arraycopy(a, i, list, k, a.length - i + 1);
        }
    }

}
