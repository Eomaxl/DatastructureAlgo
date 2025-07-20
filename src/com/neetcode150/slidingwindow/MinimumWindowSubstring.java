package com.neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, return the shortest substring of s such that every character in t,
 * including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
 * You may assume that the correct output is always unique.
 * Example 1 : Input : s = "OUZODYXAZV", t = "XYZ" Output = "YXAZ"
 * Example 2 : Input : s = "xyz", t = "xyz" Output: "xyz"
 * Example 3 : Input: s = "x", t = "xy" Output: ""
 * */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s1 = "OUZODYXAZV", s2 = "XYZ", s3 ="xyz", s4 ="xyz", s5 ="x", s6 = "xy";
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println("Example 1 :"+mws.minWindow(s1, s2));
        System.out.println("Example 2 :"+mws.minWindow(s3, s4));
        System.out.println("Example 3 : "+mws.minWindow(s5, s6));
    }

    public String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() == 0) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for ( char c : t.toCharArray() ) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1,-1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))){
                have++;
            }

            while ( have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
