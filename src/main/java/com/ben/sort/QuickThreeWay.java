package com.ben.sort;

/**
 * Created by Ashley on 2018/12/25.
 */

//fit for duplicate numbers sort
public class QuickThreeWay extends Quick {

    @Override
    protected void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo)
            return;

        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        Comparable v = arr[lo];
        while (i <= gt) {
            int cmp = arr[i].compareTo(v);
            if (cmp < 0) {
                exch(arr, lt++, i++);
            } else if (cmp > 0) {
                exch(arr, i, gt--);
            } else {
                i++;
            }
        }
        //lo to lt-1  less than v
        sort(arr, lo, lt - 1);
        //gt+ to hi  bigger than v
        sort(arr, gt + 1, hi);
    }
}
