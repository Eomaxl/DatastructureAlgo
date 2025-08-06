package com.neetcode150.oneDimensionDP;

import java.util.ArrayList;
import java.util.List;

/**
 * A string consisting of uppercase english characters can be encoded to a number using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 *
 * To decode a message, digits must be grouped and then mapped back into letters using the reverse of the mapping above. There may be multiple ways to decode a message. For example, "1012" can be mapped into:
 *
 * "JAB" with the grouping (10 1 2)
 * "JL" with the grouping (10 12)
 * The grouping (1 01 2) is invalid because 01 cannot be mapped into a letter since it contains a leading zero.
 *
 * Given a string s containing only digits, return the number of ways to decode it. You can assume that the answer fits in a 32-bit integer.
 *
 *
 * Example 1: Input s = "12", Output : 2, Explaination : "12" could be decoded as "AB" (1 2) or "L" (12)
 * Example 2: Input s = "01", Output : 0, Explaination : "01" cannot be decoded as because "01" cannot be mapped into a letter
 *
 * Constraints : 1 <= s.length() <= 100 , s consists of digits
 * */

public class DecodeWays {
    public int numDecodings(String s) {
       if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;

       int n = s.length();
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = s.charAt(0) != '0' ? 1 : 0;

       for(int i = 2; i <=n ; i++) {
           if(s.charAt(i-1) != '0'){
               dp[i] += dp[i-1];
           }

           int twoDigit = Integer.parseInt(s.substring(i-2, i));
           if(twoDigit >= 10 && twoDigit <= 26){
               dp[i] += dp[i-2];
           }
       }
       return dp[n];
    }
}
