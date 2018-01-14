package 动态规划;

/**
 * Created by lilei on 2017/7/4.
 */
//如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元
//状态转移方程：d(3)=min{d(3-1)+1, d(3-3)+1}
//    d(5)=min{d(5-1)+1, d(5-5)+1}
// d(i)=min{ d(i-vj)+1 }，其中i-vj >=0，vj表示第j个硬币的面值;


public class MinCent {
    public static void main(String[] args) {
        bag();
    }

    public static void cent() {
        int sum = 11;
        int[] a = {1, 3, 5};
        int[] dp = new int[12];
        for (int i = 1; i <= sum; i++) {
            dp[i] = i;
            for (int j = 0; j < 3; j++) {
                if (i >= a[j] && dp[i - a[j]] + 1 < dp[i]) {
                    dp[i] = dp[i - a[j]] + 1;
                }
            }
        }
        System.out.print(dp[sum]);
    }

    public static void bag() {
        int[] weight = {3,4,6,2,5};
        int[] val = {6,8,7,5,9};
        int maxw = 10;
        int[] f = new int[maxw+1];
        for(int i=0;i<val.length;i++){
            for(int j=weight[i];j<f.length;j++){
                f[j] = Math.max(f[j], f[j-weight[i]]+val[i]);
            }
        }
        System.out.println(f[maxw]);
    }


}
