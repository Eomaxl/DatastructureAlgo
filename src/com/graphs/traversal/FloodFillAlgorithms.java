package com.graphs.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same colour as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on.
 * Replace the colour of all of the aforementioned pixels with the newColor.
 *
 * Input: image = [ [1, 1, 1], [1, 1, 0], [1, 0, 1] ], sr = 1, sc = 1, newColor = 2
 * Output: [ [2, 2, 2], [2, 2, 0], [2, 0, 1] ]
 *
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
 * all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 *
 *
 *
 * */

public class FloodFillAlgorithms {
    private static int[][] direction = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) {
        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int[][] result = floodFill(image,1, 1, 2);
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        if(image[sr][sc] == newColor) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];

        int[][] result = new int[rows][cols];
        for(int i = 0; i<rows; i++){
            System.arraycopy(image[i], 0, result[i],0, cols);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr,sc});
        result[sr][sc] = newColor;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            for(int[] dir : direction){
                int newRow = current[0] + dir[0];
                int newCol = current[1] + dir[1];

                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && result[newRow][newCol] == oldColor){
                    queue.offer(new int[]{newRow,newCol});
                    result[newRow][newCol] = newColor;
                }
            }
        }
        return result;
    }
}
