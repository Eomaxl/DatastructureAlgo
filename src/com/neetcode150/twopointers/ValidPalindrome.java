package com.neetcode150.twopointers;
/**
 * Given a string s, return true if it is a palindrome, otherwise return false. A palindrome is a string that reads the same forward and backward.
 * It is also case-insensitive and ignores all non-alphanumeric characters. Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 * Example 1: Input s = "Was it a car or a cat I saw?", Output : true
 * Example 2: Input s = "tab a cat", Output : false
 *
 *
 * */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s1 = "Was it a car or a cat I saw?";
        String s2 = "tab a cat";
        ValidPalindrome v = new ValidPalindrome();
        System.out.println("Is the string '"+s1+"' palindrome ? "+v.isPalindrome(s1));
        System.out.println("Is the string '"+s2+"' palindrome ? "+v.isPalindrome(s2));
    }
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return false;

        for(int i =0, j = s.length()-1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }
}
