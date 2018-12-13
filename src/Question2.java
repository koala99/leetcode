public class Question2 {
    //231. 2的幂
    public static boolean isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        int result = (n) & (n - 1);
        return result == 0;
    }

    //326. 3的幂
    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        double tmp = Math.log10(n) / Math.log10(3.0);
        if (Math.round(tmp) - tmp == 0)
            return true;
        else
            return false;
    }

    //   342. 4的幂
    public boolean isPowerOfFour(int n) {
//        return (num&(num-1)) ==0 && (num&0x55555555)==num;
        if (n <= 0)
            return false;
        if (n == 1)
            return true;
        double tmp = Math.log10(n) / Math.log10(4.0);
        if (Math.round(tmp) - tmp == 0)
            return true;
        else
            return false;
    }
}
