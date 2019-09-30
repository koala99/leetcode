package base;

import java.lang.annotation.Retention;
import java.util.HashMap;
import java.util.Map;
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

    //  6. Z 字形变换
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        int curRow = 0;
        boolean isDown = false;
        int len = Math.min(s.length(), numRows);
        String[] rows = new String[len];
        for (int i = 0; i < len; i++)
            rows[i] = "";

        for (int i = 0; i < s.length(); i++) {
            rows[curRow] += s.substring(i, i + 1);
            if (curRow == 0 || curRow == numRows - 1)
                isDown = !isDown;
            curRow += isDown ? 1 : -1;
        }
        StringBuilder tmpBuilder = new StringBuilder("");
        for (String row : rows) {
            tmpBuilder = tmpBuilder.append(row);
        }
        return tmpBuilder.toString();
    }

    //9.回文数
    public boolean isPalindrome(int x) {
        if (x < 0 || x > Integer.MAX_VALUE)
            return false;
        String tmpStr = String.valueOf(x);
        if (tmpStr.length() < 2)
            return true;
        boolean isPalindrome = false;

        while (tmpStr.length() > 1) {
            if (tmpStr.charAt(0) == tmpStr.charAt(tmpStr.length() - 1)) {
                isPalindrome = true;
                tmpStr = tmpStr.substring(1, tmpStr.length() - 1);
            } else {
                return false;
            }
        }
        return isPalindrome;

    }


    //13. 罗马数字转整数
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }

    //14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if (ans.equals(""))
                return ans;
        }
        return ans;
    }


}
