package binary;

public class BinaryTest {
    public static void main(String[] args) {
        System.out.print(oneNum(7));
    }

    /**
     * 实现一个方法，判断一个正整数是否是2的乘方（比如16是2的4次方，返回True；18不是2的乘方，返回False）。要求性能尽可能高。
     */
    public static boolean isPowerof2(int num) {
        int rnum = num & (num - 1);
        return rnum == 0 ? true : false;
    }

    /**
     * 实现一个方法，求出一个正整数转换成二进制后的数字“1”的个数。要求性能尽可能高。
     */
    public static int oneNum(int num) {
        int count = 0;
        num = Math.abs(num);
        while (num > 0) {
            ++count;
            num = num & (num - 1);
            System.out.print(num);
        }
        return count;
    }
}
