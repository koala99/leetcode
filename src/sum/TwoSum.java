package sum;

import java.util.HashMap;
import java.util.Map;

//1. 两数之和
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

    //
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
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
