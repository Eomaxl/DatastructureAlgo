package com.ProPeers.BinarySearch.BasicBinarySearch;

/**
 * You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.
 * Return the index of the peak element.
 * Your task is to solve it in O(log(n)) time complexity.
 *
 * Example 1: Input: arr = [0,1,0] , Output: 1
 * Example 2: Input: arr = [0,10,5,2] , Output: 1
 *
 * */

public class PeakIndexInAMoutainArray {
    public int peakIndexInMountainArray(int[] arr){
        int l =0, r = arr.length-1, mid;

        while(l<=r){
            mid = l + (r-l)/2;
            if( arr[mid] > arr[mid+1]){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}
