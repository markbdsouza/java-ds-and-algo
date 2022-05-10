package com.markbdsouza.sorting;

public class SelectionSort {



    public static void main(String[] args) {
    int[] myArr = doSelectionSort (new int[]{3,51,17,31,82,6});
        for (int i : myArr) {
            System.out.print(i+",");
        }

    }

    private static int[] doSelectionSort(int[] arr) {
        int minRemainingIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            minRemainingIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minRemainingIndex]){
                    minRemainingIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minRemainingIndex];
            arr[minRemainingIndex] = temp;
        }
        return arr;
    }
}
