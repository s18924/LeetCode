package P_338_Counting_Bits;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int z = 2;
        System.out.print(" ");
        for (int i = 0; i < 64; i++) {
          /*  if(i%(1<<z)==0) {
                System.out.println(">> " + i);
                z++;
            }
          //  System.out.println(i + " > " + Integer.bitCount(i) + (i%2==0? " parzysta   " : " nieparzysta") + "                    " + Integer.toBinaryString(i));
            System.out.println(Integer.bitCount(i) + (i%2==0? " parzysta   " : " nieparzysta") + "                    " + Integer.toBinaryString(i));*/
            System.out.print(Integer.bitCount(i) + "  ");
        }
        System.out.println();

        System.out.println(Arrays.toString(new Solution().countBits(64)));
    }

    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        if (num > 0)
            bits[1] = 1;

        int currentTop = 4;
        int halfFromPreviousTopToNext = currentTop - (currentTop / 4);
        int currentTopDiv4=0;
        int currentTopDiv2 = 0;
        for (int i = 1; i <= num; i++) {

            if (bits[i] != 0)
                continue;
            if(i%2==1) {
                bits[i] = bits[i - 1] + 1;
                continue;
            }
            if (i == currentTop) {
                currentTopDiv2=currentTop;
                currentTopDiv4 = currentTop/2;
                currentTop *= 2;
                halfFromPreviousTopToNext = currentTop -currentTopDiv4;

                bits[i] = 1;
                continue;
            }

            if (i <= halfFromPreviousTopToNext)
                bits[i] = 1 + bits[i - currentTopDiv2];
            else
                bits[i] = 1 + bits[i - currentTopDiv4];

        }
        return bits;
    }
}

/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]

Example 2:

Input: 5
Output: [0,1,1,2,1,2]

Follow up:

    It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
    Space complexity should be O(n).
    Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.


Runtime: 2 ms, faster than 64.91% of Java online submissions for Counting Bits.
Memory Usage: 43.1 MB, less than 96.84% of Java online submissions for Counting Bits.
 */

/*
public int[] countBits(int num) {
        int[] arr = new int[num+1];
        if(num<1) {
            return arr;
        }
        arr[0] = 0;
        arr[1] = 1;
        int val = 2;
        for(int i=2;i<=num;i++) {
            val = i%val==0 ? i : val;
            //System.out.println(val);
            arr[i] = arr[i-val]+1;
        }
        return arr;
    }

    Wzorcowe rozwiązanie
 */