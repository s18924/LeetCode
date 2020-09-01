package P_013_Roman_To_Integer;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }

    public int romanToInt(String s) { //This one looks better, but works slower. Probably because of making a hashmap
        int number=0;

        HashMap<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I',1);
        romanToIntMap.put('V',5);
        romanToIntMap.put('X',10);
        romanToIntMap.put('L',50);
        romanToIntMap.put('C',100);
        romanToIntMap.put('D',500);
        romanToIntMap.put('M',1000);

        char[] romanDigits = s.toCharArray();


        int previousDigit = romanToIntMap.get(romanDigits[romanDigits.length-1]);
        number+= previousDigit;
        for (int i = romanDigits.length-2 ; i >=0 ; i--) { //Assuming that input will be correct, we know that if character is smaller than next character we need to divide it

            int currentDigit = romanToIntMap.get(romanDigits[i]);
            number+= currentDigit >= previousDigit ? +currentDigit : -currentDigit;
            previousDigit = currentDigit;
        }



        return number;
    }
  /*  public int romanToInt(String s) {

        int number = 0;
        char[] romanDigits = s.toCharArray();
        for (int i = 0; i < romanDigits.length; i++) {
            if (i != romanDigits.length - 1) { //If our character is not last in array, there may be something after him that change value

                if (romanDigits[i] == 'I') {
                    if (romanDigits[i + 1] >= 'V') { //As we know that only V and X are >= than V, we can save one equation
                        if (romanDigits[i + 1] == 'V') //If it's V, then we add 4
                            number += 4;
                        else number += 9; //else it must be X, so we add 9
                        i++; //and increase i, because we used two chracters
                    } else number += 1;
                    continue;
                }

                if (romanDigits[i] == 'X') {
                    if (romanDigits[i + 1] == 'C') { //Above makes no sense, as we do only two equation -.-
                        number += 90;
                        i++;
                    } else if (romanDigits[i + 1] == 'L') {
                        number += 40;
                        i++;
                    } else number += 10;
                    continue;

                }

                if (romanDigits[i] == 'C') {
                    if (romanDigits[i + 1] == 'D') { //Above makes no sense, as we do only two equation -.-
                        number += 400;
                        i++;
                    } else if (romanDigits[i + 1] == 'M') {
                        number += 900;
                        i++;
                    } else number += 100;
                    continue;
                }


            }
            switch (romanDigits[i]) {
                case 'I':
                    number += 1;
                    break;
                case 'V':
                    number += 5;
                    break;
                case 'X':
                    number += 10;
                    break;
                case 'L':
                    number += 50;
                    break;
                case 'C':
                    number += 100;
                    break;
                case 'D':
                    number += 500;
                    break;
                case 'M':
                    number += 1000;
                    break;

            }

        }
        return number;

    }*/
}

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Runtime: 3 ms, faster than 100.00% of Java online submissions for Roman to Integer.
Memory Usage: 39.5 MB, less than 89.71% of Java online submissions for Roman to Integer.
 */