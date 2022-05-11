package com.markbdsouza.searching;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{16, 24, 36, 51, 52, 55,78, 90};
        System.out.println("Index of 51:" + binarySearch(a, 51));
        System.out.println("Index of 78:" + binarySearch(a, 78));
        System.out.println("Index of 16:" + binarySearch(a, 16));
        System.out.println("Index of 100:" + binarySearch(a, 100));
    }

    /**
     * @param a      - list of integers in sorted ascending order
     * @param target - the number to be searched for
     * @return - index of the element. -1 if not found
     */
    private static int binarySearch(int[] a, int target) {
        int p = 0;
        int r = a.length - 1;
        while (p <= r) {
            int q = (p + r) / 2;
            if (a[q] < target) {
                p = q + 1;
            } else if (a[q] > target) {
                r = q - 1;
            } else return q;
        }
        return -1;
    }
}
