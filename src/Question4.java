import java.util.*;

public class Question4 {
    //219. 存在重复元素 II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (i > k)
                hashSet.remove(nums[i - k - 1]);
            if (hashSet.contains(nums[i])) {
                return true;
            }
            hashSet.add(nums[i]);
        }
        return false;
    }

    //滑动窗口
    // 438. 找到字符串中所有字母异位词，超时
//    public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> ans = new ArrayList<>();
//        HashMap<Character, Integer> map = new HashMap<>();
//        HashMap<Character, Integer> map1 = new HashMap<>();
//
//        for (char tmpCh : s.toCharArray()) {
//            if (map.containsKey(tmpCh)) {
//                map.put(tmpCh, map.get(tmpCh) + 1);
//            } else {
//                map.put(tmpCh, 0);
//            }
//        }
//        map1.putAll(map);
//        if (s.length() < p.length()) {
//            return ans;
//        }
//        int left = 0, right = 0;
//        while (right < s.length()) {
//            char tmpCh = s.charAt(right);
//            if (map1.containsKey(tmpCh)) {
//                int value = map1.get(tmpCh);
//                if (value == 0) {
//                    map1.remove(tmpCh);
//                } else {
//                    map1.put(tmpCh, value - 1);
//                }
//                if (map1.isEmpty()) {
//                    ans.add(left);
//                    map1.putAll(map);
//                    left++;
//                    right = left;
//                } else {
//                    right++;
//                }
//            } else {
//                map1.clear();
//                map1.putAll(map);
//                left++;
//                right = left;
//            }
//        }
//        return ans;
//    }


    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }
        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }


   // 11. 盛最多水的容器
   public int maxArea(int[] height) {
       int max =0;
       int left=0;
       int right=height.length-1;
       while(left<right){
           int tmpMax=Math.min(height[left],height[right])*(right-left);
           if(tmpMax>max){
               max=tmpMax;
           }
           if(height[left]>height[right]){
               right--;
           }else{
               left++;
           }
       }
       return max;
   }

}
