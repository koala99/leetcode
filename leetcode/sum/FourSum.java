package leetcode.sum;

/**
 * Created by lilei on 2017/7/1.
 */

import java.util.*;

/**
 * Given nums = [2, 7, 11, 15], target = 9,Because nums[0] + nums[1] = 2 + 7 = 9,return [0, 1].
 */
public class FourSum {
    public static void main(String args[]) {
        FourSum test = new FourSum();
        int[] array = {1, 0, -1, 0, -2, 2};
//        int[] array = {0, 0, 0, 0};

        List<List<Integer>> retArray = test.fourSum(array);
        for (List<Integer> list : retArray) {
            System.out.println("   ");
            for (Integer data : list) {
                System.out.print(data + " ");
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        if (nums.length < 4)
            return new ArrayList<List<Integer>>(list);
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            for (int i = k + 1; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (left > i + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right < nums.length - 2 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }
                    int sum = nums[k] + nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[k]);
                        item.add(nums[i]);
                        item.add(nums[left]);
                        item.add(nums[right]);
                        list.add(item);
                        left++;
                        right--;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(list);
    }
}
