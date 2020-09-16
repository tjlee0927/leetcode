/****************************************** PROBLEM 1 QUESTION ******************************************
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

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
 ****************************************** END ******************************************/
import java.util.HashMap;
public class Problem1 {
    public static int romanToInt(String s) {
        int sum = 0;

        HashMap<Character, Integer> romanNumerals = new HashMap<Character, Integer>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char next_c;
            if (i == s.length() - 1) {
                next_c = s.charAt(i); }
            else {
                next_c = s.charAt(i+1);
            };
            int char_num = romanNumerals.get(c);

            if(romanNumerals.containsKey(c)) {

                if(romanNumerals.get(c) < romanNumerals.get(next_c)) {
                    char_num = -char_num;
                }
                sum = sum + char_num;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
