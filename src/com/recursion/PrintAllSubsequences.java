package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequences {
    public static void main(String[] args){
        int[] arr = {3 , 2, 1};
        printSubSequences(0,new ArrayList<>(), arr);
    }

    public static void printSubSequences(int i,List<Integer> result, int[] arr){
        if(i >= arr.length){
            System.out.println(result);
            return;
        }
        result.add(arr[i]);
        printSubSequences(i+1, result, arr);
        result.remove(result.size()-1);
        printSubSequences(i+1, result, arr);

    }
}
