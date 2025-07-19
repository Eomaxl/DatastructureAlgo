package com.neetcode150.slidingwindow;

import java.util.HashMap;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 * A substring is a contiguous sequence of characters within a string.
 * Example 1: Input s = "zxyzxyz" Output: 3
 * Example 2: Input s = "xxxx" Output: 1
 * */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str1 = "zxyzxyz";
        String str2 = "xxxx";
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(ls.lengthOfLongestSubstring(str1));
        System.out.println(ls.lengthOfLongestSubstring(str2));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l= 0, res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                 l = Math.max(l, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - l + 1);
        }
        return res;
    }
}
