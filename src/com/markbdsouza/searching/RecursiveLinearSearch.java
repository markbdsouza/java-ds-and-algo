package com.markbdsouza.searching;

public class RecursiveLinearSearch {

    public static void main(String[] args) {
        int[] a = new int[]{35, 61, 71, 23, 7, 17, 29};
        System.out.println("Index of 29: " + recursiveLinearSearch(a, 29,0));
        System.out.println("Index of 100: " + recursiveLinearSearch(a, 100,0));
        System.out.println("Index of 71: " + recursiveLinearSearch(a, 71,0));
    }

    /**
     * @param a      - list of integers in any order
     * @param target - the number to be searched for
     * @return - index of the element. -1 if not found
     */
    private static int recursiveLinearSearch(int[] a, int target, int i) {
        if (i < a.length) {
            if (a[i] == target) return i;
            else return recursiveLinearSearch(a, target, i+1);
        } else return -1;
    }
}
