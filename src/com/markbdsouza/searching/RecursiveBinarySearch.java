package com.markbdsouza.searching;

public class RecursiveBinarySearch {

    public static void main(String[] args) {

        int[] a = new int[]{16, 24, 36, 51, 52, 55, 78, 90};
        System.out.println("Index of 51:" + revcursiveBinarySearch(a, 51, 0, a.length-1));
        System.out.println("Index of 78:" + revcursiveBinarySearch(a, 78, 0, a.length-1));
        System.out.println("Index of 100:" + revcursiveBinarySearch(a, 100, 0, a.length-1));
    }

    /**
     * @param a      - list of integers in sorted ascending order
     * @param target - the number to be searched for
     * @return - index of the element. -1 if not found
     */
    private static int revcursiveBinarySearch(int[] a, int target, int p, int r) {
        if (p > r) return -1;
        int q = (p + r) / 2;
        if (a[q] < target) {
            p = q + 1;
            return revcursiveBinarySearch(a, target, p, r);
        } else if (a[q] > target) {
            r = q - 1;
            return revcursiveBinarySearch(a, target, p, r);
        } else return q;
    }
}

