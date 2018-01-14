package leetcode.base;

import java.util.logging.Level;

/**
 * Created by lilei on 2017/7/4.
 */
public class RevertInt {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        int negative = 1;

        if(x <= Integer.MIN_VALUE)
            return 0;
        if(x < 0)
        {
            x = -x;
            negative = -1;
        }

        long y = x % 10;

        while(x / 10 != 0)
        {
            System.out.println(y);

            x /= 10;
            y *= 10;
            y += x %10;

        }

        if(y > Integer.MAX_VALUE)
            return 0;
        else
            return (int)y * negative;
    }
}
