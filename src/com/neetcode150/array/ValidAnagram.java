package com.neetcode150.array;
/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * */
import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];
        Arrays.fill(arr,0);
        for(char ch : s.trim().toLowerCase().toCharArray()){
            arr[ch-'a']++;
        }
        for(char ch : t.trim().toLowerCase().toCharArray()){
            arr[ch-'a']--;
        }
        for(int i =0; i<26; i++){
            if(arr[i] != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String str1 = "rat";
        String str2 = "car";
        String str3 = "anagram";
        String str4 = "nagaram";
        System.out.println(validAnagram.isAnagram(str1, str2));
        System.out.println(validAnagram.isAnagram(str3, str4));
    }

}
// TC : O(n) and SC : O(1)