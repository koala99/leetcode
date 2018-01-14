package leetcode.sum;

import java.util.*;

/**
 * Created by lilei on 2017/7/1.
 */
public class ThreeSum {
    public static void main(String args[]) {
        ThreeSum test = new ThreeSum();
        int[] array = {-1, 0, 1, 1, 2, -1, -4};
        Set<List<Integer>> retArray = test.threeSum(array);
        for (List<Integer> list : retArray) {
            System.out.println("   ");
            for (Integer data : list) {
                System.out.print(data + " ");
            }
        }
    }

    public Set<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        if (nums.length < 3)
            return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
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
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> item = new ArrayList<>();
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
        return list;
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int ret = 0;
        int closestDist = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
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
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    if (target - sum < closestDist) {
                        closestDist = target - sum;
                        ret = sum;
                    }
                    left++;
                } else if (sum > target) {
                    if (sum - target < closestDist) {
                        closestDist = sum - target;
                        ret = sum;
                    }
                    right--;
                } else {
                    return sum;
                }
            }
        }
        return ret;
    }
}
