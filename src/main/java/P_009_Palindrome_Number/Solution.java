package P_009_Palindrome_Number;

public class Solution {
    public static void main(String[] args) {


        System.out.println(new Solution().isPalindrome(54321));
        System.out.println(new Solution().isPalindrome(54345));

    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        //checking how many digits number have:
        int numberOfDigits = (int) Math.floor(Math.log10(x) + 1);
        double nextLeftDigit;
        double nextRightDigit;

        for (int i = 0; i < numberOfDigits / 2; i++) {
            //Kolejna od lewej dla 54321
            // (5)4321 uzyskamy dzieląc bez reszty przez 10 do potęgi liczby cyfr, a potem usuwamy modulo 10
            // 5(4)321 =>  54321 / 1000 = 54 -> 54%10 = 4
            nextLeftDigit = Math.floor(x / Math.pow(10, numberOfDigits - 1 - i)) % 10;

            //kolejna od prawej dla 54321 ->
            // 5432(1) uzyskamy biorąc resztę modulo 10 (10 do potęgi miejsca na którym znajduje się liczba+1) dzielone na 10^miejsca
            // 543(2)1 => 54321%100 = 21 -> 21 / 10 = 2
            nextRightDigit = Math.floor(x % Math.pow(10, i + 1) / Math.pow(10, i));
            if (nextLeftDigit != nextRightDigit)
                return false;
        }
        return true;
    }
}
