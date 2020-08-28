package P_003_Longest_Substring;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("bbtablud"));
    }

    public int lengthOfLongestSubstring(String s) {
        if( s.length() == 0)
            return 0;
        if(s.charAt(0) ==  (' '))
            return 1;
        int[] characterLastSeen = new int['Z' - 'A' + 1];
        Arrays.fill(characterLastSeen, -1);
        char[] word_splitted = s.toCharArray();

        int max_length = 0;
        int current_length = 0;
        int offset = -1;

        for (int char_index = 0; char_index < word_splitted.length; char_index++) {
            if (characterLastSeen[word_splitted[char_index] -'a'] < offset) {
                current_length++;

            } else {
                offset = characterLastSeen[word_splitted[char_index]-'a'] ;
                if(current_length > max_length) {
                    max_length = current_length;
                    System.out.println("New max lenght " + max_length);
                }
                current_length++;
                current_length -= offset;

            }
           // System.out.println( (word_splitted[char_index] - 'a'));
            characterLastSeen[ (word_splitted[char_index] - 'a') ]  = char_index;

        }
        if(current_length > max_length) {
            max_length = current_length;
        }


        return max_length;
    }
}

/*
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