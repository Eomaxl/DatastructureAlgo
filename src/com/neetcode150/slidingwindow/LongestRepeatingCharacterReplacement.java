package com.neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * You are given a string s consisting of only uppercase english characters and an integer k.
 * You can choose up to k characters of the string and replace them with any other uppercase English character.
 * After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
 * Example 1: Input s = "XYYX" , k = 2, Output : 4
 * Example 2: Input s = "AAABABB" , k =1, Output = 5
 * */

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str1 = "XYYX";
        String str2 = "AAABABB";
        LongestRepeatingCharacterReplacement lcr = new LongestRepeatingCharacterReplacement();
        System.out.println(lcr.characterReplacement(str1,2));
        System.out.println(lcr.characterReplacement(str2,1));
    }

    public int characterReplacement(String s, int k) {
       int res = 0;
       HashSet<Character> charSet = new HashSet<Character>();
       for(char c : s.toCharArray()) {
           charSet.add(c);
       }

       for (char c: charSet) {
           int count = 0, l =0;
           for (int r = 0; r < s.length(); r++) {
               if(s.charAt(r) == c){
                   count++;
               }

               while((r - l + 1) - count > k){
                   if(s.charAt(l) == c) {
                       count--;
                   }
                   l++;
               }
               res = Math.max(res, r - l + 1) ;
           }
       }
       return res;
    }

}
