package MaxCreaseLengh;

/**
 * Created by lilei on 16/7/14.
 */

//最大递增子序列
public class Demo1 {
    public static int[] array = {3, 4, 2, 5, 6, 8, 13, 23, 21, 25, 14, 16, 13, 5, 6, 9, 45, 32};

    public static int getLong() {
        int n = array.length;
        float[] B = new float[n + 1];//数组B；
        B[0] = -10000;//把B[0]设为最小，假设任何输入都大于-10000；
        B[1] = array[0];//初始时，最大递增子序列长度为1的最末元素为a1
        int Len = 1;//Len为当前最大递增子序列长度，初始化为1；
        int p, r, m;//p,r,m分别为二分查找的上界，下界和中点；
        for (int i = 1; i < n; i++) {
            p = 0;
            r = Len;
            while (p <= r)//二分查找最末元素小于ai+1的长度最大的最大递增子序列；
            {
                m = (p + r) / 2;
                System.out.println("m:" + p + ":" + r + ":" + m);
                if (B[m] < array[i])
                    p = m + 1;
                else
                    r = m - 1;
            }
            B[p] = array[i];//将长度为p的最大递增子序列的当前最末元素置为ai+1;
            if (p > Len)
                Len++;//更新当前最大递增子序列长度；
        }
        return Len;
    }


    public static void main(String args[]) {
        System.out.print(getLong());
    }
}
