public class question_day2{

    public static int longestCommonSubsequence(String str1, String str2) {
          // Ensure str2 is the shorter to minimize memory
        if (str2.length() > str1.length()) {
            String tmp = str1; str1 = str2; str2 = tmp;
        }
        int n = str1.length(), m = str2.length();
        int[] dp = new int[m + 1]; // dp[j] for j in [0..m]

        for (int i = 1; i <= n; i++) {
            int prevDiag = 0; // dp[i-1][j-1]
            for (int j = 1; j <= m; j++) {
                int temp = dp[j]; // store old dp[i-1][j] before overwriting
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[j] = prevDiag + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prevDiag = temp;
            }
        }
        return dp[m];
    }
}