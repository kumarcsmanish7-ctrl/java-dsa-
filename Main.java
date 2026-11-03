
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];

        // Find Longest Common Subsequence
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(
                        dp[i - 1][j],
                        dp[i][j - 1]
                    );
                }
            }
        }

        int lcs = dp[n][m];

        int deletions = n - lcs;
        int insertions = m - lcs;

        System.out.println("Deletions: " + deletions);
        System.out.println("Insertions: " + insertions);
        System.out.println("Total operations: " 
                           + (deletions + insertions));
    }
}
