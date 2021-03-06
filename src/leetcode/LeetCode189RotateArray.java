/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
package leetcode;

public class LeetCode189RotateArray {

    public void rotate(int[] nums, int k) {

        int length = nums.length;

        if (k >= length) {
            k = k % length;
        }

        rotate(nums, 0, length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, length - 1);

        return;

    }

    private void rotate(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        return;
    }
}
