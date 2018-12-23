package com.ben.sort;

/**
 * Created by Ashley on 2018/12/23.
 */

//fit for linked list
public class MergeBottonUp extends MergeBase {
    @Override
    public void sort(Comparable[] arr) {
        int len = arr.length;
        aux = new Comparable[len];
        int last = len - 1;
        for (int size = 1; size < len; size *= 2) {
            int step = size * 2;
            for (int lo = 0, end = len - size; lo < end; lo += step) {
                int mid = lo + size - 1;
                merge(arr, lo, mid, Math.min(mid + size, last));
            }
        }
    }

    public static void main(String[] args) {

        MergeBottonUp sort = new MergeBottonUp();

        Integer[] nums = new Integer[]{6, 1, 4, 3, 5, 2};
        sort.sort(nums);

        sort.show(nums);
    }
}
