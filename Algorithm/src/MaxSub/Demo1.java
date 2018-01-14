package MaxSub;

/**
 * Created by lilei on 16/6/28.
 */
public class Demo1 {
    public static int[] arrays = {-1, 0, 2, 5, 3, -2, 9, -2, 1, -3, -12, 3, -4, 8, -7, 1, 9};


    public static int getMax(int[] arrays, int length) {
        int start = 0, end = 0;
        int maxSum;
        int[] dp = new int[length];
        dp[0] = arrays[0];
        maxSum = dp[0];
        int tmp = 0;
        for (int i = 1; i < length; i++) {

            if (dp[i - 1] < 0)  //前面的<0，直接丢弃
            {
                dp[i] = arrays[i];
                tmp = i; //记录起始位置
            } else {
                dp[i] = arrays[i] + dp[i - 1];  //往后求和
            }
            if (dp[i] >= maxSum)  //找到到i为止的最大子数组
            {
                maxSum = dp[i];  //最大...
                start = tmp;  //标记起始
                end = i;  //标记此时的结束位置
            }
        }
        System.out.println("起始:" + start + ":" + end);

        return maxSum;
    }

    public static int sumN(int [] array){
        int n=array.length;
        int all=array[n-1],start=array[n-1];
        int count=0;
        for(int i=n-2;i>=0;i--){
            if((start+array[i])>array[i]){
                start=start+array[i];
            }else{
                start=array[i];
            }
            if(all<start){
                all=start;
            }
            count++;
        }
        System.out.println("数组长度="+array.length+"||时间复杂度="+count);
        return all;
    }


    public static void main(String[] args) {
        System.out.println("最大值为:" + getMax(arrays, arrays.length));
        System.out.println(sumN(arrays));

    }
}
