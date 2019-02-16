package base;

import java.util.logging.Level;


public class Revert {
    //7 反转整数(java)
    public static int reverseInt(int x) {
        int negative = 1;

        if (x <= Integer.MIN_VALUE)
            return 0;
        if (x < 0) {
            x = -x;
            negative = -1;
        }

        long y = x % 10;

        while (x / 10 != 0) {
            System.out.println(y);

            x /= 10;
            y *= 10;
            y += x % 10;

        }

        if (y > Integer.MAX_VALUE)
            return 0;
        else
            return (int) y * negative;
    }

    // 8 字符串转换整数 (atoi)
    public static int myAtoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

    // 344 翻转字符串
    public static String reverseString(String s) {
        int length = s.length();
        char[] str = s.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            char temp = str[i];
            str[i] = str[length - 1 - i];
            str[length - 1 - i] = temp;
        }
        return new String(str);
    }

}
