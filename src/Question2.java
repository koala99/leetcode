import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    //709. 转换成小写字母
    public static String toLowerCase(String str) {
        if (null == str) {
            return null;
        }
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 'A' && ch[i] <= 'Z') {
                ch[i] += 32;
            }
        }
        String s = new String(ch);
        return s;
    }

    //961. 重复 N 次的元素
    public static int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] == A[i - 1])
                return A[i];
        }
        return 0;
    }

    // 929. 独特的电子邮件地址
    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            //本地名称
            String name = email.substring(0, email.indexOf("@"));
            //域名
            String domain = email.substring(email.indexOf("@"));
            //根据指定规则解析后的本地名称，先按加号切割字符串，然后替换'.'
            String newName = name.substring(0, name.indexOf("+")).replaceAll(".", "");
            //使用HashSet去重
            set.add(newName + domain);
        }
        return set.size();
    }
}
