/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number
 * 
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
package leetcode;

import java.util.HashSet;

public class LeetCode202HappyNumber {

    public boolean isHappy(int n) {

        HashSet<Integer> visited = new HashSet<>();

        while (n != 1) {
            int result = 0;

            while (n >= 10) {
                int digit = n % 10;
                result = (int) (result + Math.pow(digit, 2));
                n = n / 10;
            }

            result = (int) (result + Math.pow(n, 2));

            if (visited.contains(result)) {
                return false;
            }
            visited.add(result);

            n = result;
        }

        return true;

    }
}
