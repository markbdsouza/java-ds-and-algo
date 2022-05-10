package com.markbdsouza.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int a = 0;
        System.out.println(a);
        int[] myArr = doSort (new int[]{3,51,17,31,82,6});
        for (int i : myArr) {
            System.out.print(i+",");
        }

    }

    private static int[] doSort(int[] arr) {

        for(int i=1; i<arr.length;i++){
            int j = i-1;
            int el = arr[i];
            while(j>=0 && arr[j]>el){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = el;

            for (int a : arr) {
                System.out.print(a+",");

            }
            System.out.println("");
        }
        return arr;
    }
}
