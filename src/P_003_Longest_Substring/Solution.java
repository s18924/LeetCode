package P_003_Longest_Substring;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        double time = System.currentTimeMillis();
        System.out.println(new Solution().lengthOfLongestSubstring("aabaab!bb"));
        System.out.println(System.currentTimeMillis() - time);
    }

    public int lengthOfLongestSubstring(String s) {

        int[] characterLastSeen = new int[255];
        Arrays.fill(characterLastSeen, -2);
        char[] word_splitted = s.toCharArray();

        int max_length = 0;
        int current_length = 0;
        int offset = -1;
        int dividedOffset = 0;

        for (int char_index = 0; char_index < word_splitted.length; char_index++) {
            if (characterLastSeen[word_splitted[char_index]] >= offset) {
                dividedOffset = Math.max(offset, 0);
                offset = characterLastSeen[word_splitted[char_index]] + 1;

                max_length = Math.max(current_length, max_length);

                current_length -= (offset - dividedOffset);
            }

            current_length++;
            characterLastSeen[(word_splitted[char_index])] = char_index;
        }

        max_length = Math.max(current_length, max_length);
        return max_length;
    }
}

/*

Runtime: 2 ms, faster than 99.86% of Java online submissions for Longest Substring Without Repeating Characters.
Memory Usage: 39.6 MB, less than 84.18% of Java online submissions for Longest Substring Without Repeating Characters.


Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */