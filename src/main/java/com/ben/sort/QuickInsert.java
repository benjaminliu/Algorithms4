package com.ben.sort;

/**
 * Created by Ashley on 2018/12/25.
 */
public class QuickInsert extends Quick {
    private static final int switch2InsertLimit = 5;

    private Insertion insertion = new Insertion();

    @Override
    protected void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo + switch2InsertLimit) {
            insertion.sort(arr, lo, hi);
            return;
        }

        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    public static void main(String[] args) {
        QuickInsert sort = new QuickInsert();
        Integer[] nums = new Integer[]{6, 1, 4, 3, 5, 2, 9, 7, 8};
        sort.sort(nums);

        sort.show(nums);
    }
}
