package com.recursion;

public class Palindrome {
    public static void main(String[] args){
        String str1 = "abcdedcba";
        String str2 = "abcde";
        System.out.println(isPalindrome(0,str1));
        System.out.println(isPalindrome(0,str2));
    }

    public static boolean isPalindrome(int idx, String str){
        if(idx >= str.length()/2){
            return true;
        }
        if(str.charAt(idx) != str.charAt(str.length() - 1 - idx)){
            return false;
        }
        return isPalindrome(idx+1, str);
    }
}
