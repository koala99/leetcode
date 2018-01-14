package leetcode.sum;

/**
 * Created by lilei on 2017/7/1.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,Because nums[0] + nums[1] = 2 + 7 = 9,return [0, 1].
 */
public class TwoSum {

    public int[] twoSum1(int[] nums, int target) {
        int[] array = new int[2];
        int n2;
        Integer index;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            n2 = target - nums[i];
            index = map.get(n2);
            if (index != null && index > i) {
                array[0] = i;
                array[1] = index;
                break;
            }
        }
        return array;
    }

    public static void main(String args[]) {
        TwoSum test = new TwoSum();
//        int[] array = {2, 4, 6, 8, 10, 9, 15};
        int[] array = {0, 0, 2, 0};

        int[] retArray = test.twoSum1(array, 0);
        for (int i : retArray) {
            System.out.print(i + ":");
        }
    }
}
