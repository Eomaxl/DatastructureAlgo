package com.recursion;

public class SumOfFirstNNumbers {

    public static void main(String[] args){
        int result = sumOfFirstNNumbers(5, 0);
        System.out.println(result);
    }

    public static int sumOfFirstNNumbers(int n, int sum) {
        if(n == 0){
            return sum;
        }
        return sumOfFirstNNumbers(n - 1, sum + n);
    }
}
