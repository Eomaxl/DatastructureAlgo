package com.neetcode150.heapPriorityQueue;

import java.util.PriorityQueue;

/**
 * You are given an 2-D array points where points[i] = [xi, yi] represents the coordinates of a point on an X-Y axis plane.
 * You are also given an integer k.
 * Return the k closest points to the origin (0, 0).
 * The distance between two points is defined as the Euclidean distance (sqrt((x1 - x2)^2 + (y1 - y2)^2)).
 * You may return the answer in any order.
 *
 * Example 1: Input: points = [[0,2],[2,2]], k = 1, Output: [[0,2]]
 * */
public class KthClosestPointsToOrigin {
    public static void main(String[] args){
        int[][] points = {{0,2},{2,2}};
        KthClosestPointsToOrigin obj = new KthClosestPointsToOrigin();
        int[][] result = obj.kClosest(points, 1);
        for(int[] nums : result){
            System.out.println(nums[0] + " " + nums[1]);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        // Create a max heap bassed on the distance from the origin
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]));

        //Add points to the heap and remove the farthest point if heap size exceeds k
        for (int[] point : points) {
            maxheap.add(point);
            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }

        // Collect the k closest points from the heap
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = maxheap.poll();
        }
        return res;
    }
}
