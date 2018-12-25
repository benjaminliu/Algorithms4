package com.ben.sort;

/**
 * Created by Ashley on 2018/12/23.
 */
public class Insertion extends SortBase {
    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        sort(arr, 0, len - 1);
    }

    public void sort(Comparable[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exch(arr, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Insertion sort = new Insertion();
        Integer[] nums = new Integer[]{6, 1, 4, 3, 5, 2};
        sort.sort(nums);

        sort.show(nums);
    }
}
