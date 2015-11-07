package Algorithms;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int[] list = { 6, 3, 1, 7, 9, 5, 8, 2, 4, 0 };
        CountingSort sort = new CountingSort();
        int[] newList = sort.countingSort(list);
        System.out.println(Arrays.toString(newList));
    }
    
    public int[] countingSort(int[] list) {
        int max = list[0];
        for (int item : list) {
            if (max < item) max = item;
        }
        int[] occurrence = new int[max + 1];
        int[] newList = new int[list.length];
        for (int item : list) {
            occurrence[item]++;
        }
        for (int i = 1; i < occurrence.length; i++) {
            occurrence[i] += occurrence[i - 1];
        }
        for (int i = 0; i < list.length; i++) {
            newList[occurrence[list[i]] - 1] = list[i];
            occurrence[list[i]]--;
        }
        return newList;
    }
}
