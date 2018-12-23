package com.ben.sort;

/**
 * Created by Ashley on 2018/12/23.
 */
public class Selection extends SortBase {
    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (less(arr[j], arr[min]))
                    min = j;
            }
            exch(arr, i, min);
        }
    }

    public static void main(String[] args) {
        Selection sort = new Selection();
        Integer[] nums = new Integer[]{6, 1, 4, 3, 5, 2};
        sort.sort(nums);

        sort.show(nums);
    }
}
