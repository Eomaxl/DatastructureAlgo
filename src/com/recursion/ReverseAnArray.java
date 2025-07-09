package com.recursion;

public class ReverseAnArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverseArr(0,arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void reverseArr(int i , int[] arr){
        if (i >= arr.length/2){
            return;
        }
        swap(arr[i], arr[arr.length-i-1]);
        reverseArr(i+1, arr);
    }

    public static void swap(int i , int j){
        int temp = i;
        i = j;
        j = temp;
    }
}
