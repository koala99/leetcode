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
}
