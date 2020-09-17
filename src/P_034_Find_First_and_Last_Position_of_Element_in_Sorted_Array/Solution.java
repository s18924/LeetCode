package P_034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 9, 9, 10}, 6)));

        //Check of the linear solution
        int[] worstCase = new int[700000000];
        Arrays.fill(worstCase,7);
        double time = System.currentTimeMillis();
        new Solution().searchRange(worstCase,7);
        System.out.println(System.currentTimeMillis() - time);

        System.out.println();

        time = System.currentTimeMillis();
        new Solution().searchRangeLog(worstCase,7);
        System.out.println(System.currentTimeMillis() - time);
    }

    public int[] searchRange(int[] nums, int target) { //Linear

        if( nums == null || nums.length == 0)
            return new int[]{-1, -1};


        if (target < nums[0] || target > nums[nums.length - 1]) //if target is less than first or greater than last digit, we know it's not in the array
            return new int[]{-1, -1};


        //Find first occurence of target number
        int left = 0;
        int right = nums.length;
        int current = right / 2;
        while (true) {
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

    public int[] searchRangeLog(int[] nums, int target) { //Full log

        if( nums == null || nums.length == 0)
            return new int[]{-1, -1};

        if (target < nums[0] || target > nums[nums.length - 1]) //if target is less than first or greater than last digit, we know it's not in the array
            return new int[]{-1, -1};

        //Find first occurence of target number
        int left = 0;
        int right = nums.length;
        int current = right / 2;
        while (true) {
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

        int[] solution = {current, current};        //value at index 0 is left border, and at value 1 is right

        int tempRight = right;
        int tempLeft = left;
        while (true) {  //Binary search right
            if (solution[1] == nums.length-1)
                break;

            if( nums[solution[1]] == target && nums[solution[1]+1] != target)
                break;
            else if(nums[solution[1]] == target && nums[solution[1]+1] == target){
                tempLeft = solution[1];
            }else {
                tempRight = solution[1];
            }
            solution[1] = ( tempLeft + tempRight ) /2 ;
        }

        tempRight = right;
        tempLeft = left;
        while (true) {
            if (solution[0] == 0)
                break;

            if( nums[solution[0]] == target && nums[solution[0]-1] != target)
                break;
            else if(nums[solution[0]] == target && nums[solution[0]-1] == target){
                tempRight = solution[0];
            }else {
                tempLeft = solution[0];
            }
            solution[0] = ( tempLeft + tempRight ) /2 ;
        }

        return solution;
    }
}