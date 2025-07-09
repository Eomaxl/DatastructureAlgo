package com.recursion;
import java.util.ArrayList;
import java.util.List;

public class PrintSumSequenceOfSumK {
    public static void main(String[] args) {
        int[] arr = {1 , 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 10;
        printSubSequence(0,0, new ArrayList<>(),arr, target);
    }

    public static void printSubSequence(int idx,int sum, List<Integer> list ,int[] arr, int target) {
        if( idx == arr.length ) {
            if(sum == target) {
                System.out.println(list);
            }
            return;
        }

        list.add(arr[idx]);
        sum += arr[idx];
        printSubSequence(idx+1, sum, list,arr, target);
        list.remove(list.size()-1);
        sum -= arr[idx];
        printSubSequence(idx+1, sum, list,arr, target);
    }
}
