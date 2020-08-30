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
        bits[0] = 0;
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


Runtime: 2 ms, faster than 64.91% of Java online submissions for Counting Bits.
Memory Usage: 43.1 MB, less than 96.84% of Java online submissions for Counting Bits.
 */