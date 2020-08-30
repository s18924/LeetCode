package P_338_Counting_Bits;

public class Solution {
    public static void main(String[] args) {
        for (int i = 32; i >= 0; i--) {
            System.out.println(Integer.bitCount(i));
        }
    }
}
