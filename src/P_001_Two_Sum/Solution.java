package P_001_Two_Sum;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{1, 2, 3, 4}, 7)));
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> alreadyVisited = new HashMap<>();

        alreadyVisited.put(nums[0],0);

        for (int i = 1; i < nums.length ; i++) {
            if(alreadyVisited.containsKey(target-nums[i]))
                return new int[]{alreadyVisited.get(target-nums[i]),i};
            if(!alreadyVisited.containsKey(nums[i]))
                alreadyVisited.put(nums[i],i);
        }
        return null;
    }
}


/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Runtime: 1 ms, faster than 99.97% of Java online submissions for Two Sum.
Memory Usage: 39.4 MB, less than 90.88% of Java online submissions for Two Sum.

29 / 29 test cases passed.
Status: Accepted
Runtime: 1 ms
Memory Usage: 39.4 MB
 */
