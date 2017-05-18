/*
Source: https://leetcode.com/problems/range-sum-query-immutable/#/description
Keywords: Array, DP, Memoization

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/


public class NumArray {

    private static int[] sum;

    	public NumArray(int[] nums) {
    		for (int i = 1; i < nums.length; ++i)
    			nums[i] += nums[i - 1]; // calculate the sum of the indices
    			/*
    			            [-2, 0, 3, -5, 2, -1] becomes
    			    i = 1 : [-2, -2, 3, -5, 2, -1]
    			    i = 2 : [-2, -2, 1, -5, 2, -1]
    			    i = 3 : [-2, -2, 1, -4, 2, -1]
    			    i = 4 : [-2, -2, 1, -4, -2, -1]
    			    i = 5 : [-2, -2, 1, -4, -2, -3]
    			*/
    		this.sum = nums;
    	}

    	public int sumRange(int i, int j) {
    		return sum[j] - (i == 0 ? 0 : sum[i - 1]); // take the sum of index j - sum of index i
    	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
