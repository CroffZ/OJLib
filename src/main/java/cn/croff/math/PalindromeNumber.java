package cn.croff.math;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: 121
 * Output: true
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            int times = 1;
            while (x / times >= 10) {
                times *= 10;
            }
            while (times > 1) {
                int head = x / times;
                int tail = x % 10;
                if (head != tail) {
                    return false;
                }
                x = (x % times) / 10;
                times /= 100;
            }
            return true;
        }
    }
}
