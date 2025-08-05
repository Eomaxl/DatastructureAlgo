package com.neetcode150.twoDimensionDP;

public class PrintLongestCommonSubsequence {
    public String PrintLongestCommonSubsequence(String A, String B) {
        int m = A.length(), n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i<= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n, j =m;

        while(i >= 0 && j >= 0) {
            if(A.charAt(i-1) == B.charAt(j-1)) {
                sb.append(A.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
