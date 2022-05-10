package com.markbdsouza.searching;

public class LinearSearch {

    public static void main(String[] args) {
        int[] a = new int[]{35, 61, 71, 23, 7, 17, 29};
        System.out.println("Index of 61-" + linearSearch(a, 35));
        System.out.println("Index of 30-" + linearSearch(a, 30));
    }

    /**
     * @param a      - list of integers in any order
     * @param target - the number to be searched for
     * @return - index of the element. -1 if not found
     */
    public static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++){
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

}