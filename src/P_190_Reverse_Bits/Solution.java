package P_190_Reverse_Bits;

public class Solution {
    public static void main(String[] args) {
        new Solution().reverseBits(43261596);
    }
    public int reverseBits(int n) {
        System.out.println(new StringBuilder(Integer.toBinaryString(n)).reverse());
        return 0;
    }
}
