package com.ben.sort;

import java.util.Random;

/**
 * Created by Ashley on 2018/12/25.
 */
public class QuickMedianOfThree extends Quick {

    private Random random = new Random();

    @Override
    protected int partition(Comparable[] arr, int lo, int hi) {
        medianOfThree(arr, lo, hi);

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

    private void medianOfThree(Comparable[] arr, int lo, int hi) {
        //find median of 3 random numbers
        if (hi - lo > 3) {
            int mid1 = getRandom(lo, hi);
            int mid2 = getRandom(lo, hi);
            int mid3 = getRandom(lo, hi);

            int mid = arr[mid1].compareTo(arr[mid2]) < 0
                    ?
                    arr[mid2].compareTo(arr[mid3]) < 0 ? mid2 : arr[mid1].compareTo(arr[mid3]) < 0 ? mid3 : mid1
                    :
                    arr[mid1].compareTo(arr[mid3]) < 0 ? mid1 : arr[mid2].compareTo(arr[mid3]) < 0 ? mid2 : mid3;
            exch(arr, lo, mid);
        }
    }

    private int getRandom(int left, int right) {
        int diff = right - left;
        return random.nextInt(diff) + left;
    }

    public static void main(String[] args) {
        QuickMedianOfThree sort = new QuickMedianOfThree();
        Integer[] nums = new Integer[]{6, 1, 4, 3, 5, 2, 9, 7, 8};
        sort.sort(nums);

        sort.show(nums);
    }
}
