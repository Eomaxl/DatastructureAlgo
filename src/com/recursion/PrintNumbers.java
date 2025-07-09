package com.recursion;

public class PrintNumbers {
    public static void main(String[] args){
        printNumber(5);
        System.out.println();
        printNumberAsc(1,5);
        System.out.println();
        printNumberBack(5);
    }

    public static void printNumber(int num){
        if(num < 1){
            return;
        }
        System.out.print(num+" , ");
        printNumber(num-1);
    }

    public static void printNumberAsc(int num, int tar){
        if(num > tar){
            return;
        }
        System.out.print(num+" , ");
        printNumberAsc(num+1,tar);
    }

    public static void printNumberBack(int num){
        if(num < 1){
            return;
        }
        printNumberBack(num-1);
        System.out.print(num+" , ");
    }
}
