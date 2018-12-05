import java.util.HashSet;
import java.util.Set;

public class Question1 {
    // 771. Jewels and Stones
    public static int numJewelsInStones(String J, String S) {
        int num = 0;
        Set set = new HashSet();
        for (char item : J.toCharArray()) {
            set.add(item);
        }
        for (char item : S.toCharArray()) {
            if (set.contains(item)) {
                num++;
            }
        }
        return num;
    }

    //  136.只出现一次的数字
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    //    137. 只出现一次的数字 II
    public static int singleNumber2(int[] nums) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int n : nums) {
                // 统计第i位的1的个数
                System.out.println(i + ":" + n + ":" + (n >> i) + ":" + ((n >> i) & 1));
                if (((n >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            //出现3次，n为3，可类推
            result |= (count[i] % 3) << i;
        }
        return result;
    }

    //260. 只出现一次的数字 III
    public static int[] singleNumber3(int[] nums) {
        int[] result = new int[2];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum ^ nums[i];
        }
        int flag = sum & (~(sum - 1));
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & flag) == 0) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];
            }
        }
        System.out.println(result[0] + ":" + result[1]);
        return result;
    }
}
