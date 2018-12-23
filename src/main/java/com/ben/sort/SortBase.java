package com.ben.sort;

/**
 * Created by Ashley on 2018/12/23.
 */
public abstract class SortBase {

    public static void show(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public abstract void sort(Comparable[] arr);

    public boolean isSorted(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1]))
                return false;
        }
        return true;
    }

    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
