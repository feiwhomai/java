/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * Note:
 * 0 ≤ x, y < 2^31.
 * 
 * Example:
 * 
 * Input: x = 1, y = 4
 * 
 * Output: 2
 * 
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 
 * The above arrows point to positions where the corresponding bits are different.
 */
package leetcode;

public class LeetCode461HammingDistance {

    public int hammingDistance(int x, int y) {

        if (x == y) {
            return 0;
        }

        int result = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                result++;
            }
            x = x >> 1;
            y = y >> 1;
        }

        return result;
    }
}
