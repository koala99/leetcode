package common;

/**
 * Created by lilei on 16/7/28.
 */
public class StringToInt {
    public static int parseInt(String s) {
        if (s == null || s.equals(""))
            throw new IllegalArgumentException("参数不能为null或空串！");

        int result = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                result = result * 10 + (int) (c - '0');
            } else {
                throw new IllegalArgumentException("s中只能包含数字");
            }
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(parseInt("123"));
    }
}
