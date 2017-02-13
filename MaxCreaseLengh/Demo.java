package MaxCreaseLengh;

/**
 * Created by lilei on 16/7/14.
 */
public class Demo {

    public static int[] array = {3, 4, 2, 5, 6, 8, 13, 23, 21, 25, 14, 16, 13, 5, 6, 9, 45, 32};

        public static int getLong() {
        //存储最大的递增子数组
        int[] list = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            list[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((array[j] < array[i]) && (list[j] + 1 > list[i])) {
                    list[i] = list[j] + 1;
                }
            }
        }
        int max = 0;
        for (int k = 0; k < list.length; k++) {
            System.out.println("length:"+list[k]);
            if (list[k] > max)
                max = list[k];
        }
        return max;
    }
    public static int getLong1() {
        int max = 0;
        int[] dp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((array[j] < array[i]) && (dp[i] < dp[j]+1)) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        for(int i = 0; i < dp.length; i++) {
            System.out.println("length1:"+dp[i]);

            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }


    public static void main(String args[]) {
        System.out.println(getLong());
        System.out.println(getLong1());

    }
}
