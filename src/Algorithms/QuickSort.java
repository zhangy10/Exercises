package Algorithms;

import java.util.Arrays;

public class QuickSort {
    
    public static void main(String[] args) {
//        int[] list = {1, 23, 2342, 123, 42, 4322, 3, 21, 10};
        int[] list = {6, 3, 1, 7, 9, 5, 8, 2, 4, 0};
        QuickSort sort = new QuickSort();
        sort.quickSort(list, 0, list.length - 1);
        System.out.println(Arrays.toString(list));
    }
    
    public void quickSort(int[] list, int low, int high) {
        if (low <= high) {
            int middle = partitioning(list, low, high);
            quickSort(list, low, middle - 1);
            quickSort(list, middle + 1, high);
        }
    }
    
    private int partitioning(int[] list, int low, int high) {
        int value = list[low];
        int head = low;
        int end = high;
        // be careful the index
        while (head < end) {
            while (head < high && list[head] <= value) head++;
            while (end >= low && list[end] > value) end--;
            swap(list, head, end);
        }
        // undo the last redundant swap
        swap(list, head, end);
        swap(list, low, end);
        System.out.println(Arrays.toString(list));
        return end;
    }
    
    private void swap(int[] list, int from, int to) {
        int temp = list[to];
        list[to] = list[from];
        list[from] = temp;
    }

}
