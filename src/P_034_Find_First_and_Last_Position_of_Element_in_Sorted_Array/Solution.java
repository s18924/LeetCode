package P_034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 9, 9, 10}, 6)));
    }

    public int[] searchRange(int[] nums, int target) {

        if( nums == null || nums.length == 0)
            return new int[]{-1, -1};


        if (target < nums[0] || target > nums[nums.length - 1]) //if target is less than first or greater than last digit, we know it's not in the array
            return new int[]{-1, -1};


        //Find first occurence of target number
        int left = 0;
        int right = nums.length;
        int current = right / 2;
        while (true) {
            System.out.println("> " + left + " " + right);
            if (nums[current] == target)
                break;
            if(right-left == 1)
                return new int[]{-1, -1};
            if (nums[current] > target) {
                right = current;
                current = (right - left) / 2;
            } else {
                left = current;
                current = left + (right - left) / 2;
            }
        }

      //  System.out.println(current + " " + nums[current]);
        int[] solution = {current, current};
        //value at index 0 is left border, and at value 1 is right

        while (true) {
            if (solution[1] == nums.length-1)
                break;

            if (nums[++solution[1]] != target) {
                solution[1]--;
                break;
            }
        }


        while (true) {
            if (solution[0] == 0)
                break;
            if (nums[--solution[0]] != target) {
                solution[0]++;
                break;
            }
        }

        return solution;
    }
}