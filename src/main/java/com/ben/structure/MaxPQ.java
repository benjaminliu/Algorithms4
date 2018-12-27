package com.ben.structure;

/**
 * Created by Ashley on 2018/12/27.
 */
public class MaxPQ<T extends Comparable<T>> {

    private T[] pq;

    private int N = 0;

    public MaxPQ() {

    }

    public MaxPQ(int max) {
        pq = (T[]) new Comparable[max + 1];
    }

    public MaxPQ(T[] arr) {
        pq = arr;
    }

    public void Insert(T v) {
        pq[++N] = v;
        swim(N);
    }

    public T max() {
        return null;
    }

    public T delMax() {
        T max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= size()) {
            int j = 2 * k;
            if (j < size() && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
}
