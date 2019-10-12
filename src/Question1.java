import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    //3. 无重复字符的最长子串
    public static int lengthOfLongestSubstring(String s) {
        int length = 0;
        int max = 0;
        List list = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            String tmpChar = String.valueOf(s.charAt(i));
            if (list.contains(tmpChar)) {
                length = 0;
                int index = list.indexOf(tmpChar);
                for (int j = 0; j < index + 1; j++) {
                    list.remove(0);
                }
            }
            list.add(tmpChar);
            length = list.size();
            if (max < length)
                max = length;
        }
        return max;
    }

    //4. 寻找两个有序数组的中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0) {
            if (length2 % 2 != 0) {
                return nums2[length2 / 2];
            } else {
                return (nums2[length2 / 2] + nums2[length2 / 2 - 1]) / 2d;
            }
        }
        if (length2 == 0) {
            if (length1 % 2 != 0) {
                return nums1[length1 / 2];
            } else {
                return (nums1[length1 / 2] + nums1[length1 / 2 - 1]) / 2d;
            }
        }
        int total = length1 + length2;
        if (total % 2 == 1) {
            return find_kth(nums1, 0, nums2, 0, total / 2 + 1);
        }
        return (find_kth(nums1, 0, nums2, 0, total / 2) + find_kth(nums1, 0, nums2, 0, total / 2 + 1)) / 2.0;
    }

    static double find_kth(int[] a, int a_begin, int[] b, int b_begin, int k) {
        if (a_begin >= a.length)
            return b[b_begin + k - 1];
        if (b_begin >= b.length)
            return a[a_begin + k - 1];
        if (k == 1)
            return Math.min(a[a_begin], b[b_begin]);
        int mid_a = Integer.MAX_VALUE;
        int mid_b = Integer.MAX_VALUE;
        if (a_begin + k / 2 - 1 < a.length)
            mid_a = a[a_begin + k / 2 - 1];
        if (b_begin + k / 2 - 1 < b.length)
            mid_b = b[b_begin + k / 2 - 1];
        if (mid_a < mid_b)
            return find_kth(a, a_begin + k / 2, b, b_begin, k - k / 2);
        return find_kth(a, a_begin, b, b_begin + k / 2, k - k / 2);
    }

    //5. 最长回文子串
    public String longestPalindrome(String s) {
        //中心发散法
        int length = s.length();
        if (length == 0)
            return "";
        int longSize = 1;
        String longStr = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            String odd = centerSpread(s, length, i, i);
            String even = centerSpread(s, length, i, i + 1);
            String maxLen = odd.length() > even.length() ? odd : even;
            if (maxLen.length() > longSize) {
                longSize = maxLen.length();
                longStr = maxLen;
            }
        }
        return longStr;
    }

    static String centerSpread(String s, int len, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex >= 0 && rightIndex < len && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }
        return s.substring(leftIndex + 1, rightIndex);
    }

}
