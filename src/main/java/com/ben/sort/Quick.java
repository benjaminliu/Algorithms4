package com.ben.sort;

/**
 * Created by Ashley on 2018/12/25.
 */
public class Quick extends SortBase {

    @Override
    public void sort(Comparable[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    protected void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    protected int partition(Comparable[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = arr[lo];
        while (true) {

            //find first bigger than v
            while (less(arr[++i], v)) {
                if (i == hi)
                    break;
            }

            //find first smaller than v
            while (less(v, arr[--j])) {
                if (j == lo)
                    break;
            }

            if (i >= j)
                break;

            //exchange i,j
            exch(arr, i, j);
        }
        //exchange pivot
        exch(arr, lo, j);
        return j;
    }

    public static void main(String[] args) {
        Quick sort = new Quick();
        Integer[] nums = new Integer[]{6, 1, 4, 3, 5, 2};
        sort.sort(nums);

        sort.show(nums);
    }
}
