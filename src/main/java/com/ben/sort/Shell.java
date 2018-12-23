package com.ben.sort;

/**
 * Created by Ashley on 2018/12/23.
 */
public class Shell extends SortBase {
    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
            //1, 4, 13, 40, 121, 364, 1093 ...
        }

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h)
                    exch(arr, j, j - h);
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Shell sort = new Shell();
        Integer[] nums = new Integer[]{6, 1, 4, 3, 5, 2};
        sort.sort(nums);

        sort.show(nums);
    }
}
