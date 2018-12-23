package com.ben.sort;

/**
 * Created by Ashley on 2018/12/23.
 */
public class MergeTopDown extends MergeBase {

    @Override
    public void sort(Comparable[] arr) {
        aux = new Comparable[arr.length];
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    public static void main(String[] args) {
        MergeTopDown sort = new MergeTopDown();
        Integer[] nums = new Integer[]{6, 1, 4, 3, 5, 2};
        sort.sort(nums);

        sort.show(nums);
    }
}
