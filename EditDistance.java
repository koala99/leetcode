/**
 * Created by lilei on 16/7/30.
 */
public class EditDistance {
    public static int edit(char[] str1, char[] str2, int k) {
        int[][] dp = new int[1000][1000];
        int length1 = str1.length;
        int length2 = str2.length;
        dp[0][0] = 0;
        //初始化填满数据
        for (int i = 1; i <= length1; i++) {
            dp[i][0] = i * k;
        }
        for (int i = 1; i <= length2; i++) {
            dp[0][i] = i * k;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1],
                            dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String args[]) {
        System.out.print(edit("abc".toCharArray(), "abcderf".toCharArray(), 1));
    }
}
