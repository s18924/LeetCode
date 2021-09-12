package P_007_Reverse_Integer;

public class Solution {
    public static void main(String[] args) {

        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
    }

    public int reverse(int x) {

        boolean isNegative = x < 0;
        int res;
        try {
            res = Integer.parseInt(new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString());
        }catch (NumberFormatException e) {
            return 0;
        }
        return isNegative ? -res : res;
    }

}

/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


Runtime: 2 ms, faster than 51.72% of Java online submissions for Reverse Integer.
Memory Usage: 37.1 MB, less than 49.50% of Java online submissions for Reverse Integer.
 */