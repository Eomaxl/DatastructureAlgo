package com.neetcode150.stack;

import java.util.Stack;

/**
 * You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.
 * Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day.
 * If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.
 *
 * Example 1: Input : temperatures = [30,38,30,36,35,40,28], Output: [1,4,1,2,1,0,0]
 * Example 2: Input : temperatures = [22,21,20], Output: [0,0,0]
 *
 * */
public class DailyTemperature {
    public static void main(String[] args) {
        int[] temp = {30,38,30,36,35,40,28};
        DailyTemperature dt = new DailyTemperature();
        int[] result = dt.dailyTemperatures(temp);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" | ");
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer[]> stack = new Stack<>();

        for(int i =0 ; i<temperatures.length; i++){
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[0]){
                Integer[] temp = stack.pop();
                res[temp[1]] = i -temp[1];
            }
            stack.push(new Integer[]{t,i});
        }
        return res;
    }
}
