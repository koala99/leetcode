import java.util.*;

public class DoublePoint {

    //26. 删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    // 283. 移动零  用两个下标来判断
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[j] == 0) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    // 28. 实现 strStr()
    public int strStr(String haystack, String needle) {
        int res = -1;
        int len = needle.length();
        int lenhay = haystack.length();
        if (lenhay < len)
            return -1;
        int star = 0;
        int end = len - 1;
        while (end < lenhay) {
            if (haystack.substring(star, end + 1).equals(needle)) {
                return star;
            }
            end++;
            star++;
        }
        return -1;
    }

    //88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先归并大的，这样一遍扫面即可。
        for (int k = m + n - 1, i = m - 1, j = n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }
            if (j < 0) {
                nums1[k] = nums1[i--];
                continue;
            }

            if (nums1[i] >= nums2[j])
                nums1[k] = nums1[i--];
            else
                nums1[k] = nums2[j--];
        }
    }

    //349. 两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int minLen = Math.min(nums1.length, nums2.length);
        int[] res = new int[minLen];

        for (int num : nums1) {
            set.add(num);
        }

        int k = 0;
        for (int num : nums2) {
            if (set.contains(num)) {
                res[k++] = num;
                set.remove(num);
            }
        }

        return Arrays.copyOf(res, k);
    }

    // 344 翻转字符串
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int left = -1;
        int right = s.length;
        while (++left < --right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
        }

        return;
    }

    //350. 两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //先遍历第一个数组，并初始化map
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i]) + 1);
            else
                map.put(nums1[i], 1);
        }

        //再遍历第二个数组，将于map中找到的key放入list中
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                list.add(nums2[j]); //添加到list中
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }

        //最后，将list中的值放入数组中
        int count = list.size();
        int[] aux = new int[count];
        for (int i = 0; i < count; i++) {
            aux[i] = list.poll();
        }
        return aux;
    }

    //977. 有序数组的平方
    public int[] SortedSquares(int[] A) {
        if (A.length == 0) return null;
        int[] temp = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        int x = temp.length - 1;

        while (i <= j) {
            if (A[j] * A[j] >= A[i] * A[i]) {
                temp[x] = A[j] * A[j];
                j--;
            } else {
                temp[x] = A[i] * A[i];
                i++;
            }
            x--;
        }
        return temp;
    }


    //125. 验证回文串
    public boolean isPalindrome(String s) {
        int len = s.length();
        s = s.toLowerCase(); //统一转为小写
        int i = 0, j = len - 1;
        while (i < j) {
            //跳过非法字符
            while (!isAlphanumeric(s.charAt(i))) {
                i++;
                //匹配 "   " 这样的空白字符串防止越界
                if (i == len) {
                    return true;
                }
            }
            while (!isAlphanumeric(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    private boolean isAlphanumeric(char c) {
        if ('a' <= c && c <= 'z' || 'A' <= c && c <= 'Z' || '0' <= c && c <= '9') {
            return true;
        }
        return false;
    }

    //345. 反转字符串中的元音字母
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<Character>() {
            {
                add('a');
                add('o');
                add('e');
                add('i');
                add('u');
                add('A');
                add('O');
                add('E');
                add('I');
                add('U');
            }
        };

        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!set.contains(ci)) {
                result[i++] = ci;
            } else if (!set.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }


}
