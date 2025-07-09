package com.recursion;

import java.util.Scanner;

public class FibonnaciNumber {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        printFibonnaci(5);
    }

    public static int printFibonnaci(int n) {
        if(n <= 1)
            return n;
        System.out.print(n+" , ");
        return printFibonnaci(n - 1) + printFibonnaci(n - 2);
    }
}
