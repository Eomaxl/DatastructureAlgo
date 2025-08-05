package com.neetcode150.twoDimensionDP;

public class LongestCommonSubString {
    public int longestCommonSubstring(String A, String B) {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1];
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
