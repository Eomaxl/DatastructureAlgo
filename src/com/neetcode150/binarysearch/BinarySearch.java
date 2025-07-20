package com.neetcode150.binarysearch;
/**
 * You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
 * Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.
 * Your solution must run in O(logn) time
 * Example :  Input: nums = [-1,0,2,4,6,8], target = 4, Output: 3
 * Example :  Input: nums = [-1,0,2,4,6,8], target = 3, Output: -1
 * */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,2,4,6,8};
        BinarySearch obj = new BinarySearch();
        System.out.println(obj.search(nums, 4));
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while  (l < r) {
            int mid = l + (r - l)/2;
            if (nums[mid] >= target) {
                 r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if ( nums[mid] == target) {
                return mid;
            }
        }
        return ( l <nums.length && nums[l] == target) ? l : -1;
    }
}
