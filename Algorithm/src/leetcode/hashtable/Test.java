package leetcode.hashtable;

public class Test {
    public static void main(String[] args) {
        char diff = new Test().findTheDifference("abcds", "abcdse");
//        System.out.print(diff);
        int[] arrays = {2, 2, 4, 5, 6, 4, 5, 7, 6};
        System.out.print(new Test().singleNumber(arrays));
    }

    public char findTheDifference(String s, String t) {
        int a[] = new int[26];
        int len1 = s.length();
        int len2 = t.length();
        int i = 0;
        for (i = 0; i < len1; i++) {
            a[s.charAt(i) - 'a']++;
        }
        for (i = 0; i < len2; i++) {
            if (a[t.charAt(i) - 'a'] <= 0) {
                break;
            } else {
                a[t.charAt(i) - 'a']--;
            }
        }
        return t.charAt(i);
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
